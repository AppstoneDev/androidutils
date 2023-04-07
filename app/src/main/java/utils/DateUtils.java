package utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONException;

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

import in.appstone.androidutils.R;

public class DateUtils {

    public static final String TAG = DateUtils.class.getSimpleName();
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getDateAs_dd_MM_yyyy(String inputDate) {
        String formatedDate = "";

        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));

        try {
            Date date = inputFormat.parse(inputDate);
            formatedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }


    public static String getDateAs_dd_MMM_yyyy(String inputDate) {
        String formatedDate = "";

        DateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));

        try {
            Date date = inputFormat.parse(inputDate);
            formatedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }

    public static String getDateAsddMMMyyyy(String inputDate) {
        String formatedDate = "";

        DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));

        try {
            Date date = inputFormat.parse(inputDate);
            formatedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }

    public static String getDateAsMMMyyyy(String inputDate){
        String formatedDate = "";

        DateFormat outputFormat = new SimpleDateFormat("MMM yyyy", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));

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
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        DateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

        try {
            Date date = inputFormat.parse(inputTime);
            formatedTime = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedTime;
    }

    public static String getTimeAsHourMinute(String inputTime) {
        String formatedTime = "";

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        DateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

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

    public static int getDateInNumber() {
        int datevalue;
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd", Locale.getDefault());
        String dateval = dateFormatter.format(cal.getTime());

        datevalue = Integer.parseInt(dateval);

        return datevalue;
    }


    public static String getDateTimeInServerFormat() {
        String dateServerFormat = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        dateServerFormat = dateFormat.format(cal.getTime());

        return dateServerFormat;
    }

    public static String[] getDateMonthYearSepaerate(Date date) {
        String[] output = new String[3];

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        output[0] = dayFormat.format(date);
        output[1] = monthFormat.format(date);
        output[2] = yearFormat.format(date);


        return output;
    }


    public static String getDDFromDate(String inputDate) {
        String ddValue = "";

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        DateFormat outputFormat = new SimpleDateFormat("dd", Locale.getDefault());

        try {
            Date date = inputFormat.parse(inputDate);
            ddValue = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ddValue;
    }

    public static String getMMMFromDate(String inputDate) {
        String mmmValue = "";

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        DateFormat outputFormat = new SimpleDateFormat("MMM", Locale.getDefault());

        try {
            Date date = inputFormat.parse(inputDate);
            mmmValue = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mmmValue;
    }


    public static String getDateAs_yyyy_MM_dd(String inputDate) {
        String formatedDate = "";

        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

        try {
            Date date = inputFormat.parse(inputDate);
            formatedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }

    public static boolean checkDateIsPreviousForServerTimeStamp(String date) {
        boolean isPrevious = false;
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date toCheckDate = outputFormat.parse(date);
            Date currentDate = outputFormat.parse(outputFormat.format(Calendar.getInstance().getTime()));
            isPrevious = toCheckDate.before(currentDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isPrevious;
    }

    public static boolean checkDateIsEqualForServerTimeStamp(String date) {
        boolean isSameDate = false;
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date toCheckDate = outputFormat.parse(date);
            Date currentDate = outputFormat.parse(outputFormat.format(Calendar.getInstance().getTime()));
            isSameDate = currentDate.equals(toCheckDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isSameDate;
    }

    public static String getTimeDifference(Context context, String dateVal) {
        String words = "";
        try {
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            Date recDate = outputFormat.parse(dateVal);

            long diff = new Date().getTime() - recDate.getTime();

            double seconds = Math.abs(diff) / 1000;
            double minutes = seconds / 60;
            double hours = minutes / 60;
            double days = hours / 24;
            double years = days / 365;

            if (seconds < 60) {
                words = context.getString(R.string.time_ago_seconds);
                words = words.replace("%@", String.valueOf((int) seconds));
            } else if (seconds < 120) {
                words = context.getString(R.string.time_ago_minute);
            } else if (minutes < 60) {
                words = context.getString(R.string.time_ago_minutes);
                words = words.replace("%@", String.valueOf((int) minutes));
            } else if (minutes < 120) {
                words = context.getString(R.string.time_ago_hour);
            } else if (hours < 24) {
                words = context.getString(R.string.time_ago_hours);
                words = words.replace("%@", String.valueOf((int) hours));
            } else if (hours < 48) {
                words = context.getString(R.string.time_ago_day);
            } else if (days < 7) {
                words = context.getString(R.string.time_ago_days);
                words = words.replace("%@", String.valueOf((int) days));
            } else if (days < 14) {
                words = context.getString(R.string.time_ago_week);
            } else if (days >= 14 && days < 30) {
                words = context.getString(R.string.time_ago_weeks);
                words = words.replace("%@", String.valueOf((int) (days / 7)));
            } else if (days < 60) {
                words = context.getString(R.string.time_ago_month);
            } else if (days < 365) {
                words = context.getString(R.string.time_ago_months);
                words = words.replace("%@", String.valueOf((int) (days / 30)));
            } else if (years < 2) {
                words = context.getString(R.string.time_ago_year);
            } else {
                words = context.getString(R.string.time_ago_years);
                words = words.replace("%@", String.valueOf((int) years));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return words;
    }

    public static String getTimeDifferenceSingeDayCount(Context context, String dateVal) {
        String words = "";
        try {
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            DateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            Date recDate = outputFormat.parse(dateVal);

            long diff = new Date().getTime() - recDate.getTime();

            double seconds = Math.abs(diff) / 1000;
            double minutes = seconds / 60;
            double hours = minutes / 60;

            if (seconds < 60) {
                words = context.getString(R.string.time_ago_seconds);
                words = words.replace("%@", String.valueOf((int) seconds));
            } else if (seconds < 120) {
                words = context.getString(R.string.time_ago_minute);
            } else if (minutes < 60) {
                words = context.getString(R.string.time_ago_minutes);
                words = words.replace("%@", String.valueOf((int) minutes));
            } else if (minutes < 120) {
                words = context.getString(R.string.time_ago_hour);
            } else if (hours < 24) {
                words = context.getString(R.string.time_ago_hours);
                words = words.replace("%@", String.valueOf((int) hours));
            } else {
                String receivedDate = dateFormat.format(recDate);
                String receivedTime = timeFormat.format(recDate);
                words = receivedDate.concat(" ").concat(context.getString(R.string.time_at).concat(" ").concat(receivedTime));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    public static int getDaysDifferenceBetweenTwoDates(String startingDate, String endingDate) {
        int dayDiff = 0;

        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

            Date startDateVal = inputFormat.parse(startingDate);
            Date endDateVal = inputFormat.parse(endingDate);

            long difference = Math.abs(startDateVal.getTime() - endDateVal.getTime());
            dayDiff = (int) difference / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dayDiff;
    }

    public static int getDaysDifferenceBetweenTwoDates_DayWise(String startingDate, String endingDate) {
        int dayDiff = 0;

        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

            Date startDateVal = inputFormat.parse(startingDate);
            Date endDateVal = inputFormat.parse(endingDate);

            long difference = Math.abs(startDateVal.getTime() - endDateVal.getTime());
            int dayWiseValue = (int) difference / (24 * 60 * 60 * 1000);
            float reminderValue = difference % (24 * 60 * 60 * 1000);

            dayDiff = reminderValue > 5 ? dayWiseValue + 1 : dayWiseValue;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dayDiff;
    }

    public static boolean isFutureDateYYYYMMDD(String date) {
        boolean isAfter = false;

        try {
            DateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date recDate = outputDateFormat.parse(date);
            Date currentDate = outputDateFormat.parse(getDateTimeInServerFormat());

            if (recDate.after(currentDate)) {
                isAfter = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAfter;
    }

    public static boolean isCurrentDate(String date) {
        boolean isCurrentDate = false;
        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.SSS'Z'", Locale.getDefault());
            Date receivedDate = inputFormat.parse(date);

            Calendar receivedDateCal = Calendar.getInstance();
            receivedDateCal.setTime(receivedDate);

            Calendar currentDateCal = Calendar.getInstance();
            isCurrentDate = currentDateCal.get(Calendar.DAY_OF_YEAR) == receivedDateCal.get(Calendar.DAY_OF_YEAR) && currentDateCal.get(Calendar.YEAR) == receivedDateCal.get(Calendar.YEAR);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isCurrentDate;
    }

    public static String getStartDateTime(String date) {
        String startDate = "";
        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:01.SSS'Z'", Locale.getDefault());

            Date receivedDate = inputFormat.parse(date);
            startDate = outputFormat.format(receivedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return startDate;
    }

    public static String getEndDatTime(String date) {
        String endDate = "";
        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'23:59:59.SSS'Z'", Locale.getDefault());

            Date receivedDate = inputFormat.parse(date);
            endDate = outputFormat.format(receivedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return endDate;
    }

    public static String dateToUTCShortSqliteString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
                Locale.ENGLISH);
        TimeZone tz = TimeZone.getTimeZone("UTC");
        format.setTimeZone(tz);
        try {
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String timeAgoChat(Context context, Date date, Locale locale) {
        if (date == null) {
            return "";
        }

        String words = "";

        try {

            long millis = date.getTime();
            Date currentDate = Calendar.getInstance().getTime();
            long diff = currentDate.getTime() - millis;

            double seconds = Math.abs(diff) / 1000;
            double minutes = seconds / 60;
            double hours = minutes / 60;
            double days = hours / 24;
            double years = days / 365;


            @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String currentDayVal = format.format(currentDate);
            String previousDayVal = format.format(date);
            Date currentDay = format.parse(currentDayVal);
            Date previousDay = format.parse(previousDayVal);

            if (hours < 24) {
                if (previousDay != null && previousDay.before(currentDay)) {
                    words = context.getString(R.string.chat_yesterday);
                } else {
                    words = context.getString(R.string.chat_today);
                }
            } else if (hours > 24 && hours < 48) {
                words = context.getString(R.string.chat_yesterday);
            } else {
                words = getFormatDate7(context, date, locale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return words.trim();
    }

    public static String getFormatDate7(Context context, Date date, Locale locale) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("dd MMMM yyyy", locale).format(date.getTime());
    }

    public static Date getDateFromTimeMillis(Double date) {

        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c.setTimeInMillis(Math.round(date));

        return c.getTime();

    }

    public static boolean chatDayDifference(long previousTimeStamp, long currentTimeStamp) {
        boolean isPreviousDay = false;

        Date previousDateVal = getDateFromTimeMillis((double) previousTimeStamp);
        Date currentDateval = getDateFromTimeMillis((double) currentTimeStamp);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


        try {
            String beforeDate = format.format(previousDateVal);
            String todayDate = format.format(currentDateval);
            Date previousDate = format.parse(beforeDate);
            Date currentDate = format.parse(todayDate);


            if (previousDate != currentDate && previousDate != null && previousDate.before(currentDate)) {
                isPreviousDay = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isPreviousDay;
    }

    public static String get12HourFormat(Context context, Date date, Locale locale) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat desiredFormat;
        desiredFormat = new SimpleDateFormat("hh:mm aa", locale);

        return desiredFormat.format(date.getTime());
    }

    public static String get24HourFormat(Context context, Date date, Locale locale) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat desiredFormat;
        desiredFormat = new SimpleDateFormat("HH:mm", locale);

        return desiredFormat.format(date.getTime());
    }

    public static String getDateAsddMMMyyyy_Input_yyyyMMdd(String inputDate) {
        String formatedDate = "";

        DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));

        try {
            Date date = inputFormat.parse(inputDate);
            formatedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }

    public static int getDaysDifferenceBetweenTwoDates_Input_ddMMMyyyy(String startingDate, String endingDate) {
        int dayDiff = 0;

        try {
            DateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());

            Date startDateVal = inputFormat.parse(startingDate);
            Date endDateVal = inputFormat.parse(endingDate);

            long difference = Math.abs(startDateVal.getTime() - endDateVal.getTime());
            dayDiff = (int) difference / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dayDiff;
    }

    public static boolean checkIfDateBefore_ddMMMyyyy(String startingDate, String endingDate) {
        boolean isBefore = false;
        try {
            DateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            Date startDateVal = inputFormat.parse(startingDate);
            Date endDateVal = inputFormat.parse(endingDate);

            if (endDateVal.before(startDateVal)) {
                isBefore = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isBefore;
    }

    public static String getYearsFromDate(String toConvertDate) {
        String age = "";
        try {
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            Date recDate = outputFormat.parse(toConvertDate);

            long diff = new Date().getTime() - recDate.getTime();

            double seconds = Math.abs(diff) / 1000;
            double minutes = seconds / 60;
            double hours = minutes / 60;
            double days = hours / 24;
            double years = days / 365;
            int yearValue = (int) years;

            age = String.valueOf(yearValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return age;
    }

    public static Date getAsDateFromString(String date) {
        Date dateVal = new Date();
        try {
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            dateVal = outputFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateVal;
    }

    public static String getAsStringFromDate(Date date) {
        String dateVal = "";
        try {
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            dateVal = outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateVal;
    }

    public static String getAsStringFromDate_DDMMMYY_HHMMAA(Date date) {
        String dateVal = "";
        try {
            DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm aa", Locale.getDefault());
            dateVal = outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateVal;
    }

    public static String getAsStringFromString_DDMMMYYYY_HHMMAA(String date) {
        String dateVal = "";
        try {
            DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm aa", Locale.getDefault());
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());

            Date convertedDate = inputFormat.parse(date);
            dateVal = outputFormat.format(convertedDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateVal;
    }
}
