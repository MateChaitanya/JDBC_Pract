import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadRecord {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "Chaitu@123"
            );

            // 3. Create Statement object to run queries
            Statement st = con.createStatement();

            // 4. Execute SELECT query
            ResultSet rs = st.executeQuery("SELECT * FROM student1");

            // 5. Read each row from ResultSet
            while (rs.next()) {

                int id = rs.getInt("id");         // Get ID
                String name = rs.getString("name"); // Get Name
                int marks = rs.getInt("marks");     // Get Marks

                // 6. Print the record
                System.out.println(id + " | " + name + " | " + marks);
            }

            // 7. Close the connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
