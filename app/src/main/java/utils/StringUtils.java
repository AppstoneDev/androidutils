package utils;

public class StringUtils {


    public static boolean checkIfStringIsValid(String value) {
        boolean isValid = false;

        if (value != null && !value.isEmpty() && !value.equals("null")) {
            isValid = true;
        }

        return isValid;
    }
}
