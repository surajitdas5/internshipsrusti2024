package mypackage;
//Step 1: import package
import java.sql.*;
import java.util.Scanner;

public class InsertData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Roll: ");
			int roll = Integer.parseInt(sc.nextLine());
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("Mobile: ");
			long mobile = Long.parseLong(sc.nextLine());
			System.out.println("Email: ");
			String email = sc.nextLine();
			System.out.println("CGPA: ");
			double cgpa = Double.parseDouble(sc.nextLine());
			
//			Step 2: load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Step 3: Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
//			String qry = "INSERT INTO student_info VALUES(2, 'sam', 8745896588, 'sam@gamil.com', 8.5)";
//			Step 4.1: Prepare Query
			String qry = "INSERT INTO student_info VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setString(4, email);
			ps.setString(2, name);
			ps.setLong(3, mobile);
			ps.setDouble(5, cgpa);
			ps.setInt(1, roll);
//			Step 4.2 Execute query
			int i = ps.executeUpdate();
			if(i == 1) {
				System.out.println("1 record inserted");
			}
//			Step 6: close
			ps.close();
			con.close();
		} catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
