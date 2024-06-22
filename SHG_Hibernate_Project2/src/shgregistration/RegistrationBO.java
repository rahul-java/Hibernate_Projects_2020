package shgregistration;

import java.util.ArrayList;
import java.util.List;

import master.DistrictDAO;

public class RegistrationBO {
	public boolean getRegistrationData(RegistrationBean registrationBean)
	{  
    List<SHGMemberDetail> list=new ArrayList<SHGMemberDetail>();
		SHGdetail sHGdetail=new SHGdetail();
		
	sHGdetail.setStateCode(DistrictDAO.getStCode(registrationBean.getStateName()));
	sHGdetail.setDistCode(registrationBean.getDistCode());
		sHGdetail.setAcount(registrationBean.getAcount());
		sHGdetail.setIfsc(registrationBean.getIfsc());
		sHGdetail.setShgName(registrationBean.getShgName());
		String[] a = registrationBean.getAge();
		System.out.println(a[0]);
		String[] ad = registrationBean.getCadhar();
		String[] n = registrationBean.getCname();
		for(int i=0; i<a.length;i++)
		{
	    SHGMemberDetail sHGMemberDetail=new SHGMemberDetail();
		sHGMemberDetail.setAge(a[i]);
		sHGMemberDetail.setCadhar(ad[i]);
		sHGMemberDetail.setCname(n[i]);
		list.add(sHGMemberDetail);
			
			
		}
		
		sHGdetail.setMlist(list);
		return new RegistrationDAO().insetSHGDetail(sHGdetail);
	}

}
