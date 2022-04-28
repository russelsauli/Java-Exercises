package UEmployee;

public class Faculty extends UEmployee{
    
    String departmentname;

    public Faculty(String departmentname,String employeename,Double salary){
        super(employeename,salary);
        this.departmentname=departmentname;
    }

    public String getDepartment() {
		return departmentname;
	}

	public void setDepartment(String departmentname) {
		this.departmentname = departmentname;
	}

}
