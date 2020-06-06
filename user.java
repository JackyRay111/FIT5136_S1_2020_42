/**
 * The class is the user class of the software
 *
 * @author Jiancong Lei and Daniel
 * @version 05/06/2020
 */
public class User {
    private String userName;
    private String userPassword;
    private String userId;

    /**
     * Constructor for objects of class User
     */
    public User(){
        userId = "";
        userName = "";
        userId = "" ;
    }

    /**
     * Constructor for objects of class User
     */
    public User(String newUserName, String newUserPassword, String newUserId)
    {
        // initialise attributes
        userName = newUserName;
        userPassword = newUserPassword;
        userId = newUserId;
    }

    /**
     * Accessor Method to get the user Id
     *
     * @return a String which contains the user Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Accessor Method to get the user password
     *
     * @return a String which contains the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Accessor Method to get the name of the user
     *
     * @return a String which contains the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Mutator Method to set the user Id
     *
     * @param userId String to define the
     *         user Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Mutator Method to set the user password
     *
     * @param userPassword String to set the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Mutator Method to set the username
     *
     * @param userName String to define the new
     *          username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
