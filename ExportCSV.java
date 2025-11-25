package CollegeAdmissionManagementSystem;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    public class ExportCSV {

        public void generateCSV() {
            String sql = "SELECT s.name, c.course_name, a.status " +
                    "FROM applications a " +
                    "JOIN students s ON a.student_id = s.student_id " +
                    "JOIN courses c ON a.course_id = c.course_id";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 FileWriter fw = new FileWriter("admission_list.csv")) {

                fw.append("Student,Course,Status\n");

                while (rs.next()) {
                    fw.append(rs.getString(1)).append(",")
                            .append(rs.getString(2)).append(",")
                            .append(rs.getString(3)).append("\n");
                }

                System.out.println("CSV Generated Successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


