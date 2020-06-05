/**
 * The class is the user class of the software
 *
 * @author Jiancong Lei
 * @version 05/06/2020
 */
public class user {
    private String userName;
    private String unserPassword;
    private String unserId;

    public user(){
        unserId = "";
        userName = "";
        unserId = "" ;
    }

    public String getUnserId() {
        return unserId;
    }

    public String getUnserPassword() {
        return unserPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUnserId(String unserId) {
        this.unserId = unserId;
    }

    public void setUnserPassword(String unserPassword) {
        this.unserPassword = unserPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
