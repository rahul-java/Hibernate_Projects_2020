package max;

import java.util.List;

public class HQLCL {
	public static void main(String[] args) {
		List<Father> list = HQLFatch.getAllRecords(1);
		
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
