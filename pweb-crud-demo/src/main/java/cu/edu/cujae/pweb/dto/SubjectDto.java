 package cu.edu.cujae.pweb.dto;



 public class SubjectDto {

protected Integer id_subject;
protected String subject;
private boolean newRecord;

	 public boolean isNewRecord() {
		 return newRecord;
	 }

	 public void setNewRecord(boolean newRecord) {
		 this.newRecord = newRecord;
	 }

public SubjectDto(){
	super();

}


public SubjectDto(Integer id_subject, String subject) {

	super();
	this.id_subject=id_subject;
	this.subject=subject;
}


public SubjectDto(SubjectDto subject){
	super();
	this.id_subject=subject.getId_subject();
	this.subject=subject.getSubject();
}


public Integer getId_subject() {
	return id_subject;
}


public String getSubject() {
	return subject;
}


public void setId_subject( Integer id_subject) {
	this.id_subject=id_subject;
}


public void setSubject( String subject) {
	this.subject=subject;
}


public String toString(){
	return subject.toString();

}

}
