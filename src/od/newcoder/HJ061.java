package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            String[] s = input.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            System.out.println(getSum(m, n));
        }
    }

    private static int getSum(int m, int n) {
        if (n == 1 || m == 0) return 1;
        else if (n > m) return getSum(m, m);
        else return getSum(m, n - 1) + getSum(m - n, n);
    }
}
