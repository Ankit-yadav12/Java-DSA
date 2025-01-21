package mysql;
import java.util.Scanner;

public class StudentClubApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        ClubManager clubManager = new ClubManager();
        MembershipManager membershipManager = new MembershipManager();

        while (true) {
            System.out.println("\n---- Student Activity Club Management ----");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Club");
            System.out.println("4. List Clubs");
            System.out.println("5. Add Membership");
            System.out.println("6. View Memberships");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter major: ");
                        String major = scanner.nextLine();
                        studentManager.addStudent(name, email, major);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.println("List of Students:");
                        studentManager.listStudents();
                        break;
                    case 3:
                        System.out.print("Enter club name: ");
                        String clubName = scanner.nextLine();
                        System.out.print("Enter club description: ");
                        String clubDescription = scanner.nextLine();
                        clubManager.addClub(clubName, clubDescription);
                        System.out.println("Club added successfully.");
                        break;
                    case 4:
                        System.out.println("List of Clubs:");
                        clubManager.listClubs();
                        break;
                    case 5:
                        System.out.print("Enter student ID: ");
                        int studentId = scanner.nextInt();
                        System.out.print("Enter club ID: ");
                        int clubId = scanner.nextInt();
                        membershipManager.addMembership(studentId, clubId); // Automatically uses today's date
                        System.out.println("Membership added with today's date.");
                        break;
                    case 6:
                        System.out.println("List of Memberships:");
                        membershipManager.viewMemberships();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
