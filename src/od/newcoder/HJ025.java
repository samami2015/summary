package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = br.readLine()) != null) {
            String[] I = input.split(" ");
            String[] temp = br.readLine().split(" ");
            long[] R = new long[Integer.parseInt(temp[0])];
            for (int i = 0; i < R.length; i++) {
                R[i] = Long.parseLong(temp[i + 1]);
            }
            Arrays.sort(R);
            StringBuilder res = new StringBuilder();
            int count = 0;
            for (int i = 0; i < R.length; i++) {
                if (i > 0 && R[i] == R[i - 1]) {
                    continue;
                }
                String pattern = R[i] + "";
                int num = 0;
                StringBuilder index = new StringBuilder();
                for (int j = 1; j < I.length; j++) {
                    if (I[j].indexOf(pattern) != -1) {
                        num++;
                        index.append(" ").append(j - 1).append(" ").append(I[j]);
                    }
                }
                if (num > 0) {
                    res.append(" ").append(R[i]).append(" ").append(num).append(index);
                    count += num * 2 + 2;
                }
            }
            System.out.println(count + res.toString());
        }
    }
}
