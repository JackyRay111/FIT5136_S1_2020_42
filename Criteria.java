public class Criteria {
	
	//private int criteriaID; //add a new attribute and mutator and accessor ---Jiancong
	/*
// 	add a default constructor  ---Jiancong
// 	 */
// 	public Criteria(){
// 		criminalRecords = "";
// 		healthRecords = "";
// 		qualifications = new String[20];
// 		criteriaID = 0;
// 	}
	
	private int missionId;
    private String criminalRecords;
    private String healthRecords;
    private ArrayList<String[]> qualifications;

    public Criteria(){

    }

    public Criteria(int missionId, String criminalRecords, String healthRecords, ArrayList<String[]> qualifications) {
        this.missionId = missionId;
        this.criminalRecords = criminalRecords;
        this.healthRecords = healthRecords;
        this.qualifications = qualifications;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
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

    public ArrayList<String[]> getQualifications() {
        return qualifications;
    }

    public void setQualifications(ArrayList<String[]> qualifications) {
        this.qualifications = qualifications;
    }

