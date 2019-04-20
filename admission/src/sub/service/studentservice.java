package sub.service;
import sub.entities.*;
import sub.dao.*;

import java.util.Scanner;

import net.java.myproject.entities.Bag;


public class studentservice {

	private String u=new String();
	private String pass= new String();
	
	 private Scanner scan=new Scanner(System.in);
	 private student std= new student();
	private apply ap= new apply();
	private String NAME=new String();
	private String UNIT=new String();
	private String HSCROLL=new String();
	private String PHONENUMBER= new String();
	private applydao apdao= new applydao();
	private studentdao stddao= new studentdao();
	
	private aunit a= new aunit();
	private bunit b= new bunit();
	private cunit c= new cunit();
	private dunit d= new dunit();
	private eunit e= new eunit();
	private funit f= new funit();
	private gunit g= new gunit();
	private hunit h= new hunit();
	private uni un=new uni();
	
	public void signup()
	 { System.out.println("\tEnter User:");
	 
	 u=scan.next();
	 System.out.println("\tEnter Password:");
	 pass=scan.next();
	 
	 //VerificationID();
	 }

	
	  
    
     public void VerificationID() throws Exception
     {
    	 System.out.println("\tPlease Log In with:");
    	 System.out.println("\t User Name:");
    	 
    	 u=scan.next();
    	 System.out.println("\t Password:");
    	 pass=scan.next();
    	
    		 if((std.getuser()).equals(u) && (std.getpass()).equals(pass))
    		 {
    			 System.out.println("Congratulation ! Your Account Has Been Verified .");
    			 menuOption();
    			 
    		 }
    		 else{
    			 System.out.println("Incorrect.Try it again! ");
    			 VerificationID();
    		 }
    	 
    	 
    	 
     }
     
    		 
    	 
    	 
     
     
     public void menuOption()
     {
    	 stddao.createTable();
    	 apdao.createTable();
    	 System.out.print("\t  please type: 1. for Faculty(Unit) information"+"\n"+"2.For Departments\3.to apply in unit"+"\n"+"\t3.Show list"+"\n"+"\t4. Exit.\n");
    	 int op;
    	 op=scan.nextInt();
    	 
    	 if(op==1)
    	 {
    		 Option1();
    		 
    	 }
    	 else if(op==2)
    	 {
    		 Option2();
    	 }
    	 else if(op==3)
    	 {
    		 Option3();
    	 }
    	 
    	 //if(op==4)
    	 
    	 
    	  
    	 
     }
     public void Option1()
     {
    	 uni.facultyinfo();
     }
     public void Option2()
     {System.out.println("\t\t1. A Unit\t2. B Unit\t3. C Unit\t4.D Unit\t\n\t\t5.E Unit\t6.F Unit\t7.G Unit\t8. H Unit\n 0.Main Menu");
     System.out.println("\n\n\t\tPlease Enter your choice  :: ");
     int choice;
     
    	 choice=scan.nextInt();
    	 if(choice==1)
    	 {
    	 a.show_adepts();
    	 }
    	 if(choice==2)
    	 {
    	 b.show_bdepts();
    	 
    	 }
    	 if(choice==3)
    	 {
    	 c.show_cdepts();
    	 }
    	 if(choice==4)
    	 {
    	 d.show_ddepts();
    	 }
    	 if(choice==5)
    	 {
    	 e.show_edepts();
    	 }
    	 if(choice==6)
    	 {
    	 f.show_law();
    	 }
    	 if(choice==7)
    		  g.show_iba();
    	 if(choice==8)
    		 h.show_iit();
    	 if(choice==0)
    		 menuOption();
     

     }
     
     
     public void Option3()    
     {
    	 char cs;
    	 do{

             
             
                System.out.println("\t\t\t\tTo Apply for Admission Please Enter :");              
                System.out.print("\tName:");
       		 NAME=scan.nextLine();
       		  
       		 System.out.print("\n\tHSC Roll:");
       		 HSCROLL=scan.nextLine();
       		 System.out.print("\n\tPhone Number:");
       		 PHONENUMBER=scan.nextLine();
       		System.out.print("\tUnit:");
    		UNIT=scan.nextLine();
       		 ap= new apply(NAME,HSCROLL,PHONENUMBER,UNIT);
       		 apdao.Insertion(ap);
       	
          
             System.out.println("\t\t\t\t Apply for another Unit?(y/n)");
             
             cs=scan.next(".").charAt(0);
              } while(cs=='y');
     }
    

         

    	 
     
     
}
