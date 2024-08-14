package mypackage;
//step 1
import java.sql.*;
public class DisplayData {

	public static void main(String[] args) {
		try {
//			Step 2: load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Step 3: connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
//			Step 4: execute query
			String qry = "SELECT * FROM student_info"; 
			PreparedStatement ps = con.prepareStatement(qry);
//			Step 5: processing data 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int r = rs.getInt("roll");
				String n = rs.getString("name");
				double c = rs.getDouble("cgpa");
				String e = rs.getString("email");
				long m = rs.getLong("mobile");
				System.out.println(r+"\t"+n+"\t"+e+"\t"+m+"\t"+c);
			}
			
//			Step 6: close
			rs.close();
			ps.close();
			con.close();
		} catch(ClassNotFoundException ce) {
			System.out.println(ce);
		} catch(SQLException se) {
			System.out.println(se);
		}

	}

}
