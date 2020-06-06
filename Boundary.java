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
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars" + userName);
		System.out.println("********************************************************************************");
		System.out.println("1.Create Mission");
		System.out.println("2.Edit exited Mission");
		System.out.println("3.Edit exited Criteria");
		System.out.println("4.Log Out");
		System.out.println("Please enter your choice:");
	}

	public void displayHomepageForCoordinator(String userName){
		System.out.println("\f********************************************************************************");
		System.out.println("\t\t\t\t\t\tWelcome to Mission to Mars" + userName);
		System.out.println("********************************************************************************");
		System.out.println("1.Edit exited Mission");
		System.out.println("2.Log Out");
		System.out.println("Please enter your choice:");
	}
	public boolean displayLoginSuccessful() {
		return true;
	}
	public boolean displayCreateMission() {
		return true;
	}
	public boolean displayMissionInfo() {
		return true;
	}
	public boolean displayMissionCoordin() {
		return true;
	}
	public boolean displaySelectSpaceShuttle() {
		return true;
	}
	public boolean displayShuttleInfo() {
		return true;
	}
	public boolean displayShuttleConfirmed() {
		return true;
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

}
