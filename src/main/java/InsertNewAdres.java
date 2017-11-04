import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertNewAdres {

    public static void insertNewAdres() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id_adresu");
        int idAdresu = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj nazwe ulicy");
        String ulica = scanner.nextLine();

        System.out.println("Podaj numer domu");
        int numerDomu = scanner.nextInt();
        scanner.nextLine();

        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName(DatabaseConnection.getConnection(););
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Main.DB_URL, Main.USER, Main.PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            sql = "INSERT INTO adresy (id_adresu, ulica, numer_domu)" +
                    "VALUES (" + idAdresu + ", '" + ulica + "', " + numerDomu + ")";

            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample

