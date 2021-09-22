package test1;

public class User 
{
	int id;
	int age;
	long contact;
	String address;
	String first_name;
	String last_name;
	String username;
	String password;
	String usertype;
	
	//Constructors
	public User(int id,int age, long contact, String address, String first_name, String last_name,String username,String password,String usertype) 
	{
		super();
		this.id = id;
		this.age = age;
		this.contact = contact;
		this.address = address;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	public User(int id,int age, long contact, String address, String first_name, String last_name,String username,String password) 
	{
		super();
		this.id = id;
		this.age = age;
		this.contact = contact;
		this.address = address;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;

	}
	public User(int id,int age, long contact, String address, String first_name, String last_name) 
	{
		super();
		this.id = id;
		this.age = age;
		this.contact = contact;
		this.address = address;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	public User(int age, long contact, String address, String first_name, String last_name,String username,String password) 
	{
		super();
		this.age = age;
		this.contact = contact;
		this.address = address;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
	}
	public User(int id) 
	{
		super();
		this.id = id;
	}
	public User(int age, long contact, String address, String first_name, String last_name,String username,String password,String usertype) 
	{
		super();
		this.age = age;
		this.contact = contact;
		this.address = address;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	//Getters and Setters
	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
}
