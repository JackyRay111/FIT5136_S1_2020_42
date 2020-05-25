package FIT5136_Implementation;

public class Job {
    private String jobName;
    private String jobDescrition;

    public Job(){
        jobDescrition = "";
        jobName = "";
    }

    public String getJobName(){
        return jobName;
    }

    public String getJobDescrition(){
        return jobDescrition;
    }

    public void setJobName(String jobName){
        this.jobName = jobName;
    }

    public void setJobDescrition(String jobDescrition){
        this.jobDescrition = jobDescrition;
    }
}
