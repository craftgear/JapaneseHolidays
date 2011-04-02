import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;

public class JapaneseHolidaysTest extends TestCase{
	public JapaneseHolidays cpd;
	
	public JapaneseHolidaysTest(String name){
		super(name);
	}
	
	public void setUp(){
		cpd = new JapaneseHolidays();
	}
	
	public void tearDown(){
		cpd = null;
	}
	public void testIsFridayByDay(){
		cpd = new JapaneseHolidays(2011, 3, 1);
		assertEquals(true, cpd.isFriday(25));
	}
	
	public void testIsSaturdayByDay(){
		cpd = new JapaneseHolidays(2011, 3, 1);
		assertEquals(true, cpd.isSaturday(26));
	}
	
	public void testIsSundayByDay(){
		cpd = new JapaneseHolidays(2011, 3, 1);
		assertEquals(true, cpd.isSunday(27));
	}
	
	public void testIsHolidayByDay(){
		cpd = new JapaneseHolidays(2011, 3, 1);
		assertEquals(true, cpd.isHoliday(21));
	}
	
	public void testIsFriday(){
		assertEquals(true, cpd.isFriday(25, 3, 2011));
	}
	
	public void testIsSaturday(){
		assertEquals(true, cpd.isSaturday(26, 3, 2011));
	}
	
	public void testIsSunday(){
		assertEquals(true, cpd.isSunday(27, 3, 2011));
	}
	
	public void testIsHoliday(){
		assertEquals(true, cpd.isHoliday(11, 2, 2011));
	}
	
	public void testGetHolidaysOnJanuary(){
		ArrayList<Integer> holidays = cpd.getHolidays(1);
		Integer[] temp = new Integer[] {1,2,3,10};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnFebruary(){
		ArrayList<Integer> holidays = cpd.getHolidays(2);
		Integer[] temp = new Integer[] {11};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnMarch(){
		ArrayList<Integer> holidays = cpd.getHolidays(3);
		Integer[] temp = new Integer[] {21};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnApril(){
		ArrayList<Integer> holidays = cpd.getHolidays(4);
		Integer[] temp = new Integer[] {29};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnMay(){
		ArrayList<Integer> holidays = cpd.getHolidays(5);
		Integer[] temp = new Integer[] {3,4,5};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnJune(){
		ArrayList<Integer> holidays = cpd.getHolidays(6);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnJuly(){
		ArrayList<Integer> holidays = cpd.getHolidays(7);
		Integer[] temp = new Integer[] {18};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnAugust(){
		ArrayList<Integer> holidays = cpd.getHolidays(8);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnSeptember(){
		ArrayList<Integer> holidays = cpd.getHolidays(9);
		Integer[] temp = new Integer[] {19,23};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnOctober(){
		ArrayList<Integer> holidays = cpd.getHolidays(10);
		Integer[] temp = new Integer[] {10};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnNovember(){
		ArrayList<Integer> holidays = cpd.getHolidays(11);
		Integer[] temp = new Integer[] {3,23};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
	public void testGetHolidaysOnDecember(){
		ArrayList<Integer> holidays = cpd.getHolidays(12);
		Integer[] temp = new Integer[] {23,29,30,31};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(temp));
		assertEquals(expected, holidays);
	}
	
}
