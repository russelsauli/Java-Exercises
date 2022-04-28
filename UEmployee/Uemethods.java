package UEmployee;


import java.util.Locale;
import java.text.*;
public class Uemethods {
    
    Locale uslocale = new Locale("en","US");
    NumberFormat currency = NumberFormat.getCurrencyInstance(uslocale); // currency value 

    Faculty faculty1= new Faculty(null,null,null);
    Faculty faculty2= new Faculty(null,null,null);
    Faculty faculty3= new Faculty(null,null,null);
    Faculty faculty4= new Faculty(null,null,null);

    Staff staff1= new Staff(null,null,null);
    Staff staff2= new Staff(null,null,null);
    Staff staff3= new Staff(null,null,null);
    Staff staff4= new Staff(null,null,null);

    
    public void Loademployeedata(){
        faculty1=new Faculty("COE","Arthur Nerry",23000.00);
        faculty2=new Faculty("COA","Jessy James",25000.00);
        faculty3=new Faculty("COCSA","JOJO VELASCES",20000.00);
        faculty4=new Faculty("CAS","LARY GATOT",30000.00);

        staff1= new Staff("TEACHER",faculty1.getName(),faculty1.getSalary());
        staff2= new Staff("MAINTENANCE",faculty2.getName(),faculty2.getSalary());
        staff3= new Staff("ACCOUNTANT",faculty3.getName(),faculty3.getSalary());
        staff4= new Staff("OFFICE STAFF",faculty4.getName(),faculty4.getSalary());
    }

    public void ShowData(){

        Loademployeedata();
        String format="%-10s %-10s %-10s\t %-10s\n";

        System.out.print("===========================================================\n");
        System.out.printf(format,"JOB TITLE","\tDEPARTMENT","\tEMPLOYEE NAME","SALARY");
        System.out.print("===========================================================\n");

        System.out.printf(format,staff1.getJobtitle(),"\t"+faculty1.getDepartment(),"\t"+faculty1.getName(),currency.format(faculty1.getSalary()));
        System.out.print("===========================================================\n");

        System.out.printf(format,staff2.getJobtitle(),"\t"+faculty2.getDepartment(),"\t"+faculty2.getName(),currency.format(faculty2.getSalary()));
        System.out.print("===========================================================\n");

        System.out.printf(format,staff3.getJobtitle(),"\t"+faculty3.getDepartment(),"\t"+faculty3.getName(),currency.format(faculty3.getSalary()));
        System.out.print("===========================================================\n");

        System.out.printf(format,staff4.getJobtitle(),"\t"+faculty4.getDepartment(),"\t"+faculty4.getName(),currency.format(faculty4.getSalary()));
        System.out.print("===========================================================\n");

    }
}
