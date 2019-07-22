package toint;

/**
 * Implement method
 * static int toInt(String str)
 *
 */
public class ToInt {
    public static void main(String[] args) {
        System.out.println(toInt("-120313"));
    }

    static int toInt(String str) {

        int result = 0;

        int multiplier = 1;

        int stopIndex = 0;

        if (str.charAt(0) == '-') {
            stopIndex = 1;
            multiplier = -1;
        }

        for (int i = str.length() - 1; i >= stopIndex; i--) {
            result += (str.charAt(i) - '0') * multiplier;
            multiplier *= 10;
        }

        return result;

    }
}
