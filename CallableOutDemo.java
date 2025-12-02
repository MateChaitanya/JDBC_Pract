import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.Types;

public class CallableOutDemo {

    public static void main(String[] args) {

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db1",
                "root",
                "Chaitu@123"
            );

            // 3. Prepare stored procedure call
            // Format: {call procedureName(?, ?)}
            CallableStatement cs = con.prepareCall("{call getStudentName(?, ?)}");

            // 4. Set IN parameter
            cs.setInt(1, 1);

            // 5. Register OUT parameter
            cs.registerOutParameter(2, Types.VARCHAR);

            // 6. Execute the procedure
            cs.execute();

            // 7. Fetch OUT parameter value
            String studentName = cs.getString(2);

            System.out.println("Student Name: " + studentName);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
