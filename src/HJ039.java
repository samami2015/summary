import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            String[] mask = str.split("\\.");
            String[] ip1 = br.readLine().split("\\.");
            String[] ip2 = br.readLine().split("\\.");
            int res = 0;
            for (int i = 0; i < 4; i++) {
                int a = Integer.parseInt(mask[i]);
                int b = Integer.parseInt(ip1[i]);
                int c = Integer.parseInt(ip2[i]);
                if (a < 0 || a > 255 || b < 0 || b > 255 || c < 0 || c > 255) {
                    res = 1;
                    break;
                }
                if ((b & a) != (a & c)) {
                    res = 2;
                }
            }
            System.out.println(res);
        }
    }
}
