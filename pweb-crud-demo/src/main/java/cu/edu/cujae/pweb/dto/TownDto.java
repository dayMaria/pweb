 package cu.edu.cujae.pweb.dto;

 public class TownDto {

protected Integer id_town;
protected String town;
	 private boolean newRecord;

	 public boolean isNewRecord() {
		 return newRecord;
	 }

	 public void setNewRecord(boolean newRecord) {
		 this.newRecord = newRecord;
	 }

public TownDto(){
	super();

}


public TownDto(Integer id_town, String town) {

	super();
	this.id_town=id_town;
	this.town=town;
}


public TownDto(TownDto town){
	super();
	this.id_town=town.getId_town();
	this.town=town.getTown();
}


public Integer getId_town() {
	return id_town;
}


public String getTown() {
	return town;
}


public void setId_town( Integer id_town) {
	this.id_town=id_town;
}


public void setTown( String town) {
	this.town=town;
}


public String toString(){
	return town.toString();

}




}
