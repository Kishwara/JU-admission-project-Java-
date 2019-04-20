package sub.dao;
import sub.entities.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import java.sql.*;
import java.util.ArrayList;

public class studentdao {
	public Connection  getConnection()
	{
		Connection con=null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
    	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admissioninfo","root",null);
        return con;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
public void createTable()  throws Exception // table creation
    {
    	Connection con=null;
    	Statement pst= null;
    	
    	try{
    	 con=	getConnection();
    		
    		pst= con.createStatement();
    		pst.executeUpdate("create table if not exists Information(UserId int auto_increment not null,UserName varchar(255) not null,Password varchar(255) not null, Primary key (Id))" );
    		System.out.println("Table Created!");
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	finally
		{
			try
			{
				con.close();
				pst.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
    }
public void Insertion(student I) throws Exception   //Insertion into the table
	{
		
		  Connection con=null;
		  Statement pst=null;
    	
    try{
    	 con= getConnection();
    	 pst= con.createStatement();
    	pst.executeUpdate("insert into Information(UserName,Password)values('"+I.getuser()+I.getpass()+")");
    	System.out.println("Insertion Successfull! ");
    }catch(Exception x)
    {
    	System.out.println(x);
    }
    finally
	{
		try
		{
			con.close();
			pst.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
public void ShowAllRecords() throws Exception//shows all records for Information
	{
	  ResultSet rs= null;
	  Connection con=null;
	  Statement pst=null;
	
    try{
    	 con = getConnection();
    	 pst= con.createStatement();
    	 rs=pst.executeQuery("Select * from Information");
    	
    	while(rs.next())
    	{
    		System.out.println("Id:"+rs.getInt(1));
    		System.out.println("UserName:"+rs.getString(2));
    		
    		 System.out.println("All are selected!");
    	    
    	}
    	con.close();
		pst.close();
		rs.close();
	
    	
    	
    }catch(Exception x)
    {
    	System.out.println(x);
    }
  
	
	}
public int UserPasswordMatch(String u,String p) //shows all records for Information
{
  ResultSet rs= null;
  Connection con=null;
  Statement pst=null;
  boolean chkU,chkP;

try{
	 con = getConnection();
	 pst= con.createStatement();
	 rs=pst.executeQuery("Select * from Information");
	 
	
	while(rs.next()){
		chkU=u.equals(rs.getString("UserName"));
		chkP=p.equals(rs.getString("Password"));
		if(chkU){
			if(chkP){
				System.out.println("Logged in!!!");
				return rs.getInt("ID");
				
			}
		}
		
   }
	
	con.close();
	pst.close();
	rs.close();
	return 0;
	
}catch(Exception x)
{
	System.out.println(x);
}
return 0;


}


public void selection( int p) throws Exception     //show an individual information 
	{
		  ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		  int count=0;
		
		try
		{
			con= getConnection();
		    pst=con.createStatement();
			rs = pst.executeQuery("select * from Information ");
			while(rs.next())
			{
			 count++;
			 if(count==p){
				    System.out.println("Id:"+rs.getInt(1));
		    		System.out.println("Name:"+rs.getString(2));
		    		
			 }
			}
			con.close();
			pst.close();
			rs.close();
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

	@SuppressWarnings("finally")
public int CountRecords() throws Exception
	{
		ResultSet rs= null;
		Connection con=null;
		Statement pst=null;
		int count=0;
		try
		{
		 con= getConnection();
		 pst= con.createStatement();
		 rs= pst.executeQuery("select *  from Information ");
	    while(rs.next())
	    {
	    	count++;
	    }
	    con.close();
		pst.close();
		rs.close();
		
			return count;
	    }catch(Exception e){
				System.out.println(e);
		}
		
			return count;
		
	}
}




/* package sub.dao;
import sub.entities.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sub.entities.student;

import java.sql.*;
import java.util.ArrayList;

public class studentdao {
	public Connection  getConnection()
	{
		Connection con=null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
    	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admissioninfo","root",null);
        return con;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
public void createTable()  throws Exception // table creation
    {
    	Connection con=null;
    	Statement pst= null;
    	
    	try{
    	 con=	getConnection();
    		
    		pst= con.createStatement();
    		pst.executeUpdate("create table if not exists user(UserId int auto_increment not null, not null,UserName varchar(100) not null,Password varchar(100) not null, Primary key (UserId))" );
    		//System.out.println("Table Created!");
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	finally
		{
			try
			{
				con.close();
				pst.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
    }
public void Insertion(student I) throws Exception   //Insertion into the table
	{
		
		  Connection con=null;
		  Statement pst=null;
    	
    try{
    	 con= getConnection();
    	 pst= con.createStatement();
    	pst.executeUpdate("insert into user(Username,Password)values('"+I.getuser()+"'"+",'"+I.getpass()+")");
    	System.out.println("Insertion Successfull! ");
    }catch(Exception x)
    {
    	System.out.println(x);
    }
    finally
	{
		try
		{
			con.close();
			pst.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
public void ShowAllRecords() throws Exception//shows all records for Information
	{
	  ResultSet rs= null;
	  Connection con=null;
	  Statement pst=null;
	
    try{
    	 con = getConnection();
    	 pst= con.createStatement();
    	 rs=pst.executeQuery("Select * from user");
    	
    	while(rs.next())
    	{
    		while(rs.next())
	    	{
	    		System.out.println("UserId:"+rs.getString(1));
	    		System.out.println("UserName:"+rs.getString(2));
	    		System.out.println("Password:"+rs.getString(3));
	    		
	    	
	    	}
    	}
    	con.close();
		pst.close();
		rs.close();
	
    	
    	
    }catch(Exception x)
    {
    	System.out.println(x);
    }
  
	
	}
public int UserPasswordMatch(String u,String p) //shows all records for Information
{
  ResultSet rs= null;
  Connection con=null;
  Statement pst=null;
  boolean chkU,chkP;

try{
	 con = getConnection();
	 pst= con.createStatement();
	 rs=pst.executeQuery("Select * from user");
	 
	
	while(rs.next()){
		chkU=u.equals(rs.getString("UserName"));
		chkP=p.equals(rs.getString("Password"));
		if(chkU){
			if(chkP){
				System.out.println("Logged in!!!");
				return rs.getInt("ID");
				
			}
		}
		
   }
	
	con.close();
	pst.close();
	rs.close();
	return 0;
	
}catch(Exception x)
{
	System.out.println(x);
}
return 0;


}


public student selection( int p) throws Exception     //show an individual information 
	{
		  ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		  int count=0;
		
		try
		{
			con= getConnection();
		    pst=con.createStatement();
			rs = pst.executeQuery("select * from user where UserId="+p);
			while(rs.next())
			{
			 count++;
			 
			}
			con.close();
			pst.close();
			rs.close();
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
public float selectBalance( int p)    //show an individual balance 
	{
		  ResultSet rs= null;
		  Connection con=null;
		  Statement pst=null;
		  float bal=0;
		  int count=0;
		try
		{
			 con= getConnection();
		   	pst=con.createStatement();
			 rs = pst.executeQuery("select * from user ");
			while(rs.next())
			{
				count++;
				if(count==p){
					bal=rs.getFloat(6);
				}
				
			}
			con.close();
			pst.close();
			rs.close();
			return bal;
		
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return bal;
		
	}
	@SuppressWarnings("finally")
public int CountRecords() throws Exception
	{
		ResultSet rs= null;
		Connection con=null;
		Statement pst=null;
		int count=0;
		try
		{
		 con= getConnection();
		 pst= con.createStatement();
		 rs= pst.executeQuery("select *  from user ");
	    while(rs.next())
	    {
	    	count++;
	    }
	    con.close();
		pst.close();
		rs.close();
		
			return count;
	    }catch(Exception e){
				System.out.println(e);
		}
		
			return count;
		
	}

	}






/*public class studentdao {

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
	    		
	    		PreparedStatement pst= con.prepareStatement("create table if not exists user(UserId int(11) not null auto_increment,UserName varchar(100) not null,Password varchar(100) not null, Primary key (UserId))" );
	    		pst.executeUpdate();
	    		System.out.println("Table Created!");
	    	}catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    }
		public void Insertion(student I)   //Insertion into the table
		{
	    try{
	    	Connection con= getConnection();
	    	
	    	PreparedStatement pst= con.prepareStatement("insert into user('UserName','Password')values('I.getuser()','I.getpass()')");
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
	    	PreparedStatement pst= con.prepareStatement("Select * from user");
	    	ResultSet rs=pst.executeQuery();
	    	
	    	while(rs.next())
	    	{
	    		System.out.println("UserId:"+rs.getString(1));
	    		System.out.println("UserName:"+rs.getString(2));
	    		System.out.println("Password:"+rs.getString(3));
	    		
	    	
	    	}
	    	
	    	
	    }catch(Exception x)
	    {
	    	System.out.println(x);
	    }
		}
	public int UserPasswordMatch(String u,String p) //shows all records for Information
	{
	  ResultSet rs= null;
	  Connection con=null;
	  Statement pst=null;
	  boolean chkU,chkP;

	try{
		 con = getConnection();
		 pst= con.createStatement();
		 rs=pst.executeQuery("Select * from Information");
		 
		
		while(rs.next()){
			chkU=u.equals(rs.getString("Username"));
			chkP=p.equals(rs.getString("Password"));
			if(chkU){
				if(chkP){
					System.out.println("Logged in!!!");
					return rs.getInt("ID");
					
				}
			}
			
	   }
		
		con.close();
		pst.close();
		rs.close();
		return 0;
		
	}catch(Exception x)
	{
		System.out.println(x);
	}
	return 0;


	}
		public void selection( int p)     //show an individual information 
		{
			try
			{
				Connection con= getConnection();
				PreparedStatement pst=con.prepareStatement("select * from information where UserId="+p);
				ResultSet rs = pst.executeQuery();
				System.out.println("Id :"+rs.getString(1));
				System.out.println("User Name:"+rs.getString(2));
				System.out.println("Password:"+rs.getString(3));
			
				
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
				PreparedStatement pst= con.prepareStatement("select count(1)  from user");
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
	*/




