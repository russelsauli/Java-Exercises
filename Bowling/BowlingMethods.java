package Bowling;

import java.util.Random;
import java.util.Scanner;
public class BowlingMethods {
    
	Scanner input= new Scanner(System.in);
	
	Random random = new Random();

	final int frames=10;

	int numberofplayer=0;

	String print="";
	
	Scores player1 = new Scores(1,0);
	Scores player2 = new Scores(2,0);
	Scores player3 = new Scores(3,0);
	Scores player4 = new Scores(4,0);
	Scores player5 = new Scores(5,0);
	Scores player6 = new Scores(6,0);
	//Get  how many player
	public void Playercounter() {
		print="";
		try {
			
			do {
				System.out.print("\nHow many player? :");
				numberofplayer=input.nextInt();
				
				if(numberofplayer<=0) {
					System.out.print("Number of player should be 1 or higher");
				}
				if(numberofplayer>6) {
					System.out.print("Maximum player is 6");
				}
				
			}while(numberofplayer<=0 ||numberofplayer>6);
			
			Scoretable();
			Winner();
			Continue();

		}catch(Exception e) {
			System.out.print("Incorrect input\n");
			input.next();
			Continue();
		}
	}
	// continue if the get player do try catch 
	public void Continue() {
		
		boolean Iscontinue=false;
		String contiueinput=null;
		
		do {
			System.out.print("\nContinue Y/N? :");
			try {
				contiueinput=input.nextLine();
			}
			catch(Exception e) {
				System.out.print("Incorrect input");
			}
			
			if(contiueinput.equalsIgnoreCase("Y")) {
				Restart();
				Playercounter();
				Iscontinue=true;
			}
			
			else if(contiueinput.equalsIgnoreCase("N")) {
				System.out.println("GAME END");	
				Iscontinue=true;
			}
			
			else {
				Iscontinue=false;
			}
			
		}while(Iscontinue==false);
		
	}
	
	// Throw of player and update score 
	public void Scoretable(){

		String lines="";

		// table header
		for (int countline=0;countline<=numberofplayer;countline++) {
			lines+="===";
		}

		print=print+"\n"+lines+"SCORE BOARD"+lines;
		print=print+"\nPlayer";

		for (int players=1;players<=numberofplayer;players++) {
			print=print+"\t P"+players;
		}
		//
		for(int currentframe=1;currentframe<=frames;currentframe++) {
            // System.out.println("Press enter to start bowing");	
           
			print=print+"\nF:"+currentframe;
            
			for(int currentplayer=1;currentplayer<=numberofplayer;currentplayer++) {
				
				int throwtakedown=0;
				int pins=10;
				int numberoftrow=0;
				int totalpindown=0;
				int updatescore=0;

				print=print+"\t";

				for(int numtrow=1;numtrow<=2;numtrow++) {
					
					input.nextLine();
					
					if(pins>=1) {
						
						throwtakedown=random.nextInt(pins+1);

						pins=pins-throwtakedown;

						totalpindown+=throwtakedown;

						numberoftrow++;

						print=print+throwtakedown+"|";
						
						Print();
					}
					else{

						print=print+"-|";
						Print();
					}
				}
				
				if(totalpindown==10&&numberoftrow==1) {
					updatescore=20;
				}

				else if(totalpindown==10&&numberoftrow==2) {
					updatescore=15;
				}
	
				else {
					updatescore=totalpindown;
				}

				UpdateScoreplayer(currentplayer,updatescore);
				Print();
			}
			print=print+"\n"+lines+"============"+lines;
		}
	}
	
	public void UpdateScoreplayer(Integer player ,Integer score){

		if(player==1){
			player1.setScore(score+player1.getScore());
		}
		else if(player==2){
			player2.setScore(score+player2.getScore());
		}
		else if(player==3){
			player3.setScore(score+player3.getScore());
		}
		else if(player==4){
			player4.setScore(score+player4.getScore());
		}
		else if(player==5){
			player5.setScore(score+player5.getScore());
		}
		else if(player==6){
			player6.setScore(score+player6.getScore());
		}
	}

	public void Dispayupdatedscore(){

		System.out.print("\nScores");	

		if(numberofplayer==1){
			System.out.print("\t "+player1.getScore());	
		}

		else if(numberofplayer==2){
			System.out.print("\t "+player1.getScore());	
			System.out.print("\t "+player2.getScore());	
		}

		else if(numberofplayer==3){
			System.out.print("\t "+player1.getScore());	
			System.out.print("\t "+player2.getScore());	
			System.out.print("\t "+player3.getScore());	
		}

		else if(numberofplayer==4){
			System.out.print("\t "+player1.getScore());	
			System.out.print("\t "+player2.getScore());	
			System.out.print("\t "+player3.getScore());	
			System.out.print("\t "+player4.getScore());	
		}

		else if(numberofplayer==5){
			System.out.print("\t "+player1.getScore());	
			System.out.print("\t "+player2.getScore());	
			System.out.print("\t "+player3.getScore());	
			System.out.print("\t "+player4.getScore());	
			System.out.print("\t "+player5.getScore());	
		}

		else if(numberofplayer==6){
			System.out.print("\t "+player1.getScore());	
			System.out.print("\t "+player2.getScore());	
			System.out.print("\t "+player3.getScore());	
			System.out.print("\t "+player4.getScore());	
			System.out.print("\t "+player5.getScore());	
			System.out.print("\t "+player6.getScore());	
		}
	}

	public void Print(){

		System.out.println("\033[H\033[2J");
		System.out.flush();
		System.out.print(print);
		Dispayupdatedscore();
	}

	public void Winner(){

		int highscore=0,player=0;

		if(player1.getScore()>=highscore){
			highscore=player1.getScore();
			player=1;
		}

		if(player2.getScore()>=highscore){
			highscore=player2.getScore();
			player=2;
		}

		if(player3.getScore()>=highscore){
			highscore=player3.getScore();
			player=3;
		}

		if(player4.getScore()>=highscore){
			highscore=player4.getScore();
			player=4;
		}

		if(player5.getScore()>=highscore){
			highscore=player5.getScore();
			player=5;
		}

		if(player6.getScore()>=highscore){
			highscore=player6.getScore();
			player=6;
		}

		System.out.print("\n\nWinner Player "+player+" with score of "+highscore+"\n");
	}
	
	public void Restart(){

		player1 = new Scores(1,0);
		player2 = new Scores(2,0);
		player3 = new Scores(3,0);
		player4 = new Scores(4,0);
		player5 = new Scores(5,0);
		player6 = new Scores(6,0);
	}
}
