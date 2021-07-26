package summary.twostar;

import java.util.*;

/**
 * 【支持优先级的队列】
 * 实现一个支持优先级的队列，高优先级先出队列；同优先级时先进先出。
 * 如果两个输入数据和优先级都相同，则后一个数据不入队列被丢弃。
 * 队列存储的数据内容是一个整数。
 * 输入描述：
 * 一组待存入队列的数据（包含内容和优先级）
 * 输出描述：
 * 队列的数据内容（优先级信息输出时不再体现）
 * 备注：
 * 不用考虑输入数据不合法的情况，测试数据不超过100个
 * 示例1：
 * 输入
 * (10,1),(20,1),(30,2),(40,3)
 * 输出
 * 40,30,10,20
 */
public class 支持优先级的队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if (Objects.nonNull(input)) {
            System.out.println(getResult(input));
        }
    }

    private static String getResult(String input) {
        if (!input.endsWith(",")) {
            input += ",";
        }
        String[] split = input.split("\\),");
        if (split.length > 0) {
            Map<String, List<String>> temp = new HashMap<>(split.length);
            for (String data : split) {
                String[] dataOne = data.replace("(", "").split(",");
                if (temp.containsKey(dataOne[1])) {
                    List<String> list = temp.get(dataOne[1]);
                    if (list.size() > 0) {
                        if (!list.contains(dataOne[0])) {
                            list.add(dataOne[0]);
                        }
                    }
                } else {
                    List oneList = new ArrayList();
                    oneList.add(dataOne[0]);
                    temp.put(dataOne[1], oneList);
                }
            }
            StringBuilder sb = new StringBuilder();
            List<String> reIndex = new ArrayList<>();
            temp.keySet().forEach(item -> {
                boolean flag = true;
                for (int i = 0; i < reIndex.size(); i++) {
                    if (Integer.parseInt(reIndex.get(i)) < Integer.parseInt(item)) {
                        reIndex.add(i, item);
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    reIndex.add(item);
                }
            });

            for(String ret:reIndex){
                sb.append(String.join(",",temp.get(ret)));
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }
        return "";
    }
}
