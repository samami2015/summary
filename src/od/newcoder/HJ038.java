package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            double height = Integer.parseInt(str);
            System.out.println(get(height));
            System.out.println(height(height));
        }
    }

    private static double height(double h) {
        for (int i = 0; i < 5; i++) {
            h = h / 2;
        }
        return h;
    }

    private static double get(double h) {
        return h + h + h / 2 + h / 4 + h / 8;
    }
}
