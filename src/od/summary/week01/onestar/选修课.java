package od.summary.week01.onestar;

import java.util.*;

/**
 * 【选修课】
 * 现有两门选修课，每门选修课都有一部分学生选修，每个学生都有选修课的成绩，需要你找出同时选修了两门选修课的学生，先按照班级进行划分，班级
 * 编号小的先输出，每个班级按照两门选修课成绩和的降序排序，成绩相同时按照学生的学号升序排序。
 * <p>
 * 输入描述：
 * 第一行为第一门选修课学生的成绩，第二行为第二门选修课学生的成绩，每行数据中学生之间以英文分号分隔，每个学生的学号和成绩以英文逗号分隔，学生学号
 * 的格式为8位数字(2位院系编号+入学年份后2位+院系内部1位专业编号+所在班级3位学号)，学生成绩的取值范围为[0,100]之间的整数，两门选修课选修学生数的取
 * 值范围为[1-2000]之间的整数。
 * <p>
 * 输出描述：
 * 同时选修了两门选修课的学生的学号，如果没有同时选修两门选修课的学生输出NULL，否则，先按照班级划分，班级编号小的先输出，每个班级先输出班级编号(
 * 学号前五位)，然后另起一行输出这个班级同时选修两门选修课的学生学号，学号按照要求排序(按照两门选修课成绩和的降序，成绩和相同时按照学号升序)，学生
 * 之间以英文分号分隔。
 * 示例1：
 * 输入
 * 01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
 * 01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
 * <p>
 * 输出
 * 01202
 * 01202008;01202021
 * 01203
 * 01203088
 */
public class 选修课 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] studentsA = in.nextLine().split(";");
            String[] studentsB = in.nextLine().split(";");
            HashMap<String, Integer> mapA = new HashMap<>();
            HashMap<String, Integer> mapB = new HashMap<>();
            TreeMap<String, ArrayList<String>> resMap = new TreeMap<>();
            for (String student : studentsA) {
                String[] info = student.split(",");
                String id = info[0];
                Integer score = Integer.parseInt(info[1]);
                mapA.put(id, score);
            }
            for (String student : studentsB) {
                String[] info = student.split(",");
                String id = info[0];
                String classid = id.substring(0, 5);
                Integer score = Integer.parseInt(info[1]);
                mapB.put(id, score);
                if (mapA.containsKey(id)) {
                    resMap.putIfAbsent(classid, new ArrayList<>());
                    resMap.get(classid).add(id);
                }
            }
            if (resMap.size() == 0) {
                System.out.println("NULL");
                continue;
            }
            for (Map.Entry<String, ArrayList<String>> entry : resMap.entrySet()) {
                System.out.println(entry.getKey());
                StringBuilder temp = new StringBuilder();
                ArrayList<String> list = entry.getValue();
                Collections.sort(list, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int sum1 = mapA.get(o1) + mapB.get(o1);
                        int sum2 = mapA.get(o2) + mapB.get(o2);
                        if (sum1 == sum2) {
                            return o1.compareTo(o2);
                        } else {
                            return sum2 - sum1;
                        }
                    }
                });
                for (int i = 0; i < list.size(); i++) {
                    if(i!=0)temp.append(";");
                    temp.append(list.get(i));
                }
                System.out.println(temp);
            }
        }
    }
}
