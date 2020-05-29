public class Criteria {
	private String criminalRecords;
	private String healthRecords;
	private String[] qualifications;
	
	
	
	
	public Criteria(String criminalRecords, String healthRecords, String[] qualifications) {
		super();
		this.criminalRecords = criminalRecords;
		this.healthRecords = healthRecords;
		this.qualifications = qualifications;
	}
	public String getCriminalRecords() {
		return criminalRecords;
	}
	public void setCriminalRecords(String criminalRecords) {
		this.criminalRecords = criminalRecords;
	}
	public String getHealthRecords() {
		return healthRecords;
	}
	public void setHealthRecords(String healthRecords) {
		this.healthRecords = healthRecords;
	}
	public String[] getQualifications() {
		return qualifications;
	}
	public void setQualifications(String[] qualifications) {
		this.qualifications = qualifications;
	}
	
}

}
