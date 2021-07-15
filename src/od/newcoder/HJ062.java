package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            Integer num = Integer.parseInt(input);
            String s = Integer.toBinaryString(num);
            int x = 0;
            for (char c : s.toCharArray()) {
                if(c=='1'){
                    x++;
                }
            }
            System.out.println(x);
        }
    }
}
