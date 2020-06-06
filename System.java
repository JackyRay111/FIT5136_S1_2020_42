import java.util.ArrayList;

/**
 * The class is the control class of the softwar
 *
 * @author Jiancong Lei
 * @version 29/05/2020
 */
public class System {
    private ArrayList<User> listOfUser;
    private ArrayList<SpaceShuttle> listOfSpaceShuttle;
    private ArrayList<Criteria> listOfCriteria;
    private ArrayList<Mission> listOfMission;

    public System (){
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
}
