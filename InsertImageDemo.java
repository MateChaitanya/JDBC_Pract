import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;

public class InsertImageDemo {

    public static void main(String[] args) {

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "Chaitu@123"
            );

            String sql = "INSERT INTO images(id, name, photo) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 1);
            ps.setString(2, "profile_pic");

            // Correct file path - NO extra quotes!
            File file = new File("C:/Users/HP/Downloads/WhatsApp Image 2025-11-13 at 12.18.43 PM.jpeg");
            FileInputStream fis = new FileInputStream(file);

            ps.setBinaryStream(3, fis, (int) file.length());

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Image inserted successfully!");
            }

            fis.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
