import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class is the MissionCoordinator class of the software
 *
 * @author Jiancong Lei
 * @version 05/06/2020
 */
public class MissionCoordinator extends User{
    private ArrayList<Mission> listOfMission;

    public MissionCoordinator(String newUserName, String newUserPassword, String newUserId){
        super(newUserName, newUserPassword, newUserId);
        listOfMission = new ArrayList<>();
    }

    public ArrayList<Mission> getListOfMission() {
        return listOfMission;
    }

    public void setListOfMission(ArrayList<Mission> listOfMission) {
        this.listOfMission = listOfMission;
    }
    /*
        this method is to select The mission that is need to be modified
     */
    public Mission modifyMission(int num){
        Iterator<Mission> it =  listOfMission.iterator();
        Mission moMission = new Mission();

        while (it.hasNext()){
        Mission temp = it.next();
        if(temp.getMissionId() == num){
            moMission = temp;
        }
        }
        return moMission;
    }

    public StringBuffer stringInfo(){
        StringBuffer out = new StringBuffer();

        for(Mission mission: listOfMission){
            out.append(mission.stringInfo());
            out.append("\r\n");
        }
        return out;
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
}
