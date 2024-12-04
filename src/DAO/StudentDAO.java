package DAO;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import Model.Student;
import java.sql.PreparedStatement;
import java.util.ArrayList;

// Lớp StudentDAO chứa các phương thức sử dụng để try vấn CSDL của bảng STUDENTS
public class StudentDAO {
    // Lưu trữ kết nối, tương tác tới cơ sở dữ liệu
    private Connection connection;
    // Đảm bảo khi khởi tạo StudentDAO để sử dụng truy vấn phải kết nối thành công
    public StudentDAO(Connection connection) {
        this.connection = connection;
    }
    
    // Phương thức readStudent() = SELECT * FROM STUDENTS
    public List<Student> readStudent() {
        // Chú ý: đổi tên bảng STUDENTS = tên bảng trong CSDL
        String sql = "SELECT * FROM STUDENTS";
        List<Student> studentLst = new ArrayList<>();
        //   chuẩn bị để thực thi truy vấn CSDL
        try (PreparedStatement ps = connection.prepareStatement(sql)){
        //   Thực hiện truy vấn SQL và về dữ liệu
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                // Chú ý: đổi tên MaSV, HoTen, Email, ... = tên cột trong CSDL
                String MaSV = rs.getString("MaSV");
                String HoTen = rs.getString("HoTen");
                String Email = rs.getString("Email");
                String SoDT = rs.getString("SoDT");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                Student student = new Student(MaSV, HoTen, Email, SoDT, GioiTinh, DiaChi);
                studentLst.add(student);
            } 
            return studentLst;
        } catch (Exception e) {
             e.printStackTrace();
             return studentLst;
        }
    }
    
    // Phương thức createStudent() = INSERT INTO STUDENTS VALUES ('MS001', 'Hieu', 'hieunq23@gmail.com', '0312', 1, 'Thien Loi')
    public void createStudent(Student student) {
        // Chú ý: đổi tên STUDENTS = tên bảng trong CSDL
        // (?, ?, ?, ?, ?, ?) = phải truyền giá trị tương ứng với các cột trong CSDL từ trên xuống dưới
        String sql = "INSERT INTO STUDENTS"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, student.getMaSV());         
            ps.setString(2, student.getHoTen());        
            ps.setString(3, student.getEmail());        
            ps.setString(4, student.getSoDT());         
            ps.setBoolean(5, student.isGioitinh());     
            ps.setString(6, student.getDiaChi()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Phương thức updateStudent() = UPDATE STUDENTS SET HoTen='Hieu', Email='hieunq23@gmail.com', SoDT='0312', GioiTinh=1, DiaChi='HP' WHERE MaSV=SV001
    public void updateStudent(Student student) {
        // Chú ý: đổi tên STUDENTS = tên bảng trong CSDL
        // Chú ý: đổi tên HoTen, Email, SoDT, ... = tên cột trong CSDL
        // ? = phải truyền giá trị tương ứng với câu truy vấn đặt trong biến String sql
        String sql = "UPDATE STUDENTS "
                + "SET "
                + "HoTen = ?, "
                + "Email = ?, "
                + "SoDT = ?, "
                + "GioiTinh = ?, "
                + "DiaChi = ? "
                + "WHERE MaSV = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)){        
            ps.setString(1, student.getHoTen());        
            ps.setString(2, student.getEmail()); 
            ps.setString(3, student.getSoDT());  
            ps.setBoolean(4, student.isGioitinh()); 
            ps.setString(5, student.getDiaChi()); 
            ps.setString(6, student.getMaSV()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Phương thức deleteStudent() = DELETE FROM STUDENTS WHERE MaSV = 'SV001'
    public void deleteStudent(String maSV) {
        // Chú ý: đổi tên STUDENTS = tên bảng trong CSDL
        // ? = phải truyền giá trị tương ứng với câu truy vấn đặt trong biến String sql
        String sql = "DELETE FROM STUDENTS "
                + "WHERE MaSV = ?  ";
        try (PreparedStatement ps = connection.prepareStatement(sql)){        
            ps.setString(1, maSV); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
