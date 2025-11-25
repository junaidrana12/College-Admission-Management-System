package CollegeAdmissionManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    public class MeritService {

        //        public void processApplications() {
//            String sql = "SELECT a.application_id, s.marks_percentage, c.cut_off " +
//                    "FROM applications a " +
//                    "JOIN students s ON a.student_id = s.student_id " +
//                    "JOIN courses c ON a.course_id = c.course_id";
//
//            try (Connection con = DBConnection.getConnection();
//                 PreparedStatement ps = con.prepareStatement(sql);
//                 ResultSet rs = ps.executeQuery()) {
//
//                while (rs.next()) {
//                    int appId = rs.getInt(1);
//                    double marks = rs.getDouble(2);
//                    double cutOff = rs.getDouble(3);
//
//                    String status = (marks >= cutOff) ? "Approved" : "Rejected";
//
//                    updateStatus(appId, status);
//                }
//                System.out.println("Merit List Processed!");
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        private void updateStatus(int id, String status) throws Exception {
//            String sql = "UPDATE applications SET status=? WHERE application_id=?";
//
//            try (Connection con = DBConnection.getConnection();
//                 PreparedStatement ps = con.prepareStatement(sql)) {
//
//                ps.setString(1, status);
//                ps.setInt(2, id);
//                ps.executeUpdate();
//            }
//        }
//    }
        public void displayResults() {
            String sql = "SELECT a.application_id, s.name, c.course_name, a.status " +
                    "FROM applications a " +
                    "JOIN students s ON a.student_id = s.student_id " +
                    "JOIN courses c ON a.course_id = c.course_id";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("\n===== MERIT LIST RESULTS =====");
                while (rs.next()) {
                    System.out.println("Application ID: " + rs.getInt(1));
                    System.out.println("Student: " + rs.getString(2));
                    System.out.println("Course: " + rs.getString(3));
                    System.out.println("Status: " + rs.getString(4));
                    System.out.println("--------------------------");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
