package Inventory;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;




public class Mainmethods {

    ArrayList<Item>inventoryitem= new ArrayList<Item>();
    Item inventory = new Item(0, 0, null);
    Item itemobject=null;
    Scanner input= new Scanner(System.in);
    


    public void LoadData(){
        inventoryitem.add( new Item(1001,50,"Bag"));
        inventoryitem.add( new Item(1002,45,"Shoe"));
        inventoryitem.add( new Item(1003,35,"Book"));
        inventoryitem.add( new Item(1004,25,"Diamond"));

    }

    public void Choices(){

        System.out.print("\n=============================");
        System.out.print("\n|       Select Process      |");
        System.out.print("\n|===========================|");
        System.out.print("\n|[1]-Display inventory      |");
        System.out.print("\n|===========================|");
        System.out.print("\n|[2]-Add new item           |");
        System.out.print("\n|===========================|");
        System.out.print("\n|[3]-Discontinue            |");
        System.out.print("\n============================|");
        System.out.print("\n|[4]-Exit                   |");
        System.out.print("\n=============================\n");
        Process(); 
    }

    public void Process(){

        int selectedprocess=0;
        do{
            System.out.print("Input selection: ");
        
            try{
                selectedprocess=input.nextInt();
            }
            catch(Exception e){
                System.out.print("\nIncorrect input: ");
                input.next();
                Choices();
            }

        }while(selectedprocess>4);
       

        if(selectedprocess==1){
            Displayinventory();
        }

        else if(selectedprocess==2){
            AddIten();  
            
        }

        else if(selectedprocess==3){
            Discontinue();
           
        }
        else if (selectedprocess==4){
            System.out.print("\nEnd of program");
            System.exit(0);
        }
    }
    public void Displayinventory(){
        String format="%-10s %-10s %10s";

        String line="======================";
        System.out.print("\n"+line+"Inventory"+line);
        System.out.format(format,"\n|Stock Number","\t\tItem Name","\t\tStock");
        System.out.print("\n"+line+"========="+line);

        for (Item inventory : inventoryitem) {
            System.out.format(format,"\n"+inventory.getStockNumber(),"\t\t"+inventory.getItemname(),"\t\t"+inventory.getStockquantity()+"");
            System.out.print("\n"+line+"========="+line);

        }
        Choices();

    }

    public void AddIten(){
        
        String itemname="";
        int stock=0;
        boolean istock=false;

        System.out.print("\nInput Item name: ");
        itemname=input.next();

        do{
            System.out.print("\nStock quantity: ");

            try{
                stock=input.nextInt();
                if(stock<0) {
                    System.out.print("\nInput must be greater than 0 \n");
                
                }
                else{
                    System.out.print("\nSuccessfully add new item\n");
                    istock=true;
                }
               
            }
            catch(Exception e){
                System.out.print("\nIncorrect input:\n");
                input.next();
            }
        }
        while(istock!=true);
        
        inventoryitem.add( new Item(inventoryitem.get(inventoryitem.size()-1).getStockNumber()+1,stock,itemname));
        Printtofile();

        Choices();

    }
 
    public void Discontinue(){

        int stocknumber=0;
        int finditem=0;
        boolean isDiscontinue=false;

        do{
            try{
                System.out.print("\nInput Stock number: ");
                stocknumber=input.nextInt();
                isDiscontinue=true;
            }
            catch(Exception e){
                System.out.print("\nIncorrect input: ");
                input.next();
            }

        }
        while(isDiscontinue!=true);
       
        
        try{

            while(!inventoryitem.get(finditem).getStockNumber().equals(stocknumber) && finditem<inventoryitem.size()){
            finditem++; 
            }

            System.out.print("\nSuccessfully discontinue item "+stocknumber+" with item name "+inventoryitem.get(finditem).getItemname()+"\n");

            inventoryitem.get(finditem).setItemname("Discontinue");
            inventoryitem.get(finditem).setStockquantity(0);

        }
        catch(Exception e){
            System.out.print("\nTheres no "+stocknumber+" Stock number exist");
            
        }
        Printtofile();

        Choices();
    }



    public void Findfile(){

        File textFile = new File("C:\\Users\\NORIMA\\Desktop\\Reeading Materials\\Excercises\\RedoExcercises\\Inventory\\Inventory.dat");
        
        if(textFile.exists()){
            
            LoadFromfile();
        }
        else{
            LoadData();
        }
        
    }

    public void LoadFromfile(){
        File textFile = new File("C:\\Users\\NORIMA\\Desktop\\Reeading Materials\\Excercises\\RedoExcercises\\Inventory\\Inventory.dat");
      
       
        try {
            FileInputStream in = new FileInputStream(textFile);
            ObjectInputStream readAccts = new ObjectInputStream(in);
            System.out.println("There are no existing accounts.");
            
           
            for (int i = 0; i < textFile.length(); i++) {
                System.out.println("There are no existing accounts.");
            inventory = (Item)readAccts.readObject();
            System.out.println("There are no existing accounts.");
            inventoryitem.add(inventory);
            }
            
            readAccts.close();
            } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
            } catch (IOException e) {
            System.out.println("Problem with input/output.");
            System.err.println("IOException: " + e.getMessage());
            } catch (ClassNotFoundException e) {
            System.out.println("Class could not be used to cast object.");
            System.err.println("ClassNotFoundException: " + e.getMessage());
            }
      }
        
        
    
    

    public void Printtofile(){
         File textFile = new File("C:\\Users\\NORIMA\\Desktop\\Reeading Materials\\Excercises\\RedoExcercises\\Inventory\\Inventory.dat");
       
        
        try{
            
            FileOutputStream out = new FileOutputStream(textFile);
            ObjectOutputStream writeitem = new ObjectOutputStream(out);

            for (int index=0;index<inventoryitem.size() ;index++ ) {
                writeitem.writeObject(new Item(inventoryitem.get(index).getStockNumber(),inventoryitem.get(index).getStockquantity(),inventoryitem.get(index).getItemname()));
               
            }
            writeitem.close();  
            out.close();


        }
        catch(IOException e){
            System.out.println("Error");

            System.out.print(inventoryitem.get(1).getItemname());

        }
    }
    
   
    
}
