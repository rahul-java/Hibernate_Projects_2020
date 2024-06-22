package max;

import java.util.List;

public class CriteriaCL {
public static void main(String[] args) {
	
	
	
	List<Father> list = CreteriaDAO.getRecords(1);
	
	for(Father p:list)
	{
		System.out.println( "father " +p.getFid()+" "+p.getName()+" "+p.getAdd());
		List<Child> clist = p.getChildList();
		
		for(Child q:clist)
		{
			System.out.println("child "+q.getCid()+" "+q.getName()+ " "+q.getAge());
		}
		
	}
	
	
}
}
