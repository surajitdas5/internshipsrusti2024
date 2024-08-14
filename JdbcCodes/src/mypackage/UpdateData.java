package mypackage;
//Step 1: import package
import java.sql.*;
import java.util.Scanner;

public class UpdateData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Roll: ");
			int roll = Integer.parseInt(sc.nextLine());
			
			System.out.println("New Mobile: ");
			long mobile = Long.parseLong(sc.nextLine());
			System.out.println("New Email: ");
			String email = sc.nextLine();
			
//			Step 2: load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Step 3: Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
//			
//			Step 4.1: Prepare Query
			String qry = "UPDATE student_info set mobile = ?, email = ? WHERE roll = ?";
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setLong(1, mobile);
			ps.setString(2, email);
			ps.setInt(3, roll);
			
//			Step 4.2 Execute query
			int i = ps.executeUpdate();
			System.out.println(i+" record(s) updateds");
//			if(i == 1) {
//			}
//			Step 6: close
			ps.close();
			con.close();
		} catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
