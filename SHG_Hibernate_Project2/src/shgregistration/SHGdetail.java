package shgregistration;

import java.util.List;

public class SHGdetail {
	long shgCode;
	int stateCode;
    String distCode;
    String shgName;
    String acount;
    String ifsc;
    List<SHGMemberDetail> mlist;
    
  
	public long getShgCode() {
		return shgCode;
	}
	public void setShgCode(long shgCode) {
		this.shgCode = shgCode;
	}
	public List<SHGMemberDetail> getMlist() {
		return mlist;
	}
	public void setMlist(List<SHGMemberDetail> mlist) {
		this.mlist = mlist;
	}
	
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public String getDistCode() {
		return distCode;
	}
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}
	public String getShgName() {
		return shgName;
	}
	public void setShgName(String shgName) {
		this.shgName = shgName;
	}
	public String getAcount() {
		return acount;
	}
	public void setAcount(String acount) {
		this.acount = acount;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
    
}
