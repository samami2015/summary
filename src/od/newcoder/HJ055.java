package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int count = 0;
            int num = Integer.parseInt(str);
            for (int i = 6; i <= num; i++) {
                if (i % 7 == 0 || isContain7(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isContain7(int num) {
        int count = 0;
        int temp = 0;
        while (num != 0) {
            temp = num % 10;
            if (temp == 7) {
                count++;
            }
            num /= 10;
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
