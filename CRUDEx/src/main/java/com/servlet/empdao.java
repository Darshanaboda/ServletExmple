package com.servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.servlet.emp;
import com.servlet.emp;
import com.servlet.empdao;

public class empdao {

	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.1.133:3306/training","admin","test");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int save(emp e)
	{
		int status=0;
		try
		{
			Connection con=empdao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into emp(id,name)values(?,?)"); 
			ps.setInt(1,e.getId()); 
            ps.setString(2,e.getName());
            
            status=ps.executeUpdate();  
              
          
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	public static int update(emp e)
	{
		int status=0;
		try
		{
			Connection con=empdao.getConnection();
			PreparedStatement ps=con.prepareStatement("update emp set name=? where id=?");
			ps.setString(1,e.getName());
			ps.setInt(2,e.getId());
			
			status=ps.executeUpdate();   
			 
		}
		catch(Exception ez)
		{
			ez.printStackTrace();
			
		}
		return status;
	}
	
	public static emp getEmployyebyid(int id)
	{
		emp e = new emp();
		
		try
		{
			Connection con=empdao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				
			}
			con.close();
		}catch(Exception ex)
		{
			  ex.printStackTrace();
		}
		return e;
	}
	public static int delete(int id)
	{
		int status=0;
		try
		{
			Connection con=empdao.getConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM emp  WHERE id=? ");
			
			
			ps.setInt(1,id);
			//ps.setString(2,Name);
			 
			status=ps.executeUpdate();
			con.close();
		}	
		catch(Exception e1)
		{e1.printStackTrace();}
		return status;	
		}
	
public static List<emp> view() {
		
		List<emp> students = new ArrayList<emp>();
		
		try {
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from emp");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id);
			System.out.println(name);
		emp sb = new emp(id,name);
			students.add(sb);
			
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return students;
		
}


}
