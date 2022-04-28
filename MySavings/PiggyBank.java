package MySavings;

public class PiggyBank {
    private String cointype;
	private int quantity;
	private double coinvalue;
	private double totalcoinvalue;
	
	public PiggyBank(String cointype,int quantity,double coinvalue,double totalcoinvalue){

		this.cointype=cointype;
		this.quantity=quantity;
		this.coinvalue=coinvalue;
		this.totalcoinvalue=totalcoinvalue;
	}
	
	public String getCointype() {
		return cointype;
	}
	
	public void setCointype(String cointype) {
		this.cointype = cointype;
	}
	
	public double getCoinvalue() {
		return coinvalue;
	}
	
	public void setCoinvalue(double coinvalue) {
		this.coinvalue = coinvalue;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalcoinvalue() {
		return totalcoinvalue;
	}

	public void setTotalcoinvalue(double totalcoinvalue) {
		this.totalcoinvalue = totalcoinvalue;
	}
}
