package od.leetcode;

public class LC0344 {
    public static void main(String[] args) {
        LC0344 solution = new LC0344();
        char[] s = {'h','e','l','l','o'};
        solution.reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
