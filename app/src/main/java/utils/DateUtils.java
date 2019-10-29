package utils;

import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

    public static final String TAG = DateUtils.class.getSimpleName();
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getDateAs_dd_MM_yyyy(String inputDate) {
        String formatedDate = "";

        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

        try {
            Date date = inputFormat.parse(inputDate);
            formatedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }

    public static String getTimeNew(String inputTime) {
        String formatedTime = "";

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        DateFormat outputFormat = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());

        try {
            Date date = inputFormat.parse(inputTime);
            formatedTime = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedTime;
    }

    public static String getDateUTC() {
        String formatedTime = "";


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar cal = Calendar.getInstance();
        Date todate1 = cal.getTime();
        String fromDate = dateFormat.format(todate1);

        return formatedTime;
    }

    public static Date getUTCdatetimeAsDate() {
        return stringDateToDate(getUTCdatetimeAsString());
    }

    public static String getUTCdatetimeAsString() {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime = sdf.format(new Date());

        return utcTime;
    }

    public static Date stringDateToDate(String StrDate) {
        Date dateToReturn = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());

        try {
            dateToReturn = (Date) dateFormat.parse(StrDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateToReturn;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getDate(String inputString) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.US);
        LocalDate date = LocalDate.parse(inputString, inputFormatter);
        String formattedDate = outputFormatter.format(date);
        System.out.println(formattedDate);
        return formattedDate;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getTime(String inputString) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        DateTimeFormatter outputFormatterTime = DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.US);
        LocalDateTime time = LocalDateTime.parse(inputString, inputFormatter);
        String formattedTime = outputFormatterTime.format(time);
        System.out.println(formattedTime);
        return formattedTime;


    }

    public static int getYearInNumber() {
        int yearvalue;
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy", Locale.getDefault());
        String yearval = yearFormatter.format(cal.getTime());

        yearvalue = Integer.parseInt(yearval);

        return yearvalue;
    }

    public static int getMonthInNumber() {
        int monthvalue;
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat monthFormatter = new SimpleDateFormat("MM", Locale.getDefault());
        String monthval = monthFormatter.format(cal.getTime());

        monthvalue = Integer.parseInt(monthval);

        return monthvalue;
    }

    public static int getDateInNumber(){
        int datevalue;
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd", Locale.getDefault());
        String dateval = dateFormatter.format(cal.getTime());

        datevalue = Integer.parseInt(dateval);

        return datevalue;
    }

}
