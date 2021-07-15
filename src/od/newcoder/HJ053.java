package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(getResult(str));
        }
    }

    private static int getResult(String str) {
        int i = Integer.parseInt(str);
        if (i <= 2) {
            return -1;
        } else if (i % 2 == 1) {
            return 2;
        } else {
            if (i % 4 == 0) {
                return 3;
            } else {
                return 4;
            }
        }
    }
}
