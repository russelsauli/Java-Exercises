package Bankv2;

public class PersonalAcct extends Account{
    
    private double personalBalance;


    public PersonalAcct(Double personalBalance,Double bal,String fName,String lName,String str, String city, String st,String zip){
    super(bal,fName,lName, str, city,st, zip);
    this.personalBalance=personalBalance;

    } 

    public Double getPersonalBalance() {
		return personalBalance;
	}

	public void setPersonalBalance(Double personalBalance) {
		this.personalBalance = personalBalance;
	}

  


  
}
