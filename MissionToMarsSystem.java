import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.lang.System;
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
        Validation validation = new Validation();
        int loginChoice = 0, homePageChoice = 0;
        boolean logInSuccessfully = false;
        String userName, password, userId = "";

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
                ArrayList<String[]> temp;
                temp = fileIo.readLogin();
                for(String[] userList : temp){
                    if(userList[USERNAME].equals(userName)){
                        userId = userList[USERID];
                        break;
                    }
                }
                if(userId.substring(0,1).equals("M")){
                    boundary.displayHomePageForAdmin(userName);
                    homePageChoice = validation.acceptValidateChoiceInRange(1,4);
                    if(homePageChoice != 4){
                        switch (homePageChoice){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            default:
                                break;
                        }
                    }else {
                        continue;
                    }
                }else{
                    boundary.displayHomepageForCoordinator(userName);
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
        FileIo file = new FileIo();
        ArrayList<String[]> user ;
        boolean isVerified = false;

        user = file.readLogin();

        for (String[] temp : user) {
            if (temp[USERNAME].equals(userName) && temp[PASSWORD].equals(passWord)) {
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
    
    
    
    
    
    public void Criteria()
    {
        readCriteria();
        editCriteria();
    }
    
    public void readCriteria()
    {
        ArrayList<String> option = new ArrayList<String>();
        option = readFile();
        System.out.println("1 : " + option.get(0));
        System.out.println("2 : " + option.get(1));
        System.out.println("3 : " + option.get(2));
        System.out.println("4 : " + option.get(3));
    }
    
    public void editCriteria()
    {
        System.out.println("Please edit your criteria for mission");
        Scanner sc = new Scanner(System.in);
        
    }
    
    /**
     * Method to read file
     *
     * @return return the file's contents stored in the ArrayList<String> option
     */
    private ArrayList<String> readFile()
    {
        ArrayList<String> option = new ArrayList<String>();
        try
        {
            FileIO readFile = new FileIO("criteria.txt");
            option = readFile.readFile();
        }
        catch (Exception e) 
        {
            System.out.println("It can not find the criteria.txt");
            System.exit(0);
        }
        return option;
    }
}
