package entity;

public class Post {
	private int post_id;
	private String post_name;
	private String post_salary;
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getPost_salary() {
		return post_salary;
	}
	public void setPost_salary(String post_salary) {
		this.post_salary = post_salary;
	}
	public Post(String post_name, String post_salary) {
		super();
		this.post_name = post_name;
		this.post_salary = post_salary;
	}
	public Post() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Post(int post_id, String post_name, String post_salary) {
		super();
		this.post_id = post_id;
		this.post_name = post_name;
		this.post_salary = post_salary;
	}
	@Override
	public String toString() {
		return post_name;
	}
	
}
