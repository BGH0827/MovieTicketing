package 영화예매;

public class User {
	String id, password, name, gender;
	int age;
	
	public String getid() {
		return id;
	}
	public String getpassword() {
		return password;
	}
	public String getname() {
		return name;
	}
	public String getgender() {
		return gender;
	}
	public int getage() {
		return age;
	}
	
	public void setid(String id) {
		this.id = id;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	public void setage(int age) {
		this.age = age;
	}
}