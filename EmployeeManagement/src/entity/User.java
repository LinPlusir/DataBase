package entity;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String power;
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		// TODO 自动生成的方法存根
		return id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public User(String username, String password, String power) {
		super();
		this.username = username;
		this.password = password;
		this.power = power;
	}
	public User( String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	
	
}
