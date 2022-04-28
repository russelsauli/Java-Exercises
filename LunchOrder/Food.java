package LunchOrder;


 
public class Food {

	private String foodname;
	private double price;
	private double fat;
	private double carbohydrate;
	private double fiber;

    public Food(String foodname,double price,double fat,double carbohydrate,double fiber) {

        this.foodname=foodname;
        this.price=price;
        this.fat=fat;
        this.carbohydrate=carbohydrate;
        this.fiber=fiber;
    }

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public double getFiber() {
		return fiber;
	}
	
	public void setFiber(double fiber) {
		this.fiber = fiber;
	}
	
	
}
