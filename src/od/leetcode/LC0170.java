package od.leetcode;

public class LC0170 {
    public static void main(String[] args) {
        leetcode.TwoSum twoSum = new leetcode.TwoSum();
        twoSum.add(1);   // [] --> [1]
        twoSum.add(3);   // [1] --> [1,3]
        twoSum.add(5);   // [1,3] --> [1,3,5]
        twoSum.find(4);  // 1 + 3 = 4，返回 true
        twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false

    }
}

