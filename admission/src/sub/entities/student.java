package sub.entities;

import java.util.Scanner;

public class student{
	;
   private String UserName=new String();
     private String Password=new String();
   
     private Scanner scan;

	public student() {
	
   	    
         UserName=" ";
         Password=" ";
    

	}
public student(String UserName,String Password) {
		
		this.UserName= UserName;
		
		this.Password=Password;
	}
    public void getinfo()
    {
    	 scan=new Scanner(System.in);
            System.out.println("\tEnter User Name :");
            UserName=scan.nextLine();
            
            
           
           System.out.println("\tEnter Password:");
           Password=scan.next();
            
          
    }
	  public void show()
	  {
		  System.out.println("User Name:"+UserName);
		
		  System.out.println("Password:");
		  for(int i=0;i<Password.length();i++)
		  {
			  System.out.print("*");
		  }
		 
		  
	  }
	  
	
		public String getuser() {
			return UserName;
		}
		public String getpass() {

			return Password;
		}
	
	public void setuser(String UserName) {
		this.UserName=UserName;
	}
	public void setpass(String Password) {

		this.Password= Password;
	}
	
	
	
	 
}




