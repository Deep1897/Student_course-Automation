package Bean_classes;

public class Batch {
	
	private int courseId;
	private int batchId;
	private String bname;
	private int seat;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int courseId, int batchId, String bname, int seat) {
		super();
		this.courseId = courseId;
		this.batchId = batchId;
		this.bname = bname;
		this.seat = seat;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Batch [courseId=" + courseId + ", batchId=" + batchId + ", bname=" + bname + ", seat=" + seat + "]";
	}
	
	
	

}
