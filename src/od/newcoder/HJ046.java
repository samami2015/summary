package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int num = Integer.parseInt(s[1]);
            int count = 0;
            for (int i = 0; i < s[0].length(); i++) {
                char c = s[0].charAt(i);
                if (c < 128) {
                    count++;
                } else {
                    count += 2;
                }
                if (count == num) {
                    System.out.println(s[0].substring(0, i + 1));
                    break;
                } else if (count > num) {
                    System.out.println(s[0].substring(0, i));
                    break;
                }
            }
        }
    }
}
