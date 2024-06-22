package bo;

import utility.UserValidation;
import dl.RegisDAOIMPL;
import dto.RegisDTO;
import bean.RegisBean;

public class RegisBOIMPL implements RegisBO{

	
	public boolean getUserRegisDetail(RegisBean regisBean) {
		
		RegisDTO regisDTO=new RegisDTO();
		regisDTO.setUname(regisBean.getUname());
		regisDTO.setAdd(regisBean.getAdd());
		regisDTO.setAdhar(regisBean.getAdhar());
		regisDTO.setDob(regisBean.getDob());
		regisDTO.setEducation(regisBean.getEducation());
		regisDTO.setGender(regisBean.getGender());
		regisDTO.setSkill(UserValidation.checkSkills(regisBean.getSkill()));
		regisDTO.setUid(UserValidation.generateUID(regisBean.getUname(), regisBean.getDob()));
		
		
		return new RegisDAOIMPL().insertRegisDetail(regisDTO);
	}

}
