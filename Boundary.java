import com.sun.jdi.ArrayReference;

import javax.print.attribute.standard.JobName;
import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Boundary {
	public boolean displayLogin()
	{
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars");
		System.out.println("********************************************************************************");
		System.out.println("1.Log in");
		System.out.println("2.Exit the system");
		System.out.println("Please enter your choice:");
		return true;
	}

	public void displayShutDownSystem(){
		System.out.println('\f');
		System.out.println("System turn off! Have a GOOOOOD Day");
	}

	public boolean displayLoginFailed() {
		System.out.println("\fUser Name or Pass Word is wrong");
		return true;
	}

	public void displayHomePageForAdmin(String userName){
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars " + userName);
		System.out.println("********************************************************************************");
		System.out.println("1.Edit exited Mission");
		System.out.println("2.Select shuttle space to plan the mission");
		System.out.println("3.Edit exited Criteria");
		System.out.println("4. Create criteria");
		System.out.println("5.Log Out");
		System.out.println("Please enter your choice:");
	}

	public void displayHomepageForCoordinator(String userName){
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars " + userName);
		System.out.println("********************************************************************************");
		System.out.println("1.Create Mission");
		System.out.println("2.Edit exited Mission");
		System.out.println("3.Log Out");
		System.out.println("Please enter your choice:");
	}
	public boolean displayLoginSuccessful() {
		return true;
	}
	public boolean displayCreateMission() {
		return true;
	}
	public void displayMissionInfo(Mission mission) {
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tThe information for Misson: " + mission.getMissionName() + ": " + mission.getMissionId());
		System.out.println("********************************************************************************");
		/*System.out.println("Mission ID: " + mission.getMissionId());
		System.out.println("1.Mission Name: " + mission.getMissionName());
		System.out.println("2.Country Of Origin: " + mission.getCountryOfOrigin() );
		System.out.println("3.Country Allowed: " + mission.getCountriesAllowed());
		System.out.println("4. LaunchDate: " + mission.getLaunchDate().toString());
		System.out.println("5. location of destination: " + mission.getLocationOfDestination());
		System.out.println("6. duration: " + mission.getDuration());
		System.out.println("7. details about coordinator: " + mission.getDetailsAboutCoordinator());
		System.out.println("8. status of the mission: " + mission.getStatusOfTheMissionst());
		System.out.println("9. The job: " );
		System.out.println("10. The cargo requirement");
		System.out.println("11. The Employment requiremnt");*/
		mission.showMissionInfo();
	}

	public void displayTitleOfMissions(ArrayList<Mission> listOfMission){
		System.out.println('\f');
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars: select Mission to edit ");
		System.out.println("********************************************************************************");
		for(Mission mission: listOfMission){
			System.out.println("The mission ID: " + mission.getMissionId());
			System.out.println("The mission Name: " + mission.getMissionName());
			System.out.println("********************************************************************************");

		}
	}
	public boolean displayMissionCoordin() {

		return true;
	}
	public void displaySelectSpaceShuttle(ArrayList<SpaceShuttle> shuttleArrayList) {
		for(SpaceShuttle shuttle: shuttleArrayList){
			System.out.println("********************************************************************************");
			System.out.println("* Shuttle ID: " + shuttle.getShuttleId() + "\t\t Shuttle Name: " + shuttle.getShuttleName());
			System.out.println("1.Passenger Capacity: " + shuttle.getPassengerCapacity());
			System.out.println("2.Fuel Capacity: " + shuttle.getFuelCapacity());
			System.out.println("3.Travel Speed: " + shuttle.getTravelSpeed());
			System.out.println("4.Cargo Capacity: " + shuttle.getCargoCapacity());
			System.out.println("********************************************************************************");

		}
	}
	public void displayShuttleInfo(SpaceShuttle shuttle) {
		//shuttle.displayShuttleInfo();
	}
    public void displayShuttleConfirmed(SpaceShuttle shuttle) {
        System.out.println("");
        System.out.println("********************************************************************************");
        System.out.println("* Done! Shuttle Selected ");
        System.out.println("* Shuttle ID: " + shuttle.getShuttleId() + "\t\t Shuttle Name: " + shuttle.getShuttleName());
        System.out.println("********************************************************************************");
    }
	public boolean displayCreateCriteria() {
		return true;
	}
	public boolean displayCriteriaSelection() {
		return true;
	}
	public boolean displayConfirmCriteria() {
		return true;
	}
	public boolean displayCandidateList() {
		return true;
	}
	public boolean displayCandidatesInfo() {
		return true;
	}
	public boolean displayCandidateReply() {
		return true;
	}
	public boolean displayCandidateReplacement() {
		return true;
	}

	public int displayJobList(ArrayList<Job> jobList)	{
		int i = 0;
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars: display job info ");
		System.out.println("********************************************************************************");
		for(Job job: jobList){
			System.out.println(++i + " Job Name: " + job.getJobName());
			System.out.println("Job description:  " + job.getJobDescription());
					}
		return i;
	}

	public int displayCargoList(ArrayList<CargoRequirement> cargoRequirements)	{
		int i = 0;
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars: diplay cargo info ");
		System.out.println("********************************************************************************");
		for(CargoRequirement cargoRequirement: cargoRequirements){
			System.out.println(++i + " Cargo required Name: " + cargoRequirement.getCargoRequired());
			System.out.println("Cargo required quantities:  " + cargoRequirement.getCargoQuantitiesRequired());
		}
		return i;
	}

	public int displayEmployList(ArrayList<EmploymentRequirement> employmentRequirements)	{
		int i = 0;
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars: diplay employ info ");
		System.out.println("********************************************************************************");
		for(EmploymentRequirement employmentRequirement	: employmentRequirements){
			System.out.println(++i + " employ title: " + employmentRequirement.getTitles());
			System.out.println("employ required number:  " + employmentRequirement.getNumberOfEmployees());
		}
		return i;
	}

}
