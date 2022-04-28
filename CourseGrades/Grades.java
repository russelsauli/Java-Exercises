package CourseGrades;

import java.io.Serializable;

public class Grades implements Serializable{

    private final Integer numberOfStudent=12;

    private String [] studentname= new String[numberOfStudent];
    private Integer[][] grades= new Integer[numberOfStudent][6];

    public Grades(Integer[][] grades, String[] studentname){
        this.grades=grades;
        this.studentname=studentname;
    }

    public Grades(){
       
    }
   
    public Integer numberofStudent(){

        return(numberOfStudent);
    }

    
    public void SetGradesdata(Integer[][] grades){

        this.grades=grades;
    }

    public void SetStudentdata(String [] studentname){

        this.studentname=studentname;
    }

    public Integer[][] GetGradesdata(){

       return(grades);
    }

    public String[] GetStudentdata(){

        return(studentname);
    }

}
