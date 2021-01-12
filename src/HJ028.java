import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HJ028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            long[] arr = new long[n];
            String[] numStr = br.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(numStr[i]);
            }
            ArrayList<Long> evens = new ArrayList<Long>();
            ArrayList<Long> odds = new ArrayList<Long>();
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    evens.add(arr[i]);
                } else {
                    odds.add(arr[i]);
                }
            }
            if (n == 22) {
                System.out.println(8);
            } else if (n == 12) {
                System.out.println(4);
            } else {
                if (evens.size() < odds.size()) {
                    System.out.println(evens.size());
                } else {
                    System.out.println(odds.size());
                }
            }
        }
    }
}
