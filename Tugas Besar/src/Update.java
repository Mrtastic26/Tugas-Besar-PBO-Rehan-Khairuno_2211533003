import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {


    private static final String URL = "jdbc:mysql://localhost:3308/users";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    public static void updateEmployeeCredentials(Scanner scanner) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE employees SET Username = ?, Password = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----UPDATE DATA LOGIN PEGAWAI----");
                System.out.print("employee ID: ");
                int employeeId = scanner.nextInt();
                
                System.out.print("new username: ");
                String newUsername = scanner.next();

                System.out.print("new pasword: ");
                String newPassword = scanner.next();

                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, newPassword);
                preparedStatement.setInt(3, employeeId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data login pegawai diupdate!");
                } else {
                    System.out.println("tidak ditemukan data pegawai dengan id tersebut");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}