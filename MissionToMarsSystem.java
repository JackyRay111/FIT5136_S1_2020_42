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
        int choice = 0;

        //start

    }

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

    public boolean verifyUser(String userName, String passWord){
        final int USERNAME = 1;
        final int PASSWORD = 2;
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
}
