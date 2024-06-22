package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import max.Father;
import max.JDBCUtility;

public class ViewDAO {
	public Map<String,Object> fatchChildFatherDetails()
	{   
		Map<String,Object> m=new HashMap<String, Object>();
		ResultSet rs=null;
	    Connection con=null;
	    Statement s=null;
	     List<Father> flist=new ArrayList<Father>();
	     List<ChildDTO> clist=new ArrayList<ChildDTO>();
		try { 
			con = JDBCUtility.getConn();
			s = con.createStatement();
			 rs = s.executeQuery("select * from father_details");
			 while(rs.next())
			 {
				 Father f=new Father();
				f.setPid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setAdhar(rs.getString(3));
				f.setDob(rs.getString(4));
				f.setGender(rs.getString(5));
				f.setStateCode(rs.getString(6));
				f.setDistrictCode(rs.getString(7));
				f.setEdu(rs.getString(8));
				flist.add(f);
				
			 }
			 
			 if(flist.size()>0)
			 {
				s= con.createStatement();
				rs=s.executeQuery("select * from child_details");
				
				while(rs.next())
				{
					ChildDTO cdto=new ChildDTO();
					cdto.setCid(rs.getInt(1));
					cdto.setName(rs.getString(2));
					cdto.setAge(rs.getString(3));
					cdto.setAdhar(rs.getString(4));
					cdto.setPid(rs.getInt(5));
					clist.add(cdto);
				}
				
				
			 }
			 
			m.put("fdetails", flist) ;
			m.put("cdetails", clist) ; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

}
