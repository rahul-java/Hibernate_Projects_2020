package dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import max.ConnectionUtility;
import max.SessionUtility;
import dto.RegisDTO;

public class RegisDAOIMPL implements RegisDAO{

	@Override
	public List<RegisDTO> fatchRegisdetail() {
		
		try {
			Session s = SessionUtility.getSesss();
			Transaction tx = s.beginTransaction();
			Query q = s.createQuery("from RegisDTO");
			tx.commit();
			List<RegisDTO> list = q.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		

	
	
	
	
	
	@Override
	public boolean insertRegisDetail(RegisDTO regisDTO) {
		
	  try {
			
		Session s = SessionUtility.getSesss();
		Transaction tx = s.beginTransaction();
		  String i = (String) s.save(regisDTO);
		  System.out.println("dao "+i);
		  tx.commit();
		if(i.length()>0)
		{
			return true;
		}
		      } catch (Exception e)
		          {
			        e.printStackTrace();
		           }
		return false;
	}

	
	public RegisDTO fatchRegisdetail(String adhar) {
		 try {
			
			Session s = SessionUtility.getSesss();
			Transaction tx = s.beginTransaction();
			Query q = s.createQuery("from RegisDTO where adhar =:adhar");
		      q.setParameter("adhar", adhar);
		      tx.commit();
		     List<RegisDTO> list = q.list();
		     System.out.println("list "+list.size());
		     if(list.size()>0)
		     {
		    	return list.get(0); 
		     }
		 } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
