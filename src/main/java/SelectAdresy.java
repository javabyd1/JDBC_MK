import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAdresy {

    public static void showAdresy() {

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Main.DB_URL, Main.USER, Main.PASS);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM j1b.adresy";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id_adresu");
                String streetName = rs.getString("ulica");
                int houseNumber = rs.getInt("numer_domu");
                int apartmentNumber = rs.getInt("numer_mieszkania");
                int postalCode = rs.getInt("kod_pocztowy");
                String city = rs.getString("miasto");
                String country = rs.getString("panstwo");
                String province = rs.getString("wojewodztwo");
                //Display values
                System.out.println("ID: " + id);
                System.out.println(", ulica: " + streetName);
                System.out.println(", numer domu: " + houseNumber);
                System.out.println(", numer mieszkania: " + apartmentNumber);
                System.out.println(", kod pocztowy: " + postalCode);
                System.out.println(", miasto: " + city);
                System.out.println(", panstwo: " + country);
                System.out.println(", wojewodztwo: " + province);
            }

            //STEP 6: Clean-up environment
            rs.close();
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

