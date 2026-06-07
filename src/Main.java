import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student student = new Student(name, email, course);

        StudentDAO dao = new StudentDAO();

        dao.addStudent(student);
        dao.viewStudents();
        dao.updateStudent(2, "Python");
        dao.viewStudents();
        dao.deleteStudent(2);
        dao.viewStudents();
        sc.close();
    }
}