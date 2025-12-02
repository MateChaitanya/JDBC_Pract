import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecordDemo {

    public static void main(String[] args) {

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Database Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "Chaitu@123"
            );

            // 3. SQL Query for UPDATE
            String sql = "UPDATE student1 SET name = ?, marks = ? WHERE id = ?";

            // 4. PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // 5. Set Values (update id=1)
            ps.setString(1, "Chaitanya Updated");  // new name
            ps.setInt(2, 95);                      // new marks
            ps.setInt(3, 11);                       // WHERE ID = 1

            // 6. Execute Update
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No record found with the given ID.");
            }

            // 7. Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
