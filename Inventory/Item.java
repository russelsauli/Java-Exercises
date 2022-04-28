package Inventory;

import java.io.*;

public class Item implements Serializable {
    
    private int stocknumber;
    private int stockquantity;
    private String itemname;

    public Item(Integer stocknumber,Integer stockquantity,String itemname){
        this.stocknumber=stocknumber;
        this.stockquantity=stockquantity;
        this.itemname=itemname;

    }

    public Integer getStockNumber(){
        return(stocknumber);
    }
    public void  setStockName(Integer stocknumber){
        this.stocknumber=stocknumber;
    }

    public Integer getStockquantity(){
        return(stockquantity);
    }

    public void  setStockquantity(Integer stockquantity){
        this.stockquantity=stockquantity;
    }

    public String getItemname(){
        return(itemname);
    }

    public void  setItemname(String itemname){
        this.itemname=itemname;
    }
}
