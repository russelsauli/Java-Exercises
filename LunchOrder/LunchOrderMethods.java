package LunchOrder;

import java.text.NumberFormat;

import java.util.Locale;
import java.util.Scanner;

public class LunchOrderMethods {

	Scanner input = new Scanner(System.in);

	// set what kind of local will be use
	Locale uslocale = new Locale("en", "US");   
	
	// format the text to currency with local base on set local value    
	NumberFormat currency = NumberFormat.getCurrencyInstance(uslocale); // currency value

	//create object for each food with data
	Food humberger = new Food("Humberger", 1.85, 9.0, 33.0, 1.0);
	Food salad = new Food("Salad", 2.00, 1.0, 11.0, 5.0);
	Food frenchfries = new Food("French fries", 1.30, 11.0, 36.0, 4.0);
	Food soda = new Food("Soda", 0.95, 0.0, 38.0, 0.0);
	int quantity,foodindex=1;
	double totalorder;

	// start the program 
	public void Startprog() {
		
		String food="";
		try{
			// loop each to get the food order
			while(foodindex<=4) {
			food=Seelectedfood(foodindex); // get food name
			System.out.print("\nEnter number of "+food+": "); 
				quantity=input.nextInt();	// enter quantity
				System.out.print(FoodDetails(food)+"\n"); //get food detail
				totalorder=Foodorder(food ,totalorder,quantity);// compute order
				foodindex++;
			}

			System.out.print("\nYour order comes to: "+currency.format(totalorder)+"\n\n"); // show total order
			foodindex=1;
			totalorder=0;
			Continueprocess(); // ask if you will continue the get another order
		}

		catch(Exception e ){
			System.out.print("Incorrect input\n");
			input.next();
			Continueprocess();
		}
	}

	// method to ask if the user what to continue or create new order
	public void Continueprocess(){
		
		String continueprocess=null;
		boolean isContinue=false;
		isContinue=false;

		do{
			System.out.print("Continue Y/N ? :");
			continueprocess=input.next();
			
			if(continueprocess.equalsIgnoreCase("Y")){

				isContinue=true;
				Startprog();
			}
			else if(continueprocess.equalsIgnoreCase("N")){

				isContinue=true;
				System.out.print("\nEnd of program");
			}
			else{

				System.out.print("\nIncorrect input");
				isContinue=false;
			}

		}while(isContinue==false);

	}
	
	// get the food base on intiger get from the loop in the Start prog
	public String Seelectedfood(Integer food) {
		
		String selectedfood="";
		
		switch(food) {
		
		case 1:
			selectedfood="Humberger";
			break;
			
		case 2:
			selectedfood="Salad";
			break;
			
		case 3:
			selectedfood="French fries";
			break;
			
		case 4:
			selectedfood="Soda";
			break;
		}
		
		return(selectedfood);
	}
	
	// get food detail
	public String FoodDetails(String food) {
		String fooddetails=null;
		
		switch(food) {

			case "Humberger":
			fooddetails="Each "+humberger.getFoodname()+" has "+ humberger.getFat()+"g of fat, "+humberger.getCarbohydrate()+"g of carbs, and"+humberger.getFiber()+"g of fiber";
			break;
			
			case "Salad":
			fooddetails="Each "+salad.getFoodname()+" has "+ salad.getFat()+"g of fat, "+salad.getCarbohydrate()+"g of carbs, and"+salad.getFiber()+"g of fiber";
			break;
			
			case "French fries":
			fooddetails="Each "+frenchfries.getFoodname()+" has "+ frenchfries.getFat()+"g of fat, "+frenchfries.getCarbohydrate()+"g of carbs, and"+frenchfries.getFiber()+"g of fiber";
			break;
			
			case "Soda":
			fooddetails="Each "+soda.getFoodname()+" has "+ soda.getFat()+"g of fat, "+soda.getCarbohydrate()+"g of carbs, and"+soda.getFiber()+"g of fiber";
			break;
		}
		
		return(fooddetails);
	}
	
	// compute order
	public Double Foodorder(String food ,double total,int quantity) {
		
		double subtotal=total;

		switch(food) {
			
			case "Humberger":
			subtotal=subtotal+(humberger.getPrice()*quantity);
			break;
			
			case "Salad":
			subtotal=subtotal+(salad.getPrice()*quantity);
			break;
			
			case "French fries":
			subtotal=subtotal+(frenchfries.getPrice()*quantity);
			break;
			
			case "Soda":
			subtotal=subtotal+(soda.getPrice()*quantity);
			break;
		}
		
		return(subtotal);	
	}
	
}
