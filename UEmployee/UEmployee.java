package UEmployee;

public class UEmployee {
    
    String employeename;
    Double salary;

    public UEmployee(String employeename,Double salary){

        this.employeename=employeename;
        this.salary=salary;
    }

	public String getName() {
		return employeename;
	}
	public void setName(String employeename) {
		this.employeename = employeename;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
