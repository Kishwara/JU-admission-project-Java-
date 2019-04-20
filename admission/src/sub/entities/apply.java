package sub.entities;
import java.util.Scanner;

public class apply {

		private String Name=new String();
		private String Unit=new String();
		private String HSCRoll=new String();
		private String PhoneNumber= new String();
		  private Scanner scan;
		

		public apply() {
			Name=" ";
			HSCRoll=" ";
			Unit=" ";
			PhoneNumber=" ";
		
		}
		public apply(String Name,String HSCRoll,String PhoneNumber,String Unit) {
			
			this.Name= Name;
			this.HSCRoll= HSCRoll;
			this.PhoneNumber= PhoneNumber;
			this.Unit=Unit;
		}

		 public void getData()
		    {
		    	 scan=new Scanner(System.in);
		            System.out.println("\t\t\t\tTo Apply For Admission Test Please Enter-");
		            System.out.print("\tName:");
		            Name=scan.nextLine();
		            System.out.print("\tHSC Roll :");
		            HSCRoll=scan.nextLine();
		            System.out.println("\tPhone Number:");
		           PhoneNumber=scan.next();
		           System.out.println("\tUnit:");
		           Unit=scan.next();
		            
		    }
			  public void display()
			  {
				  System.out.println("Name: "+Name);
				  System.out.println("HSC Roll:"+HSCRoll);
				  System.out.println("Phone Number: "+PhoneNumber);
				  System.out.println("Unit: "+Unit);
				  
				  
			  }
		public String getname()
		{
			return Name;
		}
		public String gethroll()
		{
			return HSCRoll;
		}
		public String getunit()
		{
			return Unit;
		}
		public String getphn()
		{
			return PhoneNumber;
		}
		public void setname(String Name)
		{
			this.Name=Name;
		}
		public void setroll(String HSCRoll)
		{
			this.HSCRoll= HSCRoll;
		}
		public void setunit(String Unit)
		{
			this.Unit=Unit;
		}
		public void setphn(String PhoneNumber)
		{
			this.PhoneNumber= PhoneNumber;
		}
}
		
		



