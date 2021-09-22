package test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserOperations
{
	
	Connection connectionObject = null;
	PreparedStatement pstObject;
	
	public boolean addUser(User user)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		connectionObject = dbObj.getCon();
		String query = "insert into \"user\".user_details(contact,firstname,lastname,address,age,username,password,usertype) VALUES(?,?,?,?,?,?,?,?);";
		int status = 0;
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setLong(1,user.getContact());
			pstObject.setString(2,user.getFirst_name());
			pstObject.setString(3, user.getLast_name());
			pstObject.setString(4,user.getAddress());
			pstObject.setInt(5,user.getAge());
			pstObject.setString(6,user.getUsername());
			pstObject.setString(7,user.getPassword());
			pstObject.setString(8,user.getUsertype());
			System.out.println(user.getPassword() +user.getFirst_name() );
			status = pstObject.executeUpdate(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		if(status == 1)
			return true;
		return false;
	}
	public List<User> readUser()
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		connectionObject = dbObj.getCon();
		List<User> userList = new ArrayList<User>();
		String query = "select * from \"user\".user_details where usertype != ? ";
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setString(1,"admin");
			ResultSet result = pstObject.executeQuery();
			while(result.next())
			{
				int id = result.getInt("id");
				int age = result.getInt("age");
				long contact = result.getLong("contact");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String address = result.getString("address");
				String username = result.getString("username");
				String password = result.getString("password");
				String usertype = result.getString("usertype");
				User user = new User(id,age,contact,address,firstname,lastname,username,password,usertype);
				userList.add(user);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userList;
	}
	public List<User> readUserTechnician()
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		connectionObject = dbObj.getCon();
		List<User> userList = new ArrayList<User>();
		String query = "select * from \"user\".user_details where usertype = ? ";
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setString(1,"user");
			ResultSet result = pstObject.executeQuery();
			while(result.next())
			{
				int id = result.getInt("id");
				int age = result.getInt("age");
				long contact = result.getLong("contact");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String address = result.getString("address");
				String username = result.getString("username");
				String password = result.getString("password");
				String usertype = result.getString("usertype");
				User user = new User(id,age,contact,address,firstname,lastname,username,password,usertype);
				userList.add(user);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userList;
	}
	public boolean deleteUser(User user)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		connectionObject = dbObj.getCon();
		int status = 0;
		String query = "delete from \"user\".user_details where id = ?;";	
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setInt(1,user.getId());
			status = pstObject.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(status == 1)
			return true;
		return false;
	}
	
	public boolean editUser(User user)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		Connection connectionObject = dbObj.getCon();
		String query = "update \"user\".user_details set contact = ?, firstname = ?, lastname = ?, address = ?, age = ? where id = ?;";
		int status = 0;
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setLong(1,user.getContact());
			pstObject.setString(2,user.getFirst_name());
			pstObject.setString(3, user.getLast_name());
			pstObject.setString(4,user.address);
			pstObject.setInt(5,user.getAge());
			pstObject.setInt(6,user.getId());
			status = pstObject.executeUpdate(); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(status == 1)
			return true;
		return false;
	}
	public User readSingleUser(int id)
	{
		DatabaseConnectivity dbObj = new DatabaseConnectivity();
		Connection connectionObject = dbObj.getCon();
		String query = "select * from \"user\".user_details where id = ?";
		User user=null;
		try
		{
			pstObject = connectionObject.prepareStatement(query);
			pstObject.setInt(1,id);
			ResultSet result = pstObject.executeQuery();
			while(result.next())
			{
				int ID = result.getInt("id");
				int age = result.getInt("age");
				long contact = result.getLong("contact");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String address = result.getString("address");
				user = new User(ID,age,contact,address,firstname,lastname);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return user;
	}
}

