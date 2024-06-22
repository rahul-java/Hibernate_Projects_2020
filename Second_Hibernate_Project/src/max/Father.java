package max;

import java.util.List;

public class Father {
    int fid;
    String name;
    String add;
    
    List<Child> clist;
    
    
	public List<Child> getClist() {
		return clist;
	}
	public void setClist(List<Child> clist) {
		this.clist = clist;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
    
}
