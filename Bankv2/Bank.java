package Bankv2;

import java.util.Scanner;
import java.text.NumberFormat;

public class Bank {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
       
        PersonalAcct personalaccount = new PersonalAcct(500.00,500.00, "Maria", "Munoz", "110 Glades Road","Mytown", "FL", "33445");
        BusinessAcct businessaccount = new BusinessAcct(1000.00,1000.00, "Maria", "Munoz", "110 Glades Road","Mytown", "FL", "33445");
     
        Account munozAccount = new Account(250, "Maria", "Munoz", "110 Glades Road",
        "Mytown", "FL", "33445");
       
        double data=0.00;
        int account=0;
        String continuebank;
        boolean isAccount=false,isDeposit=false,iswithdraw=false,isContinue=false;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        System.out.println(munozAccount);

        do{

            do{
           
                System.out.println("\nSelect Account");
                System.out.println("[1] For Personal account");
                System.out.println("[2] For Buiness account");
                System.out.println("[0] To Exit");
                System.out.print("Selected Account: ");
    
                try{
                    account = input.nextInt();
                    if(account==1){
                        isAccount=true;
                        munozAccount=personalaccount;
                        
                    }
                    else if(account==2){
                        isAccount=true;
                        munozAccount=businessaccount;
                    }
                    else if(account==0){
                        System.out.println("End of Program\n");
                        System.exit(0);
                        
                    }
                    else{
                        System.out.println("Choices are only 1 and 2\n");
                        isAccount=false;
                    }
                }
                catch(Exception e){
                    System.out.println("Incorrect input\n");
                    input.next();
                    account=0;
                }
            }while(isAccount!=true);
    
            do{
                System.out.print("\nEnter deposit amount: ");
                try{
                    data = input.nextDouble();
                    if(data<0){
                        System.out.print("input is less than 0");
                    }
                    else{
                        isDeposit=true;
                    }
                    
    
                } catch(Exception e){
                    System.out.print("\nIncorrect input: ");
                    input.next();
    
                }
                
    
            }while(isDeposit==false);
           
            munozAccount.deposit(data);
            System.out.println("Balance is: " + money.format(munozAccount.getBalance()));
    
            do{
                System.out.print("\nEnter withdrawal amount: ");
                
                try{
                    data = input.nextDouble();
                    if(data<0){
                        System.out.print("input is less than 0");
                    }
                    else{
                        iswithdraw=true;
                    }
                } catch(Exception e){
                    System.out.print("\nIncorrect input: ");
                    input.next();
    
                }
            }while(iswithdraw==false);
    
            munozAccount.withdrawal(data,account);
            System.out.println("Balance is: " + money.format(munozAccount.getBalance())); 
    
            
            if(account==1){
                personalaccount.setPersonalBalance(munozAccount.getBalance());
            }
            else{
                businessaccount.setBusinessBalance(munozAccount.getBalance());
            }

            
            System.out.println("\nContinue: Y/N"); 

            continuebank=input.next();
            if(continuebank.equalsIgnoreCase("Y")){
                isContinue=false;
            }
            else{
                System.out.println("System End  "); 
                isContinue=true;
            }
        }while(isContinue==false);

      

    }
}
