package summary.twostar;

import java.util.*;

/**
 * 【We Are A Team】
 * 总共有n个人在机房，每个人有一个标号（1 <= 标号 <=n），他们分成了多个团队，需要你根据收到的m条消息判定指定的两个人是否在一个团队中，具体的：
 * 1、消息构成为：a b c，整数a、b分别代表了两个人的标号，整数c代表指令。
 * 2、c==0代表a和b在一个团队内。
 * 3、c==1代表需要判定a和b的关系，如果a和b是一个团队，输出一行“we are a team”，如果不是，输出一行“we are not a team”。
 * 4、c为其它值，或当前行a或b超出1~n的范围，输出“da pian zi”。
 * 输入描述：
 * 1、第一行包含两个整数n, m(1 <= n, m <= 100000)，分别表示有n个人和m条消息。
 * 2、随后的m行，每行一条消息，消息格式为:a b c (1 <= a, b <= n, 0 <= c <= 1)。
 * 输出描述：
 * 1、c==1时，根据a和b是否在一个团队中输出一行字符串，在一个团队中输出“we are a team”，不在一个团队中输出“we are not a team”。
 * 2、c为其他值，或当前行a或b的标号小于1或者大于n时，输出字符串“da pian zi”。
 * 3、如果第一行n和m的值超出约定的范围时，输出字符串"NULL"。
 * 示例1：
 * 输入
 * 5 6
 * 1 2 0
 * 1 2 1
 * 1 5 0
 * 2 3 1
 * 2 5 1
 * 1 3 2
 * 输出
 * we are a team
 * we are not a team
 * we are a team
 * da pian zi
 */
public class We_Are_A_Team {
    public static void main(String[] args) {
        HashMap<Integer, String> person = new HashMap<Integer, String>();
        HashMap<String, List<Integer>> group = new HashMap<String, List<Integer>>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        if (M < 1 || M > 100000 || N < 1 || N > 100000) {
            System.out.println("NULL");
        }
        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int msg = in.nextInt();

            if (a < 1 || a > N || b < 1 || b > N) {
                System.out.println("da pian zi");
                continue;
            }

            if (!person.containsKey(a)) {
                String uuid = UUID.randomUUID().toString();
                person.put(a, uuid);
                List<Integer> list = new ArrayList<Integer>();
                list.add(a);
                group.put(uuid, list);
            }
            if (!person.containsKey(b)) {
                String uuid = UUID.randomUUID().toString();
                person.put(b, uuid);
                List<Integer> list = new ArrayList<>();
                list.add(b);
                group.put(uuid, list);
            }
            if (msg == 0) {
                String uuida = person.get(a);
                String uuidb = person.get(b);

                if (uuida.equals(uuidb)) {
                    continue;
                }

                List<Integer> groupa = group.get(uuida);
                List<Integer> groupb = group.get(uuidb);
                String uuid = UUID.randomUUID().toString();
                groupa.addAll(groupb);

                for (Integer p : groupa) {
                    person.put(p, uuid);
                }
                group.remove(uuida);
                group.remove(uuidb);
                group.put(uuid, groupa);
            } else if (msg == 1) {
                String val1 = person.get(a);
                String val2 = person.get(b);
                if (val1 != null && val2 != null && val1.equals(val2)) {
                    System.out.println("We are a team");
                } else {
                    System.out.println("We are not a team");
                }
            } else {
                System.out.println("da pian zi");
            }
        }
    }
}