package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        while ((str1 = br.readLine()) != null) {
            String str2 = br.readLine();
            if (str1.length() < str2.length()) {
                System.out.println(res(str1, str2));
            } else {
                System.out.println(res(str2, str1));
            }

        }
    }

    public static String res(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[][] ins = new int[ch1.length + 1][ch2.length + 1];
        int max = 0;
        int start = 0;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    ins[i + 1][j + 1] = ins[i][j] + 1;
                    if (ins[i + 1][j + 1] > max) {
                        max = ins[i + 1][j + 1];
                        start = i - max;
                    }
                }
            }
        }
        return s1.substring(start + 1, start + max + 1);
    }
}
