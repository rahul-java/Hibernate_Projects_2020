package dobP;

public class Age {
	private int days;
	   private int months;
	   private int years;
	   
	   
	public Age(int days, int months, int years) {
		super();
		this.days = days;
		this.months = months;
		this.years = years;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	   
}
