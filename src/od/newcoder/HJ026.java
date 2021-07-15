package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            char[] arr = input.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                char c = (char) ('A' + i);
                for (int j = 0, length = input.length(); j < length; j++) {
                    if (c == arr[j] || c == arr[j] - 'a' + 'A') {
                        builder.append(arr[j]);
                    }
                }
            }
            for (int i = 0, length = input.length(); i < length; i++) {
                if (!((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z'))) {
                    builder.insert(i, arr[i]);
                }
            }
            System.out.println(builder.toString());
        }
    }
}
