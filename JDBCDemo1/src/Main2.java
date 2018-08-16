import java.sql.*;
public class Main2 {

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
		st.execute("drop table product");
		
		st.execute("CREATE TABLE product(pid numeric(3) primary key, pname varchar(20))");
		System.out.println("Table created");
		st.close();
		
		PreparedStatement ps = con.prepareStatement("INSERT into product VALUES(?,?)");
		ps.setInt(1, 101);
		ps.setString(2, "Mango Byte");
		int r = ps.executeUpdate();
		System.out.println(r+" rows created!");
		con.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
