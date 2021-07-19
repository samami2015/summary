package summary.onestar;

import java.util.*;

/**
 * 【模拟消息队列】
 * 让我们来模拟一个消息队列的运作，有一个发布者和若干消费者，发布者会在给定的时刻向消息队列发送消息，若此时消息队列有消费者订阅，这
 * 个消息会被发送到订阅的消费者中优先级最高（输入中消费者按优先级升序排列）的一个；若此时没有订阅的消费者，该消息被消息队列丢弃。消费者则会在给定的
 * 时刻订阅消息队列或取消订阅。
 * 当消息发送和订阅发生在同一时刻时，先处理订阅操作，即同一时刻订阅的消费者成为消息发送的候选。
 * 当消息发送和取消订阅发生在同一时刻时，先处理取消订阅操作，即消息不会被发送到同一时刻取消订阅的消费者。
 * <p>
 * 输入描述：
 * 输入为两行。
 * 第一行为2N个正整数，代表发布者发送的N个消息的时刻和内容（为方便解析，消息内容也用正整数表示）。第一个数字是第一个消息的发送时刻，第二个数字是
 * 第一个消息的内容，以此类推。用例保证发送时刻不会重复，但注意消息并没有按照发送时刻排列。
 * 第二行为2M个正整数，代表M个消费者订阅和取消订阅的时刻。第一个数字是第一个消费者订阅的时刻，第二个数字是第一个消费者取消订阅的时刻，以此类推。
 * 用例保证每个消费者的取消订阅时刻大于订阅时刻，消费者按优先级升序排列。
 * 两行的数字都由空格分隔。N不超过100，M不超过10，每行的长度不超过1000字符。
 * <p>
 * 输出描述：
 * 输出为M行，依次为M个消费者收到的消息内容，消息内容按收到的顺序排列，且由空格分隔；若某个消费者没有收到任何消息，则对应的行输出-1。
 * <p>
 * 示例1：
 * 输入
 * 2 22 1 11 4 44 5 55 3 33
 * 1 7 2 3
 * 输出
 * 11 33 44 55
 * 22
 */
public class 模拟消息队列 {
    static class DinTime {
        int startTime;
        int endTime;

        public DinTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String firStr = scanner.nextLine();
            String[] firSpl = firStr.split(" ");
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < firSpl.length; i += 2) {
                map.put(Integer.parseInt(firSpl[i]), Integer.parseInt(firSpl[i + 1]));
            }
            List<Integer> keyList = new ArrayList<Integer>();
            for (Integer key : map.keySet()) {
                keyList.add(key);
            }
            Collections.sort(keyList);

            String secStr = scanner.nextLine();
            String[] secSpl = secStr.split(" ");
            List<DinTime> list = new ArrayList<>();

            for (int i = 0; i < secSpl.length; i += 2) {
                DinTime dinTime = new DinTime(Integer.parseInt(secSpl[i]), Integer.parseInt(secSpl[i + 1]));
                list.add(dinTime);
            }

            String[] result = new String[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = "";
            }

            for (int i = 0; i < keyList.size(); i++) {
                int key = keyList.get(i);
                for (int j = list.size() - 1; j >= 0; j--) {
                    DinTime dinTime = list.get(j);
                    if (dinTime.startTime <= key && dinTime.endTime > key) {
                        result[j] = result[j] + map.get(key) + " ";
                        break;
                    }
                }
            }

            for (int i = 0; i < result.length; i++) {
                if ("".equals(result[i])) {
                    System.out.println("-1");
                } else {
                    System.out.println(result[i]);
                }
            }
        }
    }
}
