import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecord {

    public static void main(String[] args) {

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open database connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "Chaitu@123"
            );

            // 3. Update SQL query
            String sql = "UPDATE student1 SET name = ?, marks = ? WHERE id = ?";

            // 4. PreparedStatement for dynamic values
            PreparedStatement ps = con.prepareStatement(sql);

            // 5. Set values
            ps.setString(1, "Rahul Updated");   // New name
            ps.setInt(2, 92);                   // New marks
            ps.setInt(3, 101);                  // Update where id = 101

            // 6. Execute update query
            int rows = ps.executeUpdate();

            // 7. Check if successful
            if (rows > 0) {
                System.out.println("Record updated successfully!");
            }

            // 8. Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
