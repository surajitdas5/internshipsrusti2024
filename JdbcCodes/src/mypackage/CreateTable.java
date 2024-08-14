package mypackage;
//step 1
import java.sql.*;
public class CreateTable {

	public static void main(String[] args) {
		try {
//			Step 2: load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Step 3: connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
//			Step 4: execute query
			String qry = "CREATE TABLE student_info(roll int, name varchar(20), mobile bigint, email varchar(30), cgpa float)"; 
			PreparedStatement ps = con.prepareStatement(qry);
			int i = ps.executeUpdate();
			if(i == 0) {
				System.out.println("Table Created");
			}
			
//			Step 6: close
			con.close();
		} catch(ClassNotFoundException ce) {
			System.out.println(ce);
		} catch(SQLException se) {
			System.out.println(se);
		}

	}

}
