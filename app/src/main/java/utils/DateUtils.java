package utils;

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

    public static String getTimeNew(String inputTime) {
        String formatedTime = "";

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        inputFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        DateFormat outputFormat = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());

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

    public static String getStartDateTime(String date) {
        String startDate = "";
        try {
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:01.SSS'Z'",  Locale.getDefault());

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
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'23:59:59.SSS'Z'",  Locale.getDefault());

            Date receivedDate = inputFormat.parse(date);
            endDate = outputFormat.format(receivedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return endDate;
    }
}
