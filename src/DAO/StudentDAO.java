/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import Model.Student;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class StudentDAO {
    //    lưu trữ kết nối, tương tác tới cơ sở dữ liệu
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Student> readStudent() {
        String sql = "SELECT * FROM STUDENTS";
        List<Student> studentLst = new ArrayList<>();
        //   chuẩn bị để thực thi truy vấn CSDL
        try (PreparedStatement ps = connection.prepareStatement(sql)){
        //   Thực hiện truy vấn SQL và về dữ liệu
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
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
}
