package A1_Basics;

import org.junit.Test;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;


public class date_time_calendar {
    public static void main(String[] args) {
        String ret = getDay("15", "05", "2015");

    }


    public static String getDay(String day, String month, String year) {
        String ret = "";
        Calendar cal = new GregorianCalendar(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        int dayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("indexDay = " + dayOfMonth);

        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        String dayOfMonthStr = symbols.getWeekdays()[dayOfMonth];

        return dayOfMonthStr;

    }

    @Test
    public void getDayTest(){
        assertEquals("SATURDAY", getDay("4", "5", "2018")); // got Monday
        assertEquals("SATURDAY", getDay("5", "5", "2018")); // got Monday
        assertEquals("WEDNESDAY", getDay("9", "8", "2017"));

    }
}

