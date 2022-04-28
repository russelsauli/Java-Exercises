package Palindrome;

import java.util.Scanner;

public class Main {

    static String word;

    static String palindrom="";

    static Scanner input = new Scanner(System.in);
    public static void main(String [] args){
        
        System.out.println("\nEnter a word");
        word=input.nextLine();

        System.out.println(palindrom=IsPalindrome(word));

        input.close();
    }

    static String IsPalindrome(String word){

        String palindrom="";
        word=word.replace(" ", "");
        word=word.toUpperCase();
        word.toCharArray();

        for(int index=0;index<word.length(); index++){
            
            if(word.charAt(index)==word.charAt(word.length()-(1+index))){
                palindrom="Its a Palindrome";
            }
            else{
                palindrom="this is not a Palindrome";
                break;
            }
        }

        return(palindrom);
    }
}
