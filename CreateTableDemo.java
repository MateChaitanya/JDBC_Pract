import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableDemo {

    public static void main(String[] args) {

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db1",
                "root",
                "Chaitu@123"
            );

            // 3. Create Statement
            Statement st = con.createStatement();

            // 4. SQL command to create table
            String sql = "CREATE TABLE student1 (" +
                         "id INT PRIMARY KEY, " +
                         "name VARCHAR(50), " +
                         "marks INT" +
                         ")";

            // 5. Execute SQL
            st.executeUpdate(sql);

            System.out.println("Table Created Successfully!");

            // 6. Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

