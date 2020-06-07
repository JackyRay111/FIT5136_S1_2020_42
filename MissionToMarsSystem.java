import javafx.scene.chart.ValueAxis;

import javax.crypto.spec.PSource;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.lang.System;
import java.util.SortedMap;

/**
 * The class is the control class of the softwar
 *
 * @author Jiancong Lei, Daniel and Geohe
 * @version 29/05/2020
 */
public class MissionToMarsSystem {
    private ArrayList<User> listOfUser;
    private ArrayList<SpaceShuttle> listOfSpaceShuttle;
    private ArrayList<Criteria> listOfCriteria;
    private ArrayList<Mission> listOfMission;
    private String selectedShuttle;


    static final int USERID = 0;
    static final int USERNAME = 1;
    static final int PASSWORD = 2;


    public MissionToMarsSystem (){
        listOfCriteria = new ArrayList<>();
        listOfMission = new ArrayList<>();
        listOfSpaceShuttle = new ArrayList<>();
        listOfUser = new ArrayList<>();
        selectedShuttle = "";
    }

    public ArrayList<Criteria> getListOfCriteria() {
        return listOfCriteria;
    }

    public ArrayList<Mission> getListOfMission() {
        return listOfMission;
    }

    public ArrayList<SpaceShuttle> getListOfSpaceShuttle() {
        return listOfSpaceShuttle;
    }

    public ArrayList<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfCriteria(ArrayList<Criteria> listOfCriteria) {
        this.listOfCriteria = listOfCriteria;
    }

    public void setListOfMission(ArrayList<Mission> listOfMission) {
        this.listOfMission = listOfMission;
    }

    public void setListOfSpaceShuttle(ArrayList<SpaceShuttle> listOfSpaceShuttle) {
        this.listOfSpaceShuttle = listOfSpaceShuttle;
    }

    public void setListOfUser(ArrayList<User> listOfUser) {
        this.listOfUser = listOfUser;
    }

    public void startMoudle(){
        Boundary boundary = new Boundary();
        FileIo fileIo = new FileIo();
        readListOfUser();
        readListOfMission();
        Validation validation = new Validation();
        int loginChoice = 0, homePageChoice = 0;
        boolean isLogOut = false;
        String userName, password;

        //start
        do{
        boundary.displayLogin();
        loginChoice = validation.acceptValidateChoiceInRange(1,2);
        if(loginChoice == 1){

            System.out.println("Please enter the Use Name:");
            userName = validation.acceptNoBlankStringInput();
            System.out.println("Please enter the PassWord:");
            password = validation.acceptNoBlankStringInput();

            if(verifyUser(userName, password)){
                User logInUser = new User();
                for (User user: listOfUser
                     ) {
                    if(user.getUserName().equals(userName)){
                        logInUser = user;
                    }
                }
                if(logInUser.getUserId().substring(0,1).equals("A"))// judge whether the user is Admin or Coordinator
                {
                    Administrator admin = new Administrator(logInUser.getUserName(),logInUser.getUserPassword(),logInUser.getUserId());
                    admin.setListOfMission(listOfMission);
                    do {
                        boundary.displayHomePageForAdmin(userName);
                        homePageChoice = validation.acceptValidateChoiceInRange(1, 4);
                        if (homePageChoice != 4) {
                            switch (homePageChoice) {
                                case 1: // edit mission
                                    int temp;
                                    boolean backHome = false;
                                    do {
                                        temp = chooseTheEditMission(listOfMission);
                                        if (temp != -1) {
                                            Mission mission = admin.modifyMission(temp);
                                            if (editMission(mission)) {
                                                admin.replaceMission(mission);
                                                fileIo.writeMissions(admin.stringInfo());
                                                continue;
                                            }
                                        } else {
                                            backHome = true;
                                        }
                                    }while (!backHome);

                                    break;
                                case 2: // select shuttle space
                                    System.out.println('\u000C');
                                    //Boundary boundary = new Boundary();
                                    Scanner console = new Scanner(System.in);

                                    //Shuttle information is read-only.
                                    readListOfShuttle();
                                    boundary.displaySelectSpaceShuttle(listOfSpaceShuttle);
                                    System.out.println("Enter Shuttle ID to Select Shuttle: ");
                                    int shuttleChoice = 0;
                                    try{
                                        shuttleChoice = console.nextInt();
                                    }
                                    catch(Exception e){
                                        System.out.println("INVALID Input");
                                    }
                                    console.nextLine();

                                    for(SpaceShuttle shuttle: listOfSpaceShuttle){
                                        if(shuttleChoice==shuttle.getShuttleId())
                                        {
                                            //console.nextLine();
                                            boundary.displayShuttleInfo(shuttle);
                                            selectedShuttle = shuttle.getShuttleName();
                                            boundary.displayShuttleConfirmed(shuttle);
                                        }

                                    }

                                    break;
                                case 3: //edit criteria
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            isLogOut  = true; // logOut
                        }
                    }while (!isLogOut);
                }else if (logInUser.getUserId().substring(0,1).equals("M")){
                    MissionCoordinator missionCoordinator = new MissionCoordinator(logInUser.getUserName(),logInUser.getUserPassword(),logInUser.getUserId());
                    missionCoordinator.setListOfMission(readMissionForCoordinator(missionCoordinator.getUserName()));
                    do{
                        boundary.displayHomepageForCoordinator(userName);
                        homePageChoice = validation.acceptValidateChoiceInRange(1,3);
                        if(homePageChoice !=3 ){
                            switch (homePageChoice){
                                case 1: //create mission
                                    Mission m = new Mission();
                                    m = createMission();
                                    fileIo.appendFile(m.stringInfo());
                                    break;
                                case 2: //edit mission
                                    int temp;
                                    boolean backHome = false;
                                    do {
                                        temp = chooseTheEditMission(listOfMission);
                                        if (temp != -1) {
                                            Mission mission = missionCoordinator.modifyMission(temp);
                                            if (editMission(mission)) {
                                                missionCoordinator.replaceMission(mission);
                                                fileIo.writeMissions(missionCoordinator.stringInfo());
                                                continue;
                                            }
                                        } else {
                                            backHome = true;
                                        }
                                    }while (!backHome);
                                    break;
                                default:
                                    break;
                            }
                        }else {
                            isLogOut  = true;//logOut
                        }
                    }while (!isLogOut);
                }
                if(isLogOut){
                    continue;
                }
            }else{
                boundary.displayLoginFailed();
                pressAnyToContinue();
                loginChoice = 0;
                continue;
            }
        }
        }while(loginChoice != 2);
        boundary.displayShutDownSystem();
        pressAnyToContinue();
        return;
    }

    /*
    private boolean logIn(){
        Validation validation = new Validation();
        boolean logInSuccessfully = false;
        String userName, password;

        System.out.println("Please enter the Use Name:");
        userName = validation.acceptNoBlankStringInput();
        System.out.println("Please enter the PassWord:");
        password = validation.acceptNoBlankStringInput();

        if(verifyUser(userName, password)){
            System.out.println("User Name or Pass Word is wrong");
        }
        else{
            logInSuccessfully = true;
        }
        return logInSuccessfully;
    }
    */

    public boolean verifyUser(String userName, String passWord){

        boolean isVerified = false;

        Iterator<User> it = listOfUser.iterator();

        while (it.hasNext()){
            User user = new User();

            user = it.next();
            if (user.getUserName().equals(userName) && user.getUserPassword().equals(passWord)) {
                isVerified = true;
                break;
            }
        }
        return isVerified;
    }

    private void pressAnyToContinue() {
        System.out.println();
        System.out.println("Press enter to continue");
        Scanner press = new Scanner(System.in);
        press.nextLine();
        System.out.println('\f');
    }

    public void readListOfUser(){
        ArrayList<String[]> logIn;
        FileIo  fileIo = new FileIo();

        logIn = fileIo.readLogin();

        for (String[] temp: logIn){
            User user = new User();
            user.setUserId(temp[USERID]);
            user.setUserName(temp[USERNAME]);
            user.setUserPassword(temp[PASSWORD]);
            listOfUser.add(user);
        }
    }

    public void readListOfMission(){
        ArrayList<String []> missionS;
        FileIo fileIo = new FileIo();

        missionS = fileIo.readMission();

        for (String[] temp: missionS){
            Mission mission = new Mission();
            mission.setMissionId(Integer.parseInt(temp[0]));
            mission.setMissionName(temp[1]);
            mission.setMissionDescription(temp[2]);
            mission.setCountryOfOrigin(temp[3]);
            mission.setCountriesAllowed(temp[4]);
            mission.setLaunchDate(LocalDate.parse(temp[5], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            mission.setLocationOfDestination(temp[6]);
            mission.setDuration(Integer.parseInt(temp[7]));

            mission.setDetailsAboutCoordinator(temp[8]);
            mission.setStatusOfTheMission(temp[9]);
            // set job
            for (String name : temp[10].split(":") ) {
                Job job = new Job();
                job.setJobName(name);
                mission.getListOfJob().add(job);
            }
            for (String descrp: temp[11].split(":")) {
                Iterator<Job> it = mission.getListOfJob().iterator();
                while(it.hasNext()){
                    it.next().setJobDescription(descrp);
                }
            }
            //set cargo
            for (String required : temp[12].split(":") ) {
                CargoRequirement cargoRequirement = new CargoRequirement();
                cargoRequirement.setCargoRequired(required);
                mission.getListOfCargoRequirement().add(cargoRequirement);
            }
            for (String quantities: temp[13].split(":")) {
                Iterator<CargoRequirement> it = mission.getListOfCargoRequirement().iterator();
                while(it.hasNext()){
                    it.next().setCargoQuantitiesRequired(Integer.parseInt(quantities));
                }
            }
            //set employment
            for (String title : temp[14].split(":") ) {
                EmploymentRequirement employmentRequirement = new EmploymentRequirement();
                employmentRequirement.setTitles(title);
            }
            for (String num: temp[15].split(":")) {
                Iterator<EmploymentRequirement> it = mission.getListOfEmploymentRequirement().iterator();
                while(it.hasNext()){
                    it.next().setNumberOfEmployees(Integer.parseInt(num));
                }
            }
            listOfMission.add(mission);
        }
    }

    public Mission createMission(){
        Validation validation = new Validation();
        Mission mission = new Mission();

        System.out.println("Please enter the Mission name: ");
        mission.setMissionName(validation.acceptRequiredLengthString(10,1000));

        System.out.println("Please enter the mission description");
        mission.setMissionDescription(validation.acceptNoBlankStringInput());

        System.out.println("Please enter the country of origin");
        mission.setCountryOfOrigin(validation.acceptNoBlankStringInput());

        System.out.println("Please enter the country allowed");
        mission.setCountriesAllowed(validation.acceptNoBlankStringInput());

        System.out.println("Please enter the launchDate: ");
        mission.setLaunchDate(LocalDate.parse(validation.acceptNoBlankStringInput(), DateTimeFormatter.ofPattern("yyyy-MM-dd")) );

        System.out.println("Please enter the location of the destination: ");
        mission.setLocationOfDestination(validation.acceptNoBlankStringInput());

        System.out.println("Please enter the duration of the mission:  ");
        mission.setDuration(validation.acceptValidateChoiceInRange(1,100));

        System.out.println("Please enter the details of the mission coordinator: ");
        mission.setDetailsAboutCoordinator(validation.acceptNoBlankStringInput());

        System.out.println("Please enter the status of the Mission: ");
        mission.setStatusOfTheMission(validation.acceptNoBlankStringInput());

        System.out.println("Please enter the ID of the Mission");
        mission.setMissionId(validation.acceptValidateChoiceInRange(0,10000));

        return mission;

    }

    public int chooseTheEditMission(ArrayList<Mission> listOfMission){
        Boundary boundary = new Boundary();
        Validation validation = new Validation();
        boundary.displayTitleOfMissions(listOfMission);
        boolean isId = false;
        int temp = 0;

        System.out.println("Please select the mission that you want to edit: ");
        System.out.println("Enter -1 to back to home page");
        ArrayList<Integer> ids = new ArrayList<>();
        for(Mission mission: listOfMission){
            ids.add(mission.getMissionId());
        }

        do{
            temp = validation.acceptNumericInput();
            for(Integer integer : ids ){
                if(temp == -1){
                    break;
                }
                if(temp == integer && temp != 0 ){
                    isId = true;
                    System.out.println( temp + "is selected ");
                    break;
                }
            }
            if(!isId){
                System.out.println("Please enter the id that list above");
                temp = 0;
            }
        }while(!isId);

        return temp;
    }

    public ArrayList<Mission> readMissionForCoordinator(String userName){
        ArrayList<String []> missionS;
        FileIo fileIo = new FileIo();
        ArrayList<Mission> missionList = new ArrayList<>();

        missionS = fileIo.readMission();

        for (String[] temp: missionS) {
            String[] coordi;
            coordi = temp[8].split(":");
            if (coordi[0].equals(userName)) {
                Mission mission = new Mission();
                mission.setMissionId(Integer.parseInt(temp[0]));
                mission.setMissionName(temp[1]);
                mission.setMissionDescription(temp[2]);
                mission.setCountryOfOrigin(temp[3]);
                mission.setCountriesAllowed(temp[4]);
                mission.setLaunchDate(LocalDate.parse(temp[5], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                mission.setLocationOfDestination(temp[6]);
                mission.setDuration(Integer.parseInt(temp[7]));
                mission.setDetailsAboutCoordinator(temp[8]);
                mission.setStatusOfTheMission(temp[9]);
                // set job
                for (String name : temp[10].split(":")) {
                    Job job = new Job();
                    job.setJobName(name);
                    mission.getListOfJob().add(job);
                }
                for (String descrp : temp[11].split(":")) {
                    Iterator<Job> it = mission.getListOfJob().iterator();
                    while (it.hasNext()) {
                        it.next().setJobDescription(descrp);
                    }
                }
                //set cargo
                for (String required : temp[12].split(":")) {
                    CargoRequirement cargoRequirement = new CargoRequirement();
                    cargoRequirement.setCargoRequired(required);
                    mission.getListOfCargoRequirement().add(cargoRequirement);
                }
                for (String quantities : temp[13].split(":")) {
                    Iterator<CargoRequirement> it = mission.getListOfCargoRequirement().iterator();
                    while (it.hasNext()) {
                        it.next().setCargoQuantitiesRequired(Integer.parseInt(quantities));
                    }
                }
                //set employment
                for (String title : temp[14].split(":")) {
                    EmploymentRequirement employmentRequirement = new EmploymentRequirement();
                    employmentRequirement.setTitles(title);
                }
                for (String num : temp[15].split(":")) {
                    Iterator<EmploymentRequirement> it = mission.getListOfEmploymentRequirement().iterator();
                    while (it.hasNext()) {
                        it.next().setNumberOfEmployees(Integer.parseInt(num));
                    }
                }
                missionList.add(mission);
            }
        }
        return missionList;
    }


    public boolean editMission (Mission mission){
        Boundary boundary = new Boundary();
        Validation validation = new Validation();
        boolean back = false;

        do{
            boundary.displayMissionInfo(mission);
            System.out.println("Please enter the attribute that you want to edit");
            System.out.println("Enter -1 to return to finish editing");
            int choice = validation.acceptNumericInput();
            if(choice != -1){
                switch (choice) {
                    case 1:
                        System.out.println("Please enter the Mission name: ");
                        mission.setMissionName(validation.acceptRequiredLengthString(10, 1000));
                        break;
                    case 2:
                        System.out.println("Please enter the mission description");
                        mission.setMissionDescription(validation.acceptNoBlankStringInput());
                        break;
                    case 3:
                        System.out.println("Please enter the country of origin");
                        mission.setCountryOfOrigin(validation.acceptNoBlankStringInput());
                        break;
                    case 4:
                        System.out.println("Please enter the country allowed");
                        mission.setCountriesAllowed(validation.acceptNoBlankStringInput());
                        break;
                    case 5:
                        System.out.println("Please enter the launchDate: ");
                        mission.setLaunchDate(LocalDate.parse(validation.acceptNoBlankStringInput(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        break;
                    case 6:
                        System.out.println("Please enter the location of the destination: ");
                        mission.setLocationOfDestination(validation.acceptNoBlankStringInput());
                        break;
                    case 7:
                        System.out.println("Please enter the duration of the mission:  ");
                        mission.setDuration(validation.acceptValidateChoiceInRange(1, 100));
                        break;
                    case 8:
                        System.out.println("Please enter the details of the mission coordinator: ");
                        mission.setDetailsAboutCoordinator(validation.acceptNoBlankStringInput());
                        break;
                    case 9:
                        System.out.println("Please enter the status of the Mission: ");
                        mission.setStatusOfTheMission(validation.acceptNoBlankStringInput());
                        break;
                    default:
                        System.out.println("function did not complete");
                        break;
                }
            }else {
                back = true;
            }
        }while(!back);
        return back;
    }

    public void readListOfShuttle(){

        ArrayList<String []> spaceShuttle;
        FileIo fileIo = new FileIo();

        spaceShuttle = fileIo.readShuttleFile();
        //spaceShuttle = readShuttleFile();

        for (String[] temp: spaceShuttle){
            SpaceShuttle shuttle = new SpaceShuttle();
            shuttle.setShuttleName(temp[0]);
            shuttle.setShuttleOrigin(temp[1]);
            shuttle.setManufacturingYear(Integer.parseInt(temp[2]));
            shuttle.setFuelCapacity(Integer.parseInt(temp[3]));
            shuttle.setPassengerCapacity(Integer.parseInt(temp[4]));
            shuttle.setCargoCapacity(Integer.parseInt(temp[5]));
            shuttle.setTravelSpeed(Integer.parseInt(temp[6]));
            shuttle.setShuttleId(Integer.parseInt(temp[7]));

            listOfSpaceShuttle.add(shuttle);
        }


    }

}

