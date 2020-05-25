package FIT5136_Implementation;

public class EmploymentRequirement {
    private String titles;
    private int numberOfEmployees;

    public EmploymentRequirement(){
        titles = "";
        numberOfEmployees = 0;
    }

    public String getTitles(){
        return titles;
    }

    public int getNumberOfEmployees(){
        return numberOfEmployees;
    }

    public void setTitles(String titles){
        this.titles = titles;
    }

    public void setNumberOfEmployees(int numberOfEmployees){
        this.numberOfEmployees = numberOfEmployees;
    }
}
