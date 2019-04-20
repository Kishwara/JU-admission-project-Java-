package sub.service;
import java.util.*;




public class Interface {
	 Scanner scan=new Scanner(System.in);
	studentservice std= new studentservice();
	int n;
	public void welcome()
	{
		System.out.println("\t\t\t********************************************************");
		System.out.println("\t\t\tWelcome to Jahangirnagar University Admission Exhibitor");
		System.out.println("\t\t\t********************************************************");
		
	     System.out.println("please type 1.for Sign Up \n2.Log In 3.Exit");
	     n=scan.nextInt();
	     Choice(n);
	     
	}
    
	
	      
	      
	      
	     
	

	
    
	public void Choice(int n)
	{
		if(n==1)
		{
			std.signup();
		}
	     
	     
	     
	      if(n==2)
	      {
	    	  std.VerificationID();
	    	  
	    	 
	      }
	      
	     
	}
}



