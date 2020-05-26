package FIT5136_Implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *  The class is to store the information of the Mission
 *
 *  @author JiancongLei(Jacky) Lei
 *  @Version 25/05/2020
 */
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

    /**
     * The  default constructor of the class Mission
     */
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

    /**
     * The Accessor method to get the Id of the mission
     *
     * @return A integer that contain the Id of the mission
     */
    public int getMissionId(){
        return missionId;
    }

    /**
     * The Accessor method to get the name of the mission
     *
     * @return A String that contains the name of the mission
     */
    public String getMissionName (){
        return missionName;
    }

    /**
     * The Accessor method to get the description of the mission
     *
     * @return A sting that contains the description of the mission
     */
    public String getMissionDescription(){
        return missionDescription;
    }

    /**
     * The Accessor method to get the original country of the mission
     *
     * @return A string that contains the name of the original country
     */
    public String getCountryOfOrigin(){
        return  countryOfOrigin;
    }

    /**
     * The Accessor method to get the countries that is allowed in this mission
     *
     * @return A Sting contains all the countries name
     */
    public String getCountriesAllowed(){
        return countriesAllowed;
    }

    /**
     * The Accessor method to get the details about the mission coordinator
     *
     * @return A string contains all the details about the mission coordinator
     */
    public String getDetailsAboutCoordinator(){
        return detailsAboutCoordinator;
    }

    /**
     * The Accessor method to get the Status of the mission
     *
     * @return A string contains the status of the mission
     */
    public String getStatusOfTheMissionst(){
        return statusOfTheMission;
    }

    /**
     * The Accessor method to get the time of the launch
     *
     * @return A LocalDateTime that contain the time and date of the launch
     */
    public LocalDateTime getLaunchDate(){
        return launchDate;
    }

    /**
     * The Accessor method to get the location of the destination
     *
     * @return A string that contain the location of the destination
     */
    public String getLocationOfDestination(){
        return locationOfDestination;
    }

    /**
     * The Accessor method to get the duration of the mission
     *
     * @return A integer that contain the duration of the mission
     */
    public int getDuration(){
        return duration;
    }

    /**
     * The Accessor method to get the list of objects of class job
     *
     * @return ArrayList of job that contains a number of objects of class job
     */
    public ArrayList<Job> getListOfJob(){
        return listOfJob;
    }

    /**
     * The Accessor method to get the list of objects of class Cargo requirement
     *
     * @return ArrayList of CargoRequirement  that contains a number of objects of class CargoRequirement
     */
    public ArrayList<CargoRequirement> getListOfCargoRequirement(){
        return listOfCargoRequirement;
    }

    /**
     * The Accessor method to get the list of objects of class Employment requirement
     *
     * @return  ArrayList of EmploymentRequirement that contains a number of objects of class EmploymentRequirement
     */
    public ArrayList<EmploymentRequirement> getListOfEmploymentRequirement(){
        return listOfEmploymentRequirement;
    }

    /**
     * The Mutator method to set the Id of the mission
     *
     * @param missionId A integer that contain the Id of the mission
     */
    public void setMissionId(int missionId){
        this.missionId = missionId;
    }

    /**
     * The Mutator method to set the name of the mission
     *
     * @param missionName A string that contain the name of the mission
     */
    public void setMissionName(String missionName){
        this.missionName = missionName;
    }

    /**
     * The Mutator method to set the description of the mission
     *
     * @param missionDescription A string that contain the description of the mission
     */
    public void setMissionDescription(String missionDescription){
        this.missionDescription = missionDescription;
    }

    /**
     * The Mutator method to set the original country
     *
     * @param countryOfOrigin A String that contain the original country
     */
    public void setCountryOfOrigin(String countryOfOrigin){
        this.countryOfOrigin = countryOfOrigin;
    }

    /**
     * The Mutator method to set the countries that are allowed to cooperate in the mission
     *
     * @param countriesAllowed A string contains the countries name
     */
    public void setCountriesAllowed(String countriesAllowed){
        this.countriesAllowed = countriesAllowed;
    }

    /**
     * The Mutator method to set the launch time of the mission
     *
     * @param launchDate a localdatatime which will store the launch time of the mission
     */
    public void setLaunchDate(LocalDateTime launchDate){
        this.launchDate = launchDate;
    }

    /**
     * The Mutator method to set the duration of the mission
     *
     * @param duration A integer that contain the duration of the mission
     */
    public void setDuration(int duration){
        this.duration = duration;
    }

    /**
     * The Mutator method to set the location of the destination of the mission
     *
     * @param locationOfDestination A sting contains the location of the destination
     */
    public void setLocationOfDestination(String locationOfDestination){
        this.locationOfDestination = locationOfDestination;
    }

    /**
     * The Mutator method to set the status of the mission
     *
     * @param statusOfTheMission A string contains the status of the mission
     */
    public void setStatusOfTheMission(String statusOfTheMission){
        this.statusOfTheMission = statusOfTheMission;
    }

    /**
     * The Mutator method to set the details of the mission coordinator
     *
     * @param detailsAboutCoordinator the string contains the details of the mission coordinator
     */
    public void setDetailsAboutCoordinator(String detailsAboutCoordinator){
        this.detailsAboutCoordinator = detailsAboutCoordinator;
    }

    /**
     * The method to add one job objet to the list of job
     *
     * @param job one job object
     * @return boolean that indicate the successful addition
     */
    public boolean addJob(Job job){
        return this.listOfJob.add(job);
    }

    /**
     * The method to add one cargo requirement object to the list of the cargo requirement
     *
     * @param cargoRequirement one CargoRequirement object
     * @return boolean that indicate the successful addition
     */
    public boolean addCargoRequirement(CargoRequirement cargoRequirement){
        return this.listOfCargoRequirement.add(cargoRequirement);
    }

    /**
     * The method to add one employment object to the list of the employment requirement
     *
     * @param employmentRequirement one employment requirement object
     * @return boolean that indicate the successful addition
     */
    public boolean addEmploymentRequirement(EmploymentRequirement employmentRequirement){
        return this.listOfEmploymentRequirement.add(employmentRequirement);
    }

}
