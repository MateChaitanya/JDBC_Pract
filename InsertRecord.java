import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecord {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection to the database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "Chaitu@123"
            );

            // 3. Write SQL query with ? placeholders (dynamic values)
            String sql = "INSERT INTO student1(id, name, marks) VALUES (?, ?, ?)";

            // 4. Create PreparedStatement object
            PreparedStatement ps = con.prepareStatement(sql);

            // 5. Set values for each ? placeholder
            ps.setInt(1, 101);             // ID
            ps.setString(2, "Amit");       // Name
            ps.setInt(3, 88);              // Marks

            // 6. Execute the insert query
            int result = ps.executeUpdate();

            // 7. Check if insert was successful
            if (result > 0) {
                System.out.println("Record inserted successfully!");
            }

            // 8. Close the connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
