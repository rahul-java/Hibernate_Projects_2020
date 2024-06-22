package max;

import java.util.List;

public class Father
{
  int fid;
  String name;
  String adhar;
  
  List<Child> clist;
  
  
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
public String getAdhar() {
	return adhar;
}
public void setAdhar(String adhar) {
	this.adhar = adhar;
}
public List<Child> getClist() {
	return clist;
}
public void setClist(List<Child> clist) {
	this.clist = clist;
}
  
}
