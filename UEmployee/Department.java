package UEmployee;

public class Department extends UEmployee{
    
    String departmentname;
   
    public Department(String departmentname,String employeename,Double salary){
        super(employeename,salary);
        this.departmentname=departmentname;
    }
    

    public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

    

}
