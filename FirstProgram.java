import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstProgram {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",   // your DB name
                    "root",                               // username
                    "Chaitu@123"                            // password
            );

            // 3. Create Statement
            Statement st = con.createStatement();

            // 4. Execute Query
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            // 5. Process Results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println(id + " | " + name + " | " + marks);
            }

            // 6. Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
