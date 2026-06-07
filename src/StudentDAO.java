import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDAO {
    public void addStudent(Student student) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO student(name,email,course) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM student";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("course"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String course) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE student SET course=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, course);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Student Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM student WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Student Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
