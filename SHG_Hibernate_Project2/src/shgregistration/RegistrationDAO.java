package shgregistration;

import java.util.List;

import hbnt.SessionUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegistrationDAO {
	public boolean insetSHGDetail(SHGdetail sHGdetail)
	{
		try {
			System.out.println("in dao");
			System.out.println("stcode "+sHGdetail.getStateCode()+ " "+sHGdetail.getDistCode());
			List<SHGMemberDetail> l = sHGdetail.getMlist();
			System.out.println("size "+l.size());
			
			for(SHGMemberDetail p:l)
			{
				System.out.println(p.getAge()+ " "+p.getCadhar()+ " "+p.getCname());
			}
			Session s = SessionUtility.getSession();
			Transaction x = s.beginTransaction();
			s.save(sHGdetail);
			x.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
