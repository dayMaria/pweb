 package cu.edu.cujae.pweb.dto;
import java.util.Date;


 public class CourseDto {

protected Integer id_course;
protected String course_name;
protected Date begin_date;
protected Date end_date;
private boolean newRecord;

	 public boolean isNewRecord() {
		 return newRecord;
	 }

	 public void setNewRecord(boolean newRecord) {
		 this.newRecord = newRecord;
	 }



public CourseDto(){
	super();

}


public CourseDto(Integer id_course, String course_name, Date begin_date, Date end_date) {
	super();
	this.id_course=id_course;
	this.course_name=course_name;
	this.begin_date=begin_date;
	this.end_date=end_date;
}


public CourseDto(CourseDto course){
	super();
	this.id_course=course.getId_course();
	this.course_name=course.getCourse_name();
	this.begin_date=course.getBegin_date();
	this.end_date=course.getEnd_date();
}


public Integer getId_course() {
	return id_course;
}
public String getCourse_name() {
	return course_name;
}
public Date getBegin_date() {
	return begin_date;
}
public Date getEnd_date() {
	return end_date;
}
public void setId_course( Integer id_course) {
	this.id_course=id_course;
}
public void setCourse_name( String course_name) {
	this.course_name=course_name;
}
public void setBegin_date( Date begin_date) {
	this.begin_date=begin_date;
}
public void setEnd_date( Date end_date) {
	this.end_date=end_date;
}


public String toString(){
	return id_course.toString();
}

}
