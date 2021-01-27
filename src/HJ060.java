import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input.trim());
            for (int m = num / 2; num >= 2; m--) {
                if (isZhiShu(m) && isZhiShu(num - m)) {
                    System.out.println(m);
                    System.out.println(num - m);
                    break;
                }
            }
        }
    }

    private static boolean isZhiShu(int num) {
        for (int n = 2; n < num; n++) {
            if (num % n == 0) {
                return false;
            }
        }
        return true;
    }
}
