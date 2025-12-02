import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecordDemo {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db1",
                "root",
                "Chaitu@123"
            );

            // 3. SQL Insert Query (with ? placeholders)
            String sql = "INSERT INTO student1(id, name, marks) VALUES (?, ?, ?)";

            // 4. Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // 5. Set values for the placeholders
            ps.setInt(1, 11);               // id
            ps.setString(2, "Ramesh");      // name
            ps.setInt(3, 88);               // marks

            // 6. Execute update
            int result = ps.executeUpdate();

            // 7. Print result
            if (result > 0) {
                System.out.println("Record Inserted Successfully!");
            }

            // 8. Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
