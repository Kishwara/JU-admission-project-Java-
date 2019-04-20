package sub.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sub.entities.apply;


public class applydao {

		public Connection  getConnection()
		{
			try{
			Class.forName("com.mysql.jdbc.Driver");
	    	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admissioninfo","root",null);
	        return con;
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return null;
		}
	    public void createTable()   // table creation
	    {
	    	try{
	    	Connection con=	getConnection();
	    		
	    		PreparedStatement pst= con.prepareStatement("create table if not exists information(ID int(11) not null auto_increment,Name varchar(100) not null,HSCRoll varchar(100) not null,PhoneNumber varchar(100) not null,Unit varchar(100) not null, Primary key (ID))" );
	    		pst.executeUpdate();
	    		System.out.println("Table Created!");
	    	}catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    }
		public void Insertion(apply I)   //Insertion into the table
		{
	    try{
	    	Connection con= getConnection();
	    	
	    	PreparedStatement pst= con.prepareStatement("insert into information('Name','HSCRoll','PhoneNumber','Unit')values('I.getname()','I.getroll()','I.getphn()','I.geunit()')");
	    	pst.executeUpdate();
	    	System.out.println("Insertion Successful! ");
	    }catch(Exception x)
	    {
	    	System.out.println(x);
	    }
		}
	public 	void ShowAllRecords()//shows all records for Information
		{
	    try{
	    	Connection  con = getConnection();
	    	PreparedStatement pst= con.prepareStatement("Select * from information");
	    	ResultSet rs=pst.executeQuery();
	    	
	    	while(rs.next())
	    	{
	    		System.out.println("Id:"+rs.getString(1));
	    		System.out.println("Name:"+rs.getString(2));
	    		System.out.println("HSC Roll:"+rs.getString(3));
	    		System.out.println("Phone Number:"+rs.getString(4));
	    		
	    		System.out.println("Unit:"+rs.getString(6));
	    	
	    	}
	    	
	    	
	    }catch(Exception x)
	    {
	    	System.out.println(x);
	    }
		}
		public void selection( int p)     //show an individual information 
		{
			try
			{
				Connection con= getConnection();
				PreparedStatement pst=con.prepareStatement("select * from information where ID="+p);
				ResultSet rs = pst.executeQuery();
				System.out.println("Id :"+rs.getString(1));
				System.out.println("Name:"+rs.getString(2));
				System.out.println("HSC Roll:"+rs.getString(3));
				System.out.println("Phone NUmber:"+rs.getString(4));
				System.out.println("Unit:"+rs.getString(5));
				
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		public int CountRecords()
		{
			int count=0;
			try
			{
				Connection con= getConnection();
				PreparedStatement pst= con.prepareStatement("select count(1)  from information");
				ResultSet rs= pst.executeQuery();
				count= rs.getInt("count(1)");
				return count;
				}catch(Exception e)
			{
					System.out.println(e);
			}
			return count;
		}
	}



