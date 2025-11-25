package CollegeAdmissionManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void registerStudent(String name, String email, String phone, double marks) {
        String sql = "INSERT INTO students(name,email,phone,marks_percentage) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setDouble(4, marks);

            ps.executeUpdate();
            System.out.println("Student Registered Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}