package od.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1160 {
    public static void main(String[] args) {
        LC1160 solution = new LC1160();
//        String[] words = {"cat","bt","hat","tree"};
//        String chars = "atach";
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        int ans = solution.countCharacters(words, chars);
        System.out.println(ans);
    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsCnt = new HashMap<>();
        int length = chars.length();
        //存储 chars 中每个字母的数量
        for (int i = 0; i < length; ++i) {
            char c = chars.charAt(i);
            charsCnt.put(c, charsCnt.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordCnt = new HashMap<>();
            int wordLength = word.length();
            //存储 word 中每个字母的数量
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
            }
            boolean isAns = true;
            //将这两个哈希表的键值对逐一进行比较即可
            //对于一个单词 word，只要其中的每个字母的数量都不大于 chars 中对应的字母的数量
            for (int i = 0; i < wordLength; ++i) {
                char c = word.charAt(i);
                if (charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                ans += word.length();
            }
        }

        return ans;
    }
}
