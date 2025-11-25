package CollegeAdmissionManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplicationDAO {

    public void applyForCourse(int studentId, int courseId) {

        // 1️⃣ Check if student exists
        if (!studentExists(studentId)) {
            System.out.println("Error: Student ID " + studentId + " does NOT exist!");
            return;
        }

        // 2️⃣ Check if course exists
        if (!courseExists(courseId)) {
            System.out.println("Error: Course ID " + courseId + " does NOT exist!");
            return;
        }

        // 3️⃣ Insert application if both IDs are valid
        String sql = "INSERT INTO applications(student_id,course_id) VALUES(?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            System.out.println("Application Submitted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔍 Check if student exists
    private boolean studentExists(int studentId) {
        String sql = "SELECT student_id FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            return rs.next();   // true if exists

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🔍 Check if course exists
    private boolean courseExists(int courseId) {
        String sql = "SELECT course_id FROM courses WHERE course_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            return rs.next();   // true if exists

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
