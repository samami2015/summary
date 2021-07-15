package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (input.indexOf(c) == input.lastIndexOf(c)) {
                    System.out.println(c);
                    break;
                }
                if (i == input.length() - 1) {
                    System.out.println(-1);
                }
            }
        }
    }
}
