package utility;

import java.util.Random;

public class UserValidation {
	
	
	public static String generateUID(String name,String dob)
	{
	  StringBuilder sb = new	StringBuilder();
	  for(int i=0; i<10; i++)
	  {
		  sb.append(new Random().nextInt(10));
	  }
	  return name.substring(0,3)+"-"+sb.substring(7)+"-"+dob;
	}
	
	
	
	public static String checkSkills(String skills)
	{
		if(skills.length()>1)
		{
			return skills;
		}
		else
		{
			return "no skill";
		}
	}

}
