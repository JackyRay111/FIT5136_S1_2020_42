/**
 *  The class is to store the information of the Job requirement
 *
 *  @author JiancongLei(Jacky) Lei
 *  @Version 25/05/2020
 */
public class Job {
    private String jobName;
    private String jobDescription;

    /**
     * The constructor for objects of the class Job
     */
    public Job(){
        jobDescription = "";
        jobName = "";
    }

    public Job(String jobName, String jobDescription){
        this.jobDescription = jobDescription;
        this.jobName = jobName;
    }

    /**
     * The Accessor method to get the name of the job
     *
     * @return A String that contain the name of the job
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * The Accessor method to get the description of the Job
     *
     * @return A String that contain the description of the Job
     */
    public String getJobDescription(){
        return jobDescription;
    }

    /**
     * The Mutator method to set the name of the job
     *
     * @param jobName A String that contain the name of the job
     */
    public void setJobName(String jobName){
        this.jobName = jobName;
    }

    /**
     * The Mutator method to set the description of the job
     *
     * @param jobDescription A String that contain the description of the job
     */
    public void setJobDescription(String jobDescription){
        this.jobDescription = jobDescription;
    }


}
