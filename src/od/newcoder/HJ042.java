package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            Integer line = Integer.parseInt(str);
            System.out.println(parse(line));
        }
    }

    private static String parse(int num) {
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
                , "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        if (num >= 0 && num < 20) {
            return numStr[num];
        } else if (num >= 20 && num < 100) {
            int a = num % 10;
            if (num < 30) {
                return a != 0 ? "twenty " + parse(a) : "twenty";
            } else if (num < 40) {
                return a != 0 ? "thirty " + parse(a) : "thirty";
            } else if (num < 50) {
                return a != 0 ? "forty " + parse(a) : "forty";
            } else if (num < 60) {
                return a != 0 ? "fifty " + parse(a) : "fifty";
            } else if (num < 70) {
                return a != 0 ? "sixty " + parse(a) : "sixty";
            } else if (num < 80) {
                return a != 0 ? "seventy " + parse(a) : "seventy";
            } else if (num < 90) {
                return a != 0 ? "eighty " + parse(a) : "eighty";
            } else if (num < 100) {
                return a != 0 ? "ninety " + parse(a) : "ninety";
            }
        } else if (num >= 100 && num < 1000) {
            int x = num / 100;
            int y = num % 100;
            if (y != 0) {
                return parse(x) + " hundred" + " and " + parse(y);
            } else {
                return parse(x) + " hundred";
            }
        } else if (num >= 1000 && num < 1000000) {
            int x = num / 1000;
            int y = num % 1000;
            if (y != 0) {
                return parse(x) + " thousand " + parse(y);
            } else {
                return parse(x) + " thousand";
            }
        } else if (num >= 1000000 && num < 100000000) {
            int x = num / 1000000;
            int y = num % 1000000;
            if (y != 0) {
                return parse(x) + " million " + parse(y);
            } else {
                return parse(x) + " million";
            }
        }
        return "error";
    }
}
