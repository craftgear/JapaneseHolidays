import java.util.ArrayList;
import java.util.Calendar;

public class JapaneseHolidays {
	private Calendar c;
	private int today;
	private int current_month;
	private int current_year;
	
	public JapaneseHolidays(){
		c = Calendar.getInstance();
		initialize();
	}
	
	public JapaneseHolidays(int year, int month, int day){
		c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, day);
		initialize();
	}
	
	public void initialize(){
		//今日の日付を取得
		today = c.get(Calendar.DAY_OF_MONTH);
		current_month = c.get(Calendar.MONTH);//月ー1が返る
		current_month = current_month + 1;
		current_year = c.get(Calendar.YEAR);
	}
	
	private int getDayOfWeek(int day, int month, int year){
		Calendar temp_c = Calendar.getInstance();
		temp_c.set(Calendar.DATE, day);
		temp_c.set(Calendar.MONTH, month-1);
		temp_c.set(Calendar.YEAR, year);
		return temp_c.get(Calendar.DAY_OF_WEEK);
	}
	
	public boolean isMonday(int day){
		return isMonday(day, current_month, current_year);
	}
	
	public boolean isFriday(int day){
		return isFriday(day, current_month, current_year);
	}
	
	public boolean isSaturday(int day){
		return isSaturday(day, current_month, current_year);
	}
	
	public boolean isSunday(int day){
		return isSunday(day, current_month, current_year);
	}
	
	public boolean isHoliday(int day){
		return isHoliday(day, current_month, current_year);
	}
	
	public boolean isMonday(int day, int month, int year){
		if(getDayOfWeek(day, month, year) == Calendar.MONDAY){
			return true;
		}
		return false;
	}
	
	public boolean isFriday(int day, int month, int year){
		if(getDayOfWeek(day, month, year) == Calendar.FRIDAY){
			return true;
		}
		return false;
	}
	
	public boolean isSaturday(int day, int month, int year){
		if(getDayOfWeek(day, month, year) == Calendar.SATURDAY){
			return true;
		}
		return false;
	}
	
	public boolean isSunday(int day, int month, int year){
		if(getDayOfWeek(day, month, year) == Calendar.SUNDAY){
			return true;
		}
		return false;
	}
	
	public boolean isHoliday(int day, int month, int year){
		if(getHolidays(month).indexOf(day) > -1){
			return true;
		}
		return false;
	}
	
	public ArrayList<Integer> getHolidays(int month){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Calendar temp_c = Calendar.getInstance();
		int year = temp_c.get(Calendar.YEAR);
		switch(month){
		case 1:
			//元日
			result.add(1);
			//日本の公的機関における休日 2,3
			result.add(2);
			result.add(3);
			//成人の日
			int the_second_monday_on_jan = getFirstMonday(month) + 7;
			result.add(the_second_monday_on_jan);
			break;
		case 2:
			//建国記念の日
			result.add(11);
			break;
		case 3:
			//春分の日 簡易計算
			switch(year % 4){
			case 0:
			case 1:
			case 2:
				result.add(20);
				break;
			case 3:
				result.add(21);
				break;
			}
			break;
		case 4:
			//昭和の日
			result.add(29);
			break;
		case 5:
			//憲法記念日
			result.add(3);
			//みどりの日
			result.add(4);
			//こどもの日
			result.add(5);
			break;
		case 6:
			break;
		case 7:
			//海の日
			int the_third_monday_on_jul = getFirstMonday(month) + 14;
			result.add(the_third_monday_on_jul);
			break;
		case 8:
			break;
		case 9:
			//敬老の日
			int the_third_monday_on_sep = getFirstMonday(month) + 14;
			result.add(the_third_monday_on_sep);
			//秋分の日 簡易計算
			switch(year % 4){
			case 0:
			case 1:
				result.add(22);
				break;
			case 2:
			case 3:
				result.add(23);
				break;
			}
			break;
		case 10:
			//体育の日
			int the_second_monday_on_oct = getFirstMonday(month) + 7;
			result.add(the_second_monday_on_oct);
			break;
		case 11:
			//文化の日	
			result.add(3);
			//勤労感謝の日
			result.add(23);
			break;
		case 12:
			//天皇誕生日
			result.add(23);
			//日本の公的機関における休日 29,30,31
			result.add(29);
			result.add(30);
			result.add(31);
			break;
		}
		return result;
	}
	
	private int getFirstMonday(int month){
		Calendar temp_c = Calendar.getInstance();
		//Calendarの月の定数は0インデックス､すなわち一月は0
		switch(month){
		case 1:
			temp_c.set(Calendar.MONTH, Calendar.JANUARY);
			break;
		case 2:
			temp_c.set(Calendar.MONTH, Calendar.FEBRUARY);
			break;
		case 3:
			temp_c.set(Calendar.MONTH, Calendar.MARCH);
			break;
		case 4:
			temp_c.set(Calendar.MONTH, Calendar.APRIL);
			break;
		case 5:
			temp_c.set(Calendar.MONTH, Calendar.MAY);
			break;
		case 6:
			temp_c.set(Calendar.MONTH, Calendar.JUNE);
			break;
		case 7:
			temp_c.set(Calendar.MONTH, Calendar.JULY);
			break;
		case 8:
			temp_c.set(Calendar.MONTH, Calendar.AUGUST);
			break;
		case 9:
			temp_c.set(Calendar.MONTH, Calendar.SEPTEMBER);
			break;
		case 10:
			temp_c.set(Calendar.MONTH, Calendar.OCTOBER);
			break;
		case 11:
			temp_c.set(Calendar.MONTH, Calendar.NOVEMBER);
			break;
		case 12:
			temp_c.set(Calendar.MONTH, Calendar.DECEMBER);
			break;
		}
		temp_c.set(Calendar.DATE, 1);
		int the_first_day_of_week_in_month = temp_c.get(Calendar.DAY_OF_WEEK);
		int the_first_monday_day = 0;
		switch(the_first_day_of_week_in_month){
		case Calendar.SUNDAY:
			the_first_monday_day = 2;
			break;
		case Calendar.MONDAY:
			the_first_monday_day = 1;
			break;
		case Calendar.TUESDAY:
			the_first_monday_day = 7;
			break;
		case Calendar.WEDNESDAY:
			the_first_monday_day = 6;
			break;
		case Calendar.THURSDAY:
			the_first_monday_day = 5;
			break;
		case Calendar.FRIDAY:
			the_first_monday_day = 4;
			break;
		case Calendar.SATURDAY:
			the_first_monday_day = 3;
			break;
		}
		return the_first_monday_day;
//		System.out.println(Integer.toString(the_first_day_of_week_in_month));
	}

}
