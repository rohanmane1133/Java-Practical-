import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private String department;

    public Student(String name, int rollNumber, String department) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void display() {
        System.out.println("Name      : " + name);
        System.out.println("Roll No.  : " + rollNumber);
        System.out.println("Department: " + department);
        System.out.println("---------------------------");
    }
}

public class SMS {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();

        studentList.add(new Student(name, roll, dept));
        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("❗ No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = sc.nextInt();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getRollNumber() == roll) {
                System.out.println("\nStudent found:");
                s.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        int roll = sc.nextInt();
        Iterator<Student> iterator = studentList.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getRollNumber() == roll) {
                iterator.remove();
                System.out.println("🗑️ Student deleted successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("❌ Student not found.");
        }
    }
}
