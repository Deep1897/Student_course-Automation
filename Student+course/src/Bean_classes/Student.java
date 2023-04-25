package Bean_classes;

public class Student {
	

	
	private int courseId;
	private String stname;
	private String email;
	private String password;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int courseId, String stname, String email, String password) {
		super();
		this.courseId = courseId;
		this.stname = stname;
		this.email = email;
		this.password = password;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [courseId=" + courseId + ", stname=" + stname + ", email=" + email + ", password=" + password
				+ "]";
	}

     
	
	

}
