package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            int window = Integer.parseInt(br.readLine());
            int num = 0;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (i == 'G' || i == 'C') {
                    num++;
                }
            }
            int max = num;
            int left = 0;
            for (int i = 1; i < input.length() - window; i++) {
                char pre = input.charAt(i - 1);
                char nex = input.charAt(i + window - 1);
                if (pre == 'G' || pre == 'C') num--;
                if (nex == 'G' || nex == 'C') num++;
                if (num > max) {
                    max = num;
                    left = i;
                }
            }
            System.out.println(input.substring(left, left + window));
        }
    }
}
