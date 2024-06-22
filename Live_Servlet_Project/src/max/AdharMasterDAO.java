package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AdharMasterDAO {
public String getDetails(String adhar)
{
	try {
		
		Session s = SessionUtility.getSesss();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(AdharBean.class);
		cr.add(Restrictions.eq("adhar", adhar));
		
	List<AdharBean> list = cr.list();
	tx.commit();
		for(AdharBean p:list)
		{
			System.out.println(p.getUname()+","+p.getDob()+","+p.getAdd());
			return p.getUname()+","+p.getDob()+","+p.getAdd();
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	
	
	
}
}
