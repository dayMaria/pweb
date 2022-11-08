 package cu.edu.cujae.pweb.dto;

 public class YearDto {

protected Integer id_year;
protected String year;
	 private boolean newRecord;

	 public boolean isNewRecord() {
		 return newRecord;
	 }

	 public void setNewRecord(boolean newRecord) {
		 this.newRecord = newRecord;
	 }


public YearDto(){
	super();

}


public YearDto(Integer id_year, String year) {

	super();
	this.id_year=id_year;
	this.year=year;
}


public YearDto(YearDto year){
	super();
	this.id_year=year.getId_year();
	this.year=year.getYear();
}


public Integer getId_year() {
	return id_year;
}


public String getYear() {
	return year;
}


public void setId_year( Integer id_year) {
	this.id_year=id_year;
}


public void setYear( String year) {
	this.year=year;
}


public String toString(){
	return year.toString();

}




}
