import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class CallableStatementDemo {

    public static void main(String[] args) {

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to Database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "Chaitu@123"
            );

            // 3. Prepare Callable Statement
            CallableStatement cs = con.prepareCall("{call getStudent(?)}");

            // 4. Set input parameter
            cs.setInt(1, 1);

            // 5. Execute stored procedure
            ResultSet rs = cs.executeQuery();

            // 6. Read output
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("marks")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
