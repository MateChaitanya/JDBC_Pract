import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.Types;

public class CallableInOutDemo {

    public static void main(String[] args) {

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Database connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db1",
                "root",
                "Chaitu@123"
            );

            // 3. Prepare call for INOUT procedure
            CallableStatement cs = con.prepareCall("{call increaseMarks(?)}");

            // 4. Set input value (IN)
            cs.setInt(1, 50);  // Suppose old marks are 50

            // 5. Register OUT type for same parameter
            cs.registerOutParameter(1, Types.INTEGER);

            // 6. Execute stored procedure
            cs.execute();

            // 7. Get updated marks
            int updatedMarks = cs.getInt(1);

            System.out.println("Updated Marks = " + updatedMarks);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
