package MySavings;

import java.text.NumberFormat;

import java.util.Locale;
import java.util.Scanner;

public class MysavingMethods {

	Scanner input = new Scanner(System.in);
	
	// create object for each type of coin and value quantity and total value
	PiggyBank penny = new PiggyBank("Penny",0,0.01,0.00);
	PiggyBank nickel = new PiggyBank("Nickel",0,0.05,0.00);
	PiggyBank dime = new PiggyBank("Dime",0,0.10,0.00);
	PiggyBank quarter = new PiggyBank("Quarter",0,0.25,0.00);

	// this is used to set local language and country 
	Locale uslocale = new Locale("en", "US");  

	// set the format of string to currency with us currency base on set local
	NumberFormat currency = NumberFormat.getCurrencyInstance(uslocale); // currency value
	
	int takepenny=0, takenickel=0,takedime=0,takequarter=0,selectedtransaction;

	double totalcoins;

	String selectedcoin=null;

	// Display choices or available process
	public void Choices() {
		// Loop choices selection if input is incorrect else method Addcoins will be called
		do {
			System.out.print("\nSelect Transaction \n");
			System.out.print("1. Show total in bank \n");
			System.out.print("2. Add a penny \n");
			System.out.print("3. Add a nickel \n");
			System.out.print("4. Add a dime \n");
			System.out.print("5. Add a quarter \n");
			System.out.print("6. Take money out of bank \n");
			System.out.print("Enter 0 to quit \n");

			// catch if the input is incorrect
			try {
				System.out.print("Enter your choice: ");
				selectedtransaction=input.nextInt();
			}
			catch(Exception e ){
				System.out.print("\nIncorrect  input");
				input.next();
				selectedtransaction=8;
			}

			System.out.println("");

		}while(selectedtransaction<0 || selectedtransaction>7);
		
		// call execute the selected process
		switch(selectedtransaction) {

			case 0:
				System.out.println("Program end");
				break;
			
			case 1:
				ShowTotalInBank();
				break;
				
			case 6:
				Takemoneyout(); 
				break;
			
			default:
				AddCoin();
		}
			
	}
	// a Method will determine what kind of coin type and value of coin  will be add base on selected
	public String Selectedcoin(Integer selectcoin) {

		String cointype=null;
		
		if (selectedtransaction==2) {
			cointype="Penny";
		}
		
		else if (selectedtransaction==3) {
			cointype="Nickel";
		}
		
		else if (selectedtransaction==4) {
			cointype="Dime";
		}
		
		else if (selectedtransaction==5) {
			cointype="Quarter";
		}
		return(cointype);
	}
	// catch process if error occur to ask if user want to continue or not the process
	public void Continuetransaction(int selectedtransaction) {
		String continuprocess=null;
		
		if(selectedtransaction!=6) {
			System.out.print("\nContinue adding "+selectedcoin+" Y/N ? :");
		}

		else {
			System.out.print("\nContinue to take money Y/N ? :");
		}

		continuprocess=input.next();
		
		if(continuprocess.equalsIgnoreCase("Y")) {
			
			switch(selectedtransaction) {
				case 0:
					System.out.println("End");
					break;
		
				case 1:
					ShowTotalInBank();
					break;
					
				case 6:
					Takemoneyout();
					break;
		
				default:
					AddCoin();
			}
		}
		
		else if(continuprocess.equalsIgnoreCase("N")) {
			Choices();
		}
			
		else {
			System.out.println("Incorrect input");
			Continuetransaction(selectedtransaction);
		}
		
	}
	// Disply list of coins and value
	public void ShowTotalInBank() {
		
		String format="%-10s %7s\t  %7s\t  %-10s\n";
		
		double totalearning=penny.getTotalcoinvalue()+nickel.getTotalcoinvalue()+dime.getTotalcoinvalue()+quarter.getTotalcoinvalue();
		
		System.out.print("\n======================Total In Bank======================");
		System.out.format(format,"\nCoin Type","Quantity","Value value","Subtotal Amount");

		System.out.format(format,penny.getCointype(),penny.getQuantity(),currency.format(penny.getCoinvalue()),currency.format(penny.getTotalcoinvalue()));
       
		System.out.format(format,nickel.getCointype(),nickel.getQuantity(),currency.format(nickel.getCoinvalue()),currency.format(nickel.getTotalcoinvalue()));
       
		System.out.format(format,dime.getCointype(),dime.getQuantity(),currency.format(dime.getCoinvalue()),currency.format(dime.getTotalcoinvalue()));
       
		System.out.format(format,quarter.getCointype(),quarter.getQuantity(),currency.format(quarter.getCoinvalue()),currency.format(quarter.getTotalcoinvalue()));
       
		System.out.print("\n=========================================================");
		System.out.print("\nTotal: 			                  "+currency.format(totalearning));
		System.out.print("\n=========================================================\n");
		
		Choices();
	}
	// add coin based on selected coin in choices
	public void AddCoin() {

		int quantity=0;
		selectedcoin=Selectedcoin(selectedtransaction);

		try {
			System.out.print("\nAdd "+selectedcoin);
			System.out.print("\nHow many "+selectedcoin+" you will add? : ");
			
			quantity=input.nextInt();
			
			if(quantity>0) {

				if(selectedcoin=="Penny"){
					penny.setQuantity(penny.getQuantity()+quantity);
					penny.setTotalcoinvalue(penny.getQuantity()*penny.getCoinvalue());
				}

				else if(selectedcoin=="Nickel"){
					nickel.setQuantity(nickel.getQuantity()+quantity);
					nickel.setTotalcoinvalue(nickel.getQuantity()*nickel.getCoinvalue());
				}

				else if(selectedcoin=="Dime"){
					dime.setQuantity(dime.getQuantity()+quantity);
					dime.setTotalcoinvalue(dime.getQuantity()*dime.getCoinvalue());
				}

				else{
					quarter.setQuantity(quarter.getQuantity()+quantity);
					quarter.setTotalcoinvalue(quarter.getQuantity()*quarter.getCoinvalue());
				}

				ShowTotalInBank();
			}
			else {
				System.out.println("\nSystem dont accept negative or 0 value");
				Continuetransaction(selectedtransaction);
			}
			
		}
		
		catch(Exception e){
			System.out.print("\nIncorrect Input");
			input.next();
			Continuetransaction(selectedtransaction);
		}
	}
	// set the created object to 0 quantity and totalvalue 
	public void Takeallmoneyout() {

		penny = new PiggyBank("Penny",0,0.01,0.00);
		nickel = new PiggyBank("Nickel",0,0.05,0.00);
		dime = new PiggyBank("Dime",0,0.10,0.00);
		quarter = new PiggyBank("Quarter",0,0.25,0.00);

		ShowTotalInBank();
	}
	public void Takemoneyout() {
		
		double takeamount=0,availableamount=0;

		availableamount=penny.getTotalcoinvalue()+nickel.getTotalcoinvalue()+dime.getTotalcoinvalue()+quarter.getTotalcoinvalue();
		
		try {
			System.out.print("\nTake money out of bank ");
			System.out.print("\nHow much you will take? ");
			takeamount=input.nextDouble();
			
			takeamount=Math.round(takeamount * 100.0) / 100.0;

			if(takeamount>=0) {
				
				if(takeamount<=availableamount) {
					
					while(takeamount>0) {
						
						if(quarter.getCoinvalue()<=takeamount && quarter.getQuantity()>0) {
							takequarter++;
							quarter.setQuantity(quarter.getQuantity()-1);
							quarter.setTotalcoinvalue(quarter.getCoinvalue()*quarter.getQuantity());
							takeamount=takeamount-quarter.getCoinvalue();
							takeamount=Double.parseDouble(String.format("%.3f", takeamount));
						}
						
						else if(dime.getCoinvalue()<=takeamount && dime.getQuantity()>0) {
							takequarter++;
							dime.setQuantity(dime.getQuantity()-1);
							dime.setTotalcoinvalue(dime.getCoinvalue()*dime.getQuantity());
							takeamount=takeamount-dime.getCoinvalue();
							takeamount=Double.parseDouble(String.format("%.3f", takeamount));
						}
						
						else if(nickel.getCoinvalue()<=takeamount && nickel.getQuantity()>0) {
							takequarter++;
							nickel.setQuantity(nickel.getQuantity()-1);
							nickel.setTotalcoinvalue(nickel.getCoinvalue()*nickel.getQuantity());
							takeamount=takeamount-nickel.getCoinvalue();
							takeamount=Double.parseDouble(String.format("%.3f", takeamount));
						}
						
						else if(penny.getCoinvalue()<=takeamount && penny.getQuantity()>0) {
							takequarter++;
							penny.setQuantity(penny.getQuantity()-1);
							penny.setTotalcoinvalue(penny.getCoinvalue()*penny.getQuantity());
							takeamount=takeamount-penny.getCoinvalue();
							takeamount=Double.parseDouble(String.format("%.3f", takeamount));
						}
					}
				}
				
				else {

					System.out.print("\nInsufficient balance");
					System.out.print("\nAvailable balance "+availableamount);
					Continuetransaction(selectedtransaction);
				}
			}
			else {

				System.out.print("\nSystem don't accept negative or 0 value");
				Continuetransaction(selectedtransaction);
			}	
		}

		catch(Exception e) {

			System.out.print("\nIncorrect Input");
			input.next();
			Continuetransaction(selectedtransaction);
		}

		ShowTotalInBank();
	}
}








