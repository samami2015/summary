package od.leetcode;

public class LC0551 {
    public static void main(String[] args) {
        LC0551 solution = new LC0551();
        String s = "PPALLP";
        boolean ans = solution.checkRecord(s);
        System.out.println(ans);
    }
    public boolean checkRecord(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && s.indexOf("LLL")<0;
    }
}
