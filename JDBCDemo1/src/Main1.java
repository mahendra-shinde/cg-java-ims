import java.sql.*;
public class Main1 {

	public static void main(String[] args) {
	//Step1 : Load Driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//step2: Establish Connection
		try {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe",
				"system","oracle");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from hr.employees");
		while(rs.next()) {
			System.out.println(rs.getString(2)+ " " + rs.getString(3)) ;
		}
		rs.close();
		st.close();
		con.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
