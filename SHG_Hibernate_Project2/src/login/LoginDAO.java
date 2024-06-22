package login;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import utility.EncryptionPasswordANDVerification;
import hbnt.SessionUtility;

public class LoginDAO {

	public String login(LoginBean loginBean)
	{  Session s = SessionUtility.getSession();
	Transaction tx = s.beginTransaction();
		try {
			
loginBean.setPass(EncryptionPasswordANDVerification.encryPass(loginBean.getPass()));
		 Criteria cr = s.createCriteria(LoginBean.class);  
           cr.add(Restrictions.eq("uid", loginBean.getUid()));
		  // cr.add(Restrictions.eq("pass", loginBean.getPass()));
		  List<LoginBean> list = cr.list();
		  
		     LoginBean p = list.get(0);
		       
		         if(p.getStatus().equalsIgnoreCase("Y"))
		         {
		        	 
Query q = s.createQuery("update LoginBean l set l.status = ? where l.uid=?");
		      q.setParameter(0, "N");
		      q.setParameter(1, loginBean.getUid());
		   int i=   q.executeUpdate();
		        	if(i>0)
		        	{
		        	 return loginBean.getUid();
		        	}
		         }
		         else if(p.getStatus().equalsIgnoreCase("N"))
		         {
		        	 return "AL";
		         }
		         
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			tx.commit();
		}
		return "WUP";
	}
}
