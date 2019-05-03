package bean;

public class Student {
	private String id;
	private String name;
	private String psw;
	private String gender;
	private String birDate;
	public Student() { }//构造方法
	public Student(String id, String name, String psw, String gender, String birDate) {
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.gender = gender;
		this.birDate = birDate;
	}

	public String getId() {
		return id;
	}  //get方法

	public void setId(String id) {
		this.id = id;
	}  //set方法

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirDate() {
		return birDate;
	}

	public void setBirDate (String birDate) {
		this.birDate = birDate;
	}
}