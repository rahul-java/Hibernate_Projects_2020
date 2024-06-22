package dobP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeCalculator {
	
	
	
	
	 private static Age calAge(Date bDate)
	   {
	      int years = 0;
	      int months = 0;
	      int days = 0;
	 
	      //create calendar object for birth day
	      Calendar bD = Calendar.getInstance();
	      bD.setTimeInMillis(bDate.getTime());
	 
	      //create calendar object for current day
	      long ct = System.currentTimeMillis();
	      Calendar cD = Calendar.getInstance();
	      cD.setTimeInMillis(ct);
	 
	      //Get difference between years
	      years = cD.get(Calendar.YEAR) - bD.get(Calendar.YEAR);
	      int cM = cD.get(Calendar.MONTH) + 1;
	      int bM = bD.get(Calendar.MONTH) + 1;
	 
	      //Get difference between months
	      months = cM - bM;
	 
	      //if month difference is in negative then reduce years by one 
	      //and calculate the number of months.
	      if (months < 0)
	      {
	         years--;
	         months = 12 - bM + cM;
	         if (cD.get(Calendar.DATE) < bD.get(Calendar.DATE))
	            months--;
	      } else if (months == 0 && cD.get(Calendar.DATE) < bD.get(Calendar.DATE))
	      {
	         years--;
	         months = 11;
	      }
	 
	      //Calculate the days
	      if (cD.get(Calendar.DATE) > bD.get(Calendar.DATE))
	         days = cD.get(Calendar.DATE) - bD.get(Calendar.DATE);
	      else if (cD.get(Calendar.DATE) < bD.get(Calendar.DATE))
	      {
	         int today = cD.get(Calendar.DAY_OF_MONTH);
	         cD.add(Calendar.MONTH, -1);
	         days = cD.getActualMaximum(Calendar.DAY_OF_MONTH) - bD.get(Calendar.DAY_OF_MONTH) + today;
	      } 
	      else
	      {
	         days = 0;
	         if (months == 12)
	         {
	            years++;
	            months = 0;
	         }
	      }
	      //Create new Age object 
	      return new Age(days, months, years);
	   }
	 
	   public static void main(String[] args) throws ParseException
	   {
	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      Date birthDate = sdf.parse("04/05/1994");     
	      Age age = calAge(birthDate);
	      System.out.println(age.getYears()+ " "+age.getMonths()+ " "+age.getDays());
	   }
	}
