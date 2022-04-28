package CourseGrades;

import java.util.Scanner;

import java.io.*;


public class GradeBook {

    Grades gradeslist= new Grades() ;

    File textFile = new File("C:\\Users\\NORIMA\\Desktop\\Reeading Materials\\Excercises\\RedoExcercises\\CourseGrades\\GradeBook.dat");

    FileOutputStream out ;
    ObjectOutputStream writeStu; 

    FileInputStream in  ;
    ObjectInputStream readStu;

    int indexstudent=0,testnumber=1, numberOfStudent=gradeslist.numberofStudent();
   
    String [] tempStudentName= new String[numberOfStudent] ;
    Integer[][] tempGrades = new Integer[numberOfStudent][6];

    Scanner input= new Scanner(System.in);

    public void getGradess() {

        int inputgrade;
        String studentname;

        while(indexstudent<numberOfStudent){

            System.out.println("\nInput Student name");
            studentname=input.nextLine();
          
            tempStudentName[indexstudent]=studentname;

            do{

                while(testnumber<=5){

                    System.out.print("\n"+tempStudentName[indexstudent]+"\nEnter Test "+(testnumber)+" grade: ");
                    
                    try{

                        inputgrade=input.nextInt();

                        if(inputgrade<0){

                            System.out.println("\nInput grade is less than 0");
                        }
                        else{

                            tempGrades[indexstudent][0]=(indexstudent+1);
                            tempGrades[indexstudent][testnumber]=inputgrade;
                            testnumber++;    
                        } 
                    }catch(Exception e){

                        System.out.println("Incorrect input");
                        input.next();
                    }
                }

            }while(testnumber<=5);
            
            testnumber=1;
            indexstudent++;
            input.nextLine();
        } 

        gradeslist.SetGradesdata(tempGrades);
        gradeslist.SetGradesdata(tempGrades);
        Printtofile();
	}
   
    public void ShowGrade() {

        double average=0.00;
        String format="%20s %12s %15s %15s %15s %15s %15s";
        
        System.out.print("\nGrades of all student");
        System.out.format(format,"\nStudent","Tetst1","Tetst2","Tetst3","Tetst4","Tetst5","Average");

        for(int student=0; student<numberOfStudent;student++){

            System.out.print("\n"+tempStudentName[student]);

            for(int testnumber=1; testnumber<=5;testnumber++){

                System.out.print("\t\t"+tempGrades[student][testnumber]);
                average=tempGrades[student][testnumber];
            }
            System.out.print("\t\t"+average);
        }
        System.out.print("\n");
	}

    public Double studentAvg(int  student) {
       double testgrade=0.00;
       int index=0;

       while(!tempGrades[index][0].equals(student)){
           index++;
       }

       System.out.print("\n"+tempStudentName[index]+"\n");

       for(int test=1; test<=5;test++){

           testgrade+=tempGrades[index][test];
           System.out.print("\nTest:"+test+" grade "+tempGrades[index][test]);
       }

        testgrade=((testgrade/5)*100)/100;

		return testgrade;
	}

    public Double testAvg(int test) {

        double testaverage=0.00;
        String format="%10s %20s";
       
        for (int student=0;student<numberOfStudent;student++) {
            System.out.format(format,"\n"+tempStudentName[student], "\tTest "+test+" grade :"+tempGrades[student][test]);
            testaverage+=tempGrades[student][test];  
        }

        testaverage=testaverage/numberOfStudent;
        
		return testaverage;
	}

    public Boolean IsContinue(){

        boolean iscontinue=false;
        String continues="";

        System.out.println("Continue press Y to continue");
        
        continues=input.next();
        
        if(continues.equalsIgnoreCase("Y")){
            iscontinue=false;
        }
        else{
            iscontinue=true;
        }

        return(iscontinue);

    }
    
    public void Choices(){

        int process=0,selectedtest=0;
        boolean iscontinue=false;

        do{
            System.out.println("\nSELECT PROCESS");
            System.out.println("[1]-Display all student Grade");
            System.out.println("[2]-Display per student Grade");
            System.out.println("[3]-Display per test Grade");
            System.out.println("[4]-Exit");
            System.out.print("SELECT : ");
            try{
                process=input.nextInt();
                
            }
            catch(Exception e){
                input.next();
                Choices();
            }
        
        }while(process>4 || process<0);

        if(process==1){
            ShowGrade();
            Choices();
        }

        else if(process==2){
            
            int student=0;
            double studentTestAverage=0.00;

            do{
                try{
                    System.out.print("\nSelect Student number: ");
    
                    student=input.nextInt();
                    studentTestAverage=studentAvg(student);
    
                    System.out.print("\nStudent "+student+" total test average: "+studentTestAverage+"\n");
                    iscontinue=true;

                }catch(Exception e){
                    System.out.println("\nTheres no student "+student+" exist");
                    input.next();
                    iscontinue=IsContinue();
                }

            }while(iscontinue==false);

            iscontinue=false;

            Choices();

        }
        else if(process==3){

            double averagetest=0;
            do{
                try{
                    System.out.print("\nSelect Test: ");

                    selectedtest=input.nextInt();
                    averagetest=testAvg(selectedtest);
    
                    System.out.println("\n\nTotal average of test "+selectedtest+" "+averagetest);
                    iscontinue=true;
                    
                }
                catch(Exception e){

                    System.out.println("Theres no test "+selectedtest+" exist");
                    input.next();
                    iscontinue=IsContinue();
                }

            }while(iscontinue==false);

            iscontinue=false;

            Choices();
        }
        else if(process==4){
            System.out.println("End of program");
            System.exit(0);
            
        }
    }

    public void FileLoad(){

        if(textFile.exists()){
            LoadData();
            Choices();
        }

        else{
           getGradess();
           Printtofile();
           Choices();
        }
    }

    public void Printtofile(){
        try {

            out = new FileOutputStream(textFile);
            writeStu = new ObjectOutputStream(out);

            writeStu.writeObject(new Grades(tempGrades, tempStudentName));
            writeStu.close();

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            System.err.println("FileNotFoundException: " 
            + e.getMessage());
            } catch (IOException e) {
            System.out.println("Problem with input/output.");
            System.err.println("IOException: " + e.getMessage());
        }
       
        
    }
    public void LoadData(){
        
        try {
            in = new FileInputStream(textFile);
            readStu = new ObjectInputStream(in);

            Grades grades = (Grades)readStu.readObject();
            
            tempGrades=grades.GetGradesdata();
            tempStudentName=grades.GetStudentdata();
            readStu.close();

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            System.err.println("FileNotFoundException: " 
            + e.getMessage());
         } catch (IOException e) {
            System.out.println("Problem with input/output.");
            System.err.println("IOException: " + e.getMessage());
            } catch (ClassNotFoundException e) {
            System.out.println("Class could not be used to cast object.");
            System.err.println("ClassNotFoundException: " 
            + e.getMessage());
            }
    }
}


