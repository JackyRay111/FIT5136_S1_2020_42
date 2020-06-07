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
 * @author Jiancong Lei
 * @version 29/05/2020
 */
public class MissionToMarsSystem {
    private ArrayList<User> listOfUser;
    private ArrayList<SpaceShuttle> listOfSpaceShuttle;
    private ArrayList<Criteria> listOfCriteria;
    private ArrayList<Mission> listOfMission;


    static final int USERID = 0;
    static final int USERNAME = 1;
    static final int PASSWORD = 2;

    public MissionToMarsSystem (){
        listOfCriteria = new ArrayList<>();
        listOfMission = new ArrayList<>();
        listOfSpaceShuttle = new ArrayList<>();
        listOfUser = new ArrayList<>();
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
                                                replaceMission(mission);
                                                fileIo.writeMissions(stringInfo());
                                                continue;
                                            }
                                        } else {
                                            backHome = true;
                                        }
                                    }while (!backHome);

                                    break;
                                case 2: // select shuttle space
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
                                    if(m != null) {
                                        fileIo.appendFile(m.stringInfo());
                                    }
                                    break;
                                case 2: //edit mission
                                    int temp;
                                    boolean backHome = false;
                                    do{
                                        temp = chooseTheEditMission(listOfMission);
                                        if (temp != -1) {
                                            Mission mission = missionCoordinator.modifyMission(temp);
                                            if (editMission(mission)) {
                                                replaceMission(mission);
                                                fileIo.writeMissions(stringInfo());
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
            ArrayList<Job> jobList = new ArrayList<>();
            ArrayList<CargoRequirement> cargoList = new ArrayList<>();
            ArrayList<EmploymentRequirement> employList = new ArrayList<>();


            for (String name : temp[10].split(":") ) {
                Job job = new Job();
                job.setJobName(name);
                jobList.add(job);
            }
            int i=0;
            for (String descrp: temp[11].split(":")) {
                jobList.get(i).setJobDescription(descrp);
                i++;

            }
            //set cargo
            for (String required : temp[12].split(":") ) {
                CargoRequirement cargoRequirement = new CargoRequirement();
                cargoRequirement.setCargoRequired(required);
                cargoList.add(cargoRequirement);
            }
            int j = 0;
            for (String quantities: temp[13].split(":")) {
                cargoList.get(j).setCargoQuantitiesRequired(Integer.parseInt(quantities));
                j++;
            }
            //set employment
            for (String title : temp[14].split(":") ) {
                EmploymentRequirement employmentRequirement = new EmploymentRequirement();
                employmentRequirement.setTitles(title);
                employList.add(employmentRequirement);
            }
            int k = 0;
            for (String num: temp[15].split(":")) {

                employList.get(k).setNumberOfEmployees(Integer.parseInt(num));
                k++;
            }
            mission.setListOfJob(jobList);
            mission.setListOfCargoRequirement(cargoList);
            mission.setListOfEmploymentRequirement(employList);
            listOfMission.add(mission);
        }
    }

    public Mission createMission(){
        Validation validation = new Validation();
        Mission mission = new Mission();
        Boundary boundary = new Boundary();
        boolean finish = false;
        do {
            int selection;
            boundary.displayMissionInfo(mission);
            System.out.println("13.Mission ID:");
            System.out.println("Please enter the choice to create or edit: ");
            System.out.println("Enter -1 to back to the previous page without save");
            System.out.println("Enter -2 to finish the creation and save");
            selection = validation.acceptNumericInput();
            if(selection!= -1 && selection != -2) {
                switch (selection) {
                    case 1:
                        System.out.println("Please enter the Mission name: ");
                        mission.setMissionName(validation.acceptNoBlankStringInput());
                    break;
                    case 2:
                        System.out.println("Please enter the mission description(more that 10 words)");
                        mission.setMissionDescription(validation.acceptRequiredLengthString(10, 1000));
                    break;
                    case 3:
                        System.out.println("Please enter the country of origin");
                        mission.setCountryOfOrigin(validation.acceptNoBlankStringInput());
                    case 4:
                        System.out.println("Please enter the country allowed");
                        mission.setCountriesAllowed(validation.acceptNoBlankStringInput());
                    break;
                    case 5:
                        System.out.println("Please enter the launchDate (in yyyy-MM-dd format): ");
                        mission.setLaunchDate(LocalDate.parse(validation.acceptValidateLocalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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
                    System.out.println("Please enter the details of the mission coordinator(name:email): ");
                    mission.setDetailsAboutCoordinator(validation.acceptNoBlankStringInput());
                    break;
                    case 9:
                    System.out.println("Please enter the status of the Mission: ");
                    mission.setStatusOfTheMission(validation.acceptNoBlankStringInput());
                    break;
                    case 10:
                    boolean enterAgain = true;
                    String name, description;
                    do {

                        boundary.displayJobList(mission.getListOfJob());

                        System.out.println("Please enter the job name: ");
                        name = validation.acceptNoBlankStringInput();
                        System.out.println("Please enter the job description:");
                        description = validation.acceptNoBlankStringInput();

                        Job job = new Job(name,description);
                        mission.getListOfJob().add(job);

                        System.out.println("1. add one more");
                        System.out.println("2. go back to previous page");
                        int jobCreate = validation.acceptValidateChoiceInRange(1,2);
                        if(jobCreate == 1){
                            continue;
                        }else if (jobCreate == 2){
                            enterAgain = false;
                        }

                    } while (enterAgain);
                    break;
                    case 11:
                        boolean enterAgainCargo = true;
                        String carR;
                        int carQu;
                        do {

                            boundary.displayCargoList(mission.getListOfCargoRequirement());
                            System.out.println("Please enter the cargo required: ");
                            carR = validation.acceptNoBlankStringInput();
                            System.out.println("Please enter the cargo quantities:");
                            carQu = validation.acceptPositiveInt();

                            CargoRequirement cargoRequirement = new CargoRequirement(carR,carQu);
                            mission.getListOfCargoRequirement().add(cargoRequirement);

                            System.out.println("1. add one more");
                            System.out.println("2. go back to previous page");
                            int carCreate = validation.acceptValidateChoiceInRange(1,2);
                            if(carCreate == 1){
                                continue;
                            }else if (carCreate == 2){
                                enterAgain = false;
                            }

                        } while (enterAgainCargo);
                        break;

                    case 12:
                        boolean enterAgainEmploy = true;
                        String employT;
                        int employN;
                        do {

                            boundary.displayEmployList(mission.getListOfEmploymentRequirement());
                            System.out.println("Please enter the Employ title: ");
                            employT = validation.acceptNoBlankStringInput();
                            System.out.println("Please enter the emoloy number:");
                            employN = validation.acceptPositiveInt();

                            EmploymentRequirement employmentRequirement = new EmploymentRequirement(employT,employN);
                            mission.getListOfEmploymentRequirement().add(employmentRequirement);

                            System.out.println("1. add one more");
                            System.out.println("2. go back to previous page");
                            int carCreate = validation.acceptValidateChoiceInRange(1,2);
                            if(carCreate == 1){
                                continue;
                            }else if (carCreate == 2){
                                enterAgain = false;
                            }

                        } while (enterAgainEmploy);
                        break;


                    case 13:
                        System.out.println("Please enter the ID of the Mission");
                        mission.setMissionId(validation.acceptValidateChoiceInRange(0, 1000000));
                        break;
                }
            }
            if (selection == -1){
                return null;
            }
            if(selection == -2){
                if(mission.getMissionId() == 0 || mission.getMissionName().equals("") || mission.getDetailsAboutCoordinator().equals("") || mission.getStatusOfTheMissionst().equals("") || mission.getLocationOfDestination().equals("") || mission.getCountryOfOrigin().equals("") || mission.getCountriesAllowed().equals("")){
                    System.out.println("you should enter everything, otherwise u can't save the mission");
                    pressAnyToContinue();
                }else{
                finish = true;
                }
            }
        }while (!finish);
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
            if(temp == -1){
                break;
            }else{
            for(Integer integer : ids ){
                if(temp == integer && temp != 0 ){
                    isId = true;
                    System.out.println( temp + "is selected ");
                    pressAnyToContinue();
                    break;
                }
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
            System.out.println("Enter -1 finish ");
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
                        mission.setLaunchDate(LocalDate.parse(validation.acceptValidateLocalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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
                    case 10:
                        boolean finishJob = false;
                        int size,selection;
                        String name,description;
                        do {
                            size = boundary.displayJobList(mission.getListOfJob());
                            System.out.println("Please enter your selection");
                            System.out.println("-1. finish edit");

                            selection = validation.acceptValidateChoiceInRange(-1, size);
                            if (selection > 0) {
                                System.out.println("Please enter the job name: ");
                                name = validation.acceptNoBlankStringInput();
                                System.out.println("Please enter the job description:");
                                description = validation.acceptNoBlankStringInput();
                                Job job = new Job();
                                mission.getListOfJob().set(selection-1,job);
                            }else if(selection == 0){
                                System.out.println("Please enter the right selection");
                                pressAnyToContinue();
                            }else if (selection == -1){
                                finishJob = true;
                            }
                        }while(!finishJob);
                        break;
                    case 11:
                        boolean finishCargo = false;
                        int sizeCar,selectionCar, quantityCar;
                        String nameCar;
                        do {
                            sizeCar = boundary.displayCargoList(mission.getListOfCargoRequirement());
                            System.out.println("Please enter your selection");
                            System.out.println("-1. finish edit");

                            selectionCar = validation.acceptValidateChoiceInRange(-1, sizeCar);
                            if (selectionCar > 0) {
                                System.out.println("Please enter the job name: ");
                                nameCar = validation.acceptNoBlankStringInput();
                                System.out.println("Please enter the job description:");
                                quantityCar = validation.acceptPositiveInt();
                                CargoRequirement cargoRequirement = new CargoRequirement(nameCar, quantityCar);
                                mission.getListOfCargoRequirement().set(selectionCar-1, cargoRequirement);
                            }else if(selectionCar == 0){
                                System.out.println("Please enter the right selection");
                                pressAnyToContinue();
                            }else if (selectionCar == -1){
                                finishCargo = true;
                            }
                        }while(!finishCargo);
                        break;
                    case 12:
                        boolean finishEmploy = false;
                        int sizeEmploy,selectionEmploy, quantityEmploy;
                        String nameEmploy;
                        do {
                            sizeEmploy = boundary.displayEmployList(mission.getListOfEmploymentRequirement());
                            System.out.println("Please enter your selection");
                            System.out.println("-1. finish edit");

                            selectionEmploy = validation.acceptValidateChoiceInRange(-1, sizeEmploy);
                            if (selectionEmploy > 0) {
                                System.out.println("Please enter the job name: ");
                                nameEmploy = validation.acceptNoBlankStringInput();
                                System.out.println("Please enter the job description:");
                                quantityEmploy = validation.acceptPositiveInt();
                                EmploymentRequirement employmentRequirement = new EmploymentRequirement(nameEmploy, quantityEmploy);
                                mission.getListOfEmploymentRequirement().set(selectionEmploy-1, employmentRequirement);
                            }else if(selectionEmploy == 0){
                                System.out.println("Please enter the right selection");
                                pressAnyToContinue();
                            }else if (selectionEmploy == -1){
                                finishEmploy = true;
                            }
                        }while(!finishEmploy);
                        break;
                    default:
                        break;
                }
            }else {
                back = true;
            }
        }while(!back);
        return back;
    }

    public void replaceMission(Mission mission){
        Iterator<Mission> it = listOfMission.iterator();

        while(it.hasNext()){
            Mission m = it.next();
            if(m.getMissionId() == mission.getMissionId()){
                it.remove();
                listOfMission.add(mission);
                break;
            }
        }
    }

    public StringBuffer stringInfo(){
        StringBuffer out = new StringBuffer();

        for(Mission mission: listOfMission){
            out.append( mission.stringInfo());
            out.append("\r\n");
        }
        return out;
    }
}

