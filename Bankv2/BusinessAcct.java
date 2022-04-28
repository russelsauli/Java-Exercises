package Bankv2;

public class BusinessAcct extends Account{

    private double businessBalance;

   

    public BusinessAcct(Double businessBalance,Double balance,String fName,String lName,String str, String city, String st,String zip){
        super(balance,fName,lName, str, city, st,zip);
        this.businessBalance=businessBalance;
    } 


    public Double getBusinessBalance() {
		return businessBalance;
	}
	public void setBusinessBalance(Double businessBalance) {
		this.businessBalance = businessBalance;
	}
}
