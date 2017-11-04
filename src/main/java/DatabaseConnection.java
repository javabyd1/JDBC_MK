import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // SINGLETON PATTERN
    private static Connection connection = null;
    private final static String ADDRESS = "jdbc:mysql://localhost";
    private final static String DATABASE = "j1b?useSSL=false&useJDBCCompliantTimezoneShift=true" + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USER = "root";
    private final static String PASSWORD = "4444";
    private final static String PORT = "3360";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static void errorHandler(String message, Exception e) {

        System.out.println(message);
        if (e != null) {
            System.out.println(e.getMessage());
        }
    }

    private static void loadConnection() {
        try {
            connection = DriverManager.getConnection(getFormattedUrl(), USER, PASSWORD);
        } catch (SQLException e) {
            errorHandler("Failed to connect to the database " + getFormattedUrl(), e);
        }
    }

    private static String getFormattedUrl() {
        return ADDRESS + ":" + PORT + "/" + DATABASE;
    }


    private static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            errorHandler("Failed to load the driver " + DRIVER, e);
        }
    }

    public static void getConnection() {
        if (connection == null) {
            System.out.println("Tworze polaczenie");
            loadDriver();
            loadConnection();
        }
    }

    public static void closeConnetion() {
        if (connection == null) {
            errorHandler("No connection found", null);
        } else {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                errorHandler("Failed to close the connection", e);
            }
        }
    }
}
