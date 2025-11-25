package CollegeAdmissionManagementSystem;

import java.util.Scanner;

    public class MainApp {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            StudentDAO studentDAO = new StudentDAO();
            ApplicationDAO applicationDAO = new ApplicationDAO();
            MeritService meritService = new MeritService();
            ExportCSV exportCSV = new ExportCSV();

            while (true) {
                System.out.println("\n===== ADMISSION MANAGEMENT SYSTEM =====");
                System.out.println("1. Register Student");
                System.out.println("2. Apply for Course");
                System.out.println("3. Process Merit List");
                System.out.println("4. Generate Admission CSV");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.next();

                        System.out.print("Enter Phone: ");
                        String phone = sc.next();

                        System.out.print("Enter Marks (%): ");
                        double marks = sc.nextDouble();

                        studentDAO.registerStudent(name, email, phone, marks);
                        break;

                    case 2:
                        System.out.print("Enter Student ID: ");
                        int studentId = sc.nextInt();

                        System.out.print("Enter Course ID: ");
                        int courseId = sc.nextInt();

                        applicationDAO.applyForCourse(studentId, courseId);
                        break;

                    case 3:
                        meritService.displayResults();
                        break;

                    case 4:
                        exportCSV.generateCSV();
                        break;

                    case 5:
                        System.out.println("Exiting... Thank You!");
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }
    }

