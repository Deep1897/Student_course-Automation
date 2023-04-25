package Bean_classes;

public class Course {
	
	private int courseId;
	private String cname;
	private int cfee;
	private String cduration;
	
	
	
   public Course() {
	// TODO Auto-generated constructor stub
   }



public Course(int courseId, String cname, int cfee, String cduration) {
	super();
	this.courseId = courseId;
	this.cname = cname;
	this.cfee = cfee;
	this.cduration = cduration;
}



public int getCourseId() {
	return courseId;
}



public void setCourseId(int courseId) {
	this.courseId = courseId;
}



public String getCname() {
	return cname;
}



public void setCname(String cname) {
	this.cname = cname;
}



public int getCfee() {
	return cfee;
}



public void setCfee(int cfee) {
	this.cfee = cfee;
}



public String getCduration() {
	return cduration;
}



public void setCduration(String cduration) {
	this.cduration = cduration;
}



@Override
public String toString() {
	return "Course [courseId=" + courseId + ", cname=" + cname + ", cfee=" + cfee + ", cduration=" + cduration + "]";
}
   
   
   
   

}
