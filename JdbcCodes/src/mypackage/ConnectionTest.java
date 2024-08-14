package mypackage;

// step 1: Import Package
import java.sql.*;

public class ConnectionTest {
	public static void main(String[] args) {
		try {
			// step 2: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 3: Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
			if(con!=null) {
				System.out.println("Connected...");
			}
			// step 6: close connection
			con.close();
		} catch(ClassNotFoundException ce) {
			System.out.println(ce);
		} catch(SQLException se) {
			System.out.println(se);
		}

	}

}
