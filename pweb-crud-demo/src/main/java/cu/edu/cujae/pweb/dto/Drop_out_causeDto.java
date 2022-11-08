 package cu.edu.cujae.pweb.dto;


 public class Drop_out_causeDto {

protected Integer id_droup_out_cause;
protected String drop_out_cause;
	 private boolean newRecord;

	 public boolean isNewRecord() {
		 return newRecord;
	 }

	 public void setNewRecord(boolean newRecord) {
		 this.newRecord = newRecord;
	 }

public Drop_out_causeDto(){
	super();

}


public Drop_out_causeDto(Integer id_droup_out_cause, String drop_out_cause) {

	super();
	this.id_droup_out_cause=id_droup_out_cause;
	this.drop_out_cause=drop_out_cause;
}


public Drop_out_causeDto(Drop_out_causeDto drop_out_cause){
	super();
	this.id_droup_out_cause=drop_out_cause.getId_droup_out_cause();
	this.drop_out_cause=drop_out_cause.getDrop_out_cause();
}


public Integer getId_droup_out_cause() {
	return id_droup_out_cause;
}


public String getDrop_out_cause() {
	return drop_out_cause;
}


public void setId_droup_out_cause( Integer id_droup_out_cause) {
	this.id_droup_out_cause=id_droup_out_cause;
}


public void setDrop_out_cause( String drop_out_cause) {
	this.drop_out_cause=drop_out_cause;
}


public String toString(){
	return drop_out_cause.toString();

}




}
