import java.awt.image.CropImageFilter;
import java.awt.image.MemoryImageSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;

/**
 * The class is the Administrator class of the software
 *
 * @author Jiancong Lei
 * @version 05/06/2020
 */
public class Administrator extends User{
    private ArrayList<SpaceShuttle> listOfSpaceShuttle;
    private ArrayList<Criteria> listOfCriteria;
    private ArrayList<Mission> listOfMission;

    public Administrator(String newUserName, String newUserPassword, String newUserId){
        super(newUserName, newUserPassword, newUserId);
        listOfCriteria = new ArrayList<>();
        listOfMission = new ArrayList<>();
        listOfSpaceShuttle = new ArrayList<>();
}

    public ArrayList<Mission> getListOfMission() {
        return listOfMission;
    }

    public ArrayList<SpaceShuttle> getListOfSpaceShuttle() {
        return listOfSpaceShuttle;
    }

    public ArrayList<Criteria> getListOfCriteria() {
        return listOfCriteria;
    }

    public void setListOfSpaceShuttle(ArrayList<SpaceShuttle> listOfSpaceShuttle) {
        this.listOfSpaceShuttle = listOfSpaceShuttle;
    }

    public void setListOfMission(ArrayList<Mission> listOfMission) {
        this.listOfMission = listOfMission;
    }

    public void setListOfCriteria(ArrayList<Criteria> listOfCriteria) {
        this.listOfCriteria = listOfCriteria;
    }
    /*
    this method is to select The mission that is need to be modified
     */
    public Mission modifyMission(int num){
        Iterator it =  listOfMission.iterator();
        Mission moMission = new Mission();

        while (it.hasNext()){
            Mission temp = (Mission) it.next();
            if(temp.getMissionId() == num){
                moMission = temp;
            }
        }
        return moMission;
    }

    public boolean addSpaceShuttle(SpaceShuttle spaceShuttle){
        return listOfSpaceShuttle.add(spaceShuttle);
    }

    public boolean addCriteria(Criteria criteria){
     return listOfCriteria.add(criteria);
    }
    /*
        this method is to select The Criteria that is need to be modified
     */
    public Criteria modifyCriteria(int num){
        Iterator it =  listOfCriteria.iterator();
        Criteria moCriteria = new Criteria();

        while (it.hasNext()){
            Criteria temp = (Criteria) it.next();
            if(temp.getCriteriaID() == num){
                moCriteria = temp;
            }
        }
        return moCriteria;
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
            out.append(mission.stringInfo());
            out.append("\r\n");
        }
        return out;
    }
}
