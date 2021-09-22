package test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginOperations 
{
	public boolean isAdmin(String username,String password)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		Connection connectionObject = dbObj.getCon();
		PreparedStatement pstObject;
		String usertype = "";
		String query = "select * from \"user\".user_details where username = ? and password = ?"; 
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setString(1, username);
			pstObject.setString(2, password);
			ResultSet result = pstObject.executeQuery();
			while(result.next())
			{
				usertype = result.getString("usertype");
			}
			if(usertype.equals("admin"))
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	public boolean isTechnician(String username,String password)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		Connection connectionObject = dbObj.getCon();
		PreparedStatement pstObject;
		String usertype = "";
		String query = "select * from \"user\".user_details where username = ? and password = ?"; 
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setString(1, username);
			pstObject.setString(2, password);
			ResultSet result = pstObject.executeQuery();
			while(result.next())
			{
				usertype = result.getString("usertype");
			}
			if(usertype.equals("technician"))
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	public User loginValidation(String username,String password)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		Connection connectionObject = dbObj.getCon();
		PreparedStatement pstObject;
		User user = null;
		String query = "select * from \"user\".user_details where username = ? and password = ?"; 
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setString(1, username);
			pstObject.setString(2, password);
			ResultSet result = pstObject.executeQuery();
			while(result.next())
			{
				int id = result.getInt("id");
				int age = result.getInt("age");
				long contact = result.getLong("contact");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String address = result.getString("address");
				String uname = result.getString("username");
				String pword = result.getString("password");
				user = new User(id,age,contact,address,firstname,lastname,uname,pword);
				return user;
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return user;
	}
	public boolean isUserName(String username)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		Connection connectionObject = dbObj.getCon();
		PreparedStatement pstObject;
		int check = 0;
		String query = "select * from \"user\".user_details where username = ?"; 
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setString(1, username);
			ResultSet result = pstObject.executeQuery();
			while(result.next())
			{
				check = 1;
			}
			if(check == 0)
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	public boolean changePassword(int id,String newpassword)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		Connection connectionObject = dbObj.getCon();
		PreparedStatement pstObject;
		int status = 0;
		String query = "update \"user\".user_details set password=? where id = ?"; 
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setString(1, newpassword);
			pstObject.setInt(2, id);
			status = pstObject.executeUpdate(); 
			if(status==1)
				return true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
