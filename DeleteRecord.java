import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteRecord {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to DB
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "Chaitu@123"
            );

            // 3. Write DELETE query
            String sql = "DELETE FROM student1 WHERE id = ?";

            // 4. Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // 5. Set id for record to delete
            ps.setInt(1, 101);

            // 6. Execute delete operation
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("No record found with this ID.");
            }

            // 7. Close DB connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
