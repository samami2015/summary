package od.newcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ031 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && line.length() > 0) {
            char[] array = line.trim().toCharArray();
            StringBuffer sb = new StringBuffer();
            boolean flag = false;
            int mark = -1;
            for (int i = array.length - 1; i >= 0; i--) {
                if ((array[i] >= 'A' && array[i] <= 'Z') || (array[i] >= 'a' && array[i] <= 'z')) {
                    if (mark == -1) {
                        mark = i;
                        flag = true;
                    }
                } else if (flag) {
                    sb.append(array, i + 1, mark - i).append(' ');
                    mark = -1;
                    flag = false;

                }
            }
            if (flag) {
                sb.append(array, 0, mark + 1);
                System.out.println(sb.toString());
            } else {
                System.out.println(sb.substring(0, sb.length() - 1));
            }
        }
    }
}
