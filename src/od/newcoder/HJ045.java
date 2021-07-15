package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ045 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                char[] c = s.toCharArray();
                int[] count = new int[150];
                for (int j = 0; j < c.length; j++) {
                    count[c[j]]++;
                }

                Arrays.sort(count);
                int a = 26;
                int sum = 0;
                for (int k = count.length - 1; k >= 0; k--) {
                    if (count[k] == 0) {
                        break;
                    }
                    sum += count[k] * (a--);
                }
                System.out.println(sum);
            }
        }
    }
}
