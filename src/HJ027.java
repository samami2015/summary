import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HJ027 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = bufferedReader.readLine()) != null) {
            String[] arr = input.trim().split(" ");
            Integer n = Integer.parseInt(arr[0]);
            String target = arr[arr.length - 2];
            Integer num = Integer.parseInt(arr[arr.length - 1]);
            String[] dic = new String[n];
            for (int i = 1; i <= n; i++) {
                dic[i - 1] = arr[i];
            }
            int count = 0;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < dic.length; i++) {
                if (dic[i].length() != target.length() || dic[i].equals(target)) {
                    continue;
                }
                char[] chars = dic[i].toCharArray();
                char[] targetArr = target.toCharArray();
                int tmp = 0;
                for (int j = 0; j < chars.length; j++) {
                    for (int k = 0; k < target.length(); k++) {
                        if (chars[j] == targetArr[k]) {
                            targetArr[k] = '0';
                            tmp++;
                            break;
                        }
                    }
                }
                if (tmp == targetArr.length) {
                    count++;
                    list.add(dic[i]);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            if (list.size() >= num) {
                System.out.println(list.get(num - 1));
            }
        }

    }
}
