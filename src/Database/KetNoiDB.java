package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Kiểm tra kết nối CSDL

public class KetNoiDB {
    public static void main(String[] args) {

        // Chú ý: Đổi tên databaseName
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hieunq23_QLSV;"
                + "user=sa;password=1234;instanceName=Admin\\SQLEXPRESS;encrypt=true;"
                + "trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            // Chú ý: Đổi tên STUDENTS = Tên bảng trong CSDL
            String SQL = "SELECT * FROM STUDENTS";
            ResultSet rs = stmt.executeQuery(SQL);

            // Chú ý: Đổi tên HoTen và Email = Tên cột trong CSDL
            while (rs.next()) {
                System.out.println(rs.getString("HoTen") + " " + rs.getString("Email"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
