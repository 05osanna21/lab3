package utils;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateHelper {


    public static DateTime getDateAsDaysFromNow(int fromNow) {
        DateTime dateTime = new DateTime();
        LocalDate localDate = dateTime.toLocalDate();
        String localDate1 = localDate.minusDays(fromNow).toString();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime jodatime = dateTimeFormatter.parseDateTime(localDate1);
        return jodatime;
    }

    public static String getDateInPropertlyFormat(DateTime dayFromNow) {
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd/mm/yyyy");
        return dtfOut.print(dayFromNow);
    }

    public static int getDayNumbeFromDate(DateTime jodatime) {
        int dayOfMonth = jodatime.getDayOfMonth();
        return dayOfMonth;
    }

}
