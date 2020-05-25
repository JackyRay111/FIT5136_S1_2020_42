package FIT5136_Implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Mission {
    private int missionId;
    private String missionName;
    private String missionDescription;
    private String countryOfOrigin;
    private String countriesAllowed;
    private LocalDateTime launchDate;
    private String locationOfDestination;
    private int duration;
    private String detailsAboutCoordinator;
    private String statusOfTheMission;
    private ArrayList<Job> listOfJob;
    private ArrayList<CargoRequirement> listOfCargoRequirement;
    private ArrayList<EmploymentRequirement> listOfEmploymentRequirement;

    public Mission () {
        missionId = 0;
        missionName = "";
        missionDescription = "";
        countryOfOrigin ="";
        countriesAllowed = "";
        launchDate = LocalDateTime.now();
        duration = 0;
        detailsAboutCoordinator = "";
        statusOfTheMission = "";
        listOfJob = new ArrayList<Job>();
        listOfCargoRequirement = new ArrayList<CargoRequirement>();
        listOfEmploymentRequirement = new ArrayList<EmploymentRequirement>();
    }

    public int getMissionId(){
        return missionId;
    }

    public String getMissionName (){
        return missionName;
    }

    public String getMissionDescription(){
        return missionDescription;
    }

    public String getCountryOfOrigin(){
        return  countryOfOrigin;
    }

    public String getCountriesAllowed(){
        return countriesAllowed;
    }

    public String getDetailsAboutCoordinator(){
        return detailsAboutCoordinator;
    }

    public String getStatusOfTheMissionst(){
        return statusOfTheMission;
    }

    public LocalDateTime getLaunchDate(){
        return launchDate;
    }

    public String getLocationOfDestination(){
        return locationOfDestination;
    }

    public int getDuration(){
        return duration;
    }

    public ArrayList<Job> getListOfJob(){
        return listOfJob;
    }

    public ArrayList<CargoRequirement> getListOfCargoRequirement(){
        return listOfCargoRequirement;
    }

    public ArrayList<EmploymentRequirement> getListOfEmploymentRequirement(){
        return listOfEmploymentRequirement;
    }

    public void setMissionId(int missionId){
        this.missionId = missionId;
    }

    public void setMissionName(String missionName){
        this.missionName = missionName;
    }

    public void setMissionDescription(String missionDescription){
        this.missionDescription = missionDescription;
    }

    public void setCountryOfOrigin(String countryOfOrigin){
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setCountriesAllowed(String countriesAllowed){
        this.countriesAllowed = countriesAllowed;
    }

    public void setLaunchDate(LocalDateTime launchDate){
        this.launchDate = launchDate;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public void setLocationOfDestination(String locationOfDestination){
        this.locationOfDestination = locationOfDestination;
    }

    public void setStatusOfTheMission(String statusOfTheMission){
        this.statusOfTheMission = statusOfTheMission;
    }

    public void setDetailsAboutCoordinator(String detailsAboutCoordinator){
        this.detailsAboutCoordinator = detailsAboutCoordinator;
    }

    public boolean addJob(Job job){
        return this.listOfJob.add(job);
    }

    public boolean addCargoRequirement(CargoRequirement cargoRequirement){
        return this.listOfCargoRequirement.add(cargoRequirement);
    }

    public boolean addEmploymentRequirement(EmploymentRequirement employmentRequirement){
        return this.listOfEmploymentRequirement.add(employmentRequirement);
    }

}
