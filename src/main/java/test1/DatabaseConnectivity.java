package test1;
/*


For Reference : 

pst = conn.prepareStatement("delete from \"user\".user_details where id = 4;");
pst = conn.prepareStatement("insert into \"user\".user_details(contact,firstname,lastname,address,age) VALUES(?,?,?,?,?);");
pst.setInt(1, 100);
pst.setString(2, "rando1");
pst.setString(3, "rando2");
pst.setString(4, "rando3");
pst.setInt(5, 100);
status = pst.executeUpdate();
System.out.println(status);
 

*/
import java.sql.*;
public class DatabaseConnectivity 
{
	String username = "postgres";
	String password = "admin123";
	String url = "jdbc:postgresql://localhost:5432/postgres";
	
	Connection connectionObject = null;
	
	public Connection getCon()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			connectionObject = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return connectionObject;
	}
}
	