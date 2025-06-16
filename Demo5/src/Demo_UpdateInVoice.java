
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author HP
 */
public class Demo_UpdateInVoice {
    public static void main(String[] args) {
        String DB_URL =  "jdbc:sqlserver://localhost:1433;databaseName=SaleMNG;";
    
        Connection conn = null;
        PrepareStatement pstmt = null;
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(DB_URL, "sa","12345");
        
        pstmt = conn.prepareStatment("update tblInv_Detail set quantity=? " + "where invID like ? and proID=?");
        pstmt.setInt(1,10);
        pstmt.setString(2,"I00005");
        pstmt.setString(3,"CAMVP");
    
    }
    
}
