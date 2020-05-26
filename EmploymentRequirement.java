package FIT5136_Implementation;

/**
 *  The class is to store the information of the employment requirement
 *
 *  @author JiancongLei(Jacky) Lei
 *  @Version 25/05/2020
 */
public class EmploymentRequirement {
    private String titles;
    private int numberOfEmployees;

    /**
     * The constructor for objects of the EmploymentRequirement Class
     */
    public EmploymentRequirement(){
        titles = "";
        numberOfEmployees = 0;
    }

    /**
     * The Accessor method to get the titles of the Employment
     *
     * @return A String that contain the titles of the Employment
     */
    public String getTitles(){
        return titles;
    }

    /**
     * The Accessor method to get the number of the employees for this Employment
     *
     * @return A integer that contain the number of the employees
     */
    public int getNumberOfEmployees(){
        return numberOfEmployees;
    }

    /**
     * The Mutator method to set the titles of the employees for this employment
     *
     * @param titles String that contain the title of employment
     */
    public void setTitles(String titles){
        this.titles = titles;
    }

    /**
     * The Mutator method to set the number of the employees for this employment
     *
     * @param numberOfEmployees String taht contain the number of the employees
     */
    public void setNumberOfEmployees(int numberOfEmployees){
        this.numberOfEmployees = numberOfEmployees;
    }
}
