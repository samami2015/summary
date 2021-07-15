package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            String s = str[0] + str[1];
            StringBuilder br1 = new StringBuilder();
            StringBuilder br2 = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    br1.append(s.charAt(i));
                } else {
                    br2.append(s.charAt(i));
                }
            }
            char[] ch1 = br1.toString().toCharArray();
            char[] ch2 = br2.toString().toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            char[] ch = new char[ch1.length + ch2.length];
            for (int i = 0; i < ch.length; i++) {
                if (i % 2 == 0) {
                    ch[i] = ch1[i / 2];
                } else {
                    ch[i] = ch2[i / 2];
                }
            }
            char[] password = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] dictionary = {'0', '8', '4', 'C', '2', 'A', '6', 'E', '1', '9', '5', 'D', '3', 'B', '7', 'F', '5', 'D', '3', 'B', '7', 'F'};
            for (int i = 0; i < ch.length; i++) {
                if ((ch[i] >= '0' && ch[i] <= '9') || (ch[i] >= 'a' && ch[i] <= 'f') || (ch[i] >= 'A' && ch[i] <= 'F')) {
                    ch[i] = dictionary[String.valueOf(password).indexOf(ch[i])];
                }
            }
            System.out.println(ch);
        }
    }
}
