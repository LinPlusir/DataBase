package entity;

public class Department {
	private int depart_id;
	private String depart_name;
	private String function;
	public int getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public Department(String depart_name, String function) {
		super();
		this.depart_name = depart_name;
		this.function = function;
	}
	public Department() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Department(int depart_id, String depart_name, String function) {
		super();
		this.depart_id = depart_id;
		this.depart_name = depart_name;
		this.function = function;
	}
	@Override
	public String toString() {
		return depart_name;
	}
	
}
