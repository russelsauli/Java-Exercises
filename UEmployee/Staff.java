package UEmployee;

public class Staff extends UEmployee{

    String jobtitle;
   
    public Staff(String jobtitle,String employeename,Double salary){
        super(employeename,salary);
        this.jobtitle=jobtitle;
    }
    

    public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

}
