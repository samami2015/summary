package summary.onestar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【按索引范围翻转文章片段】
 * 输入一个英文文章片段，翻转指定区间的单词顺序，标点符号和普通字母一样处理。例如输入字符串"I am a developer. "，区间[0,3]，
 * 则输出"developer. a am I"。
 * String reverseWords(String s, int start, int end)
 * <p>
 * 输入描述：
 * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，第二个参数为翻转起始单词下标(下标从0开始)，第三个参数为结束单词下标。
 * 输出描述：
 * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出
 * <p>
 * 示例1：
 * 输入
 * I am a developer.
 * 1
 * 2
 * 输出
 * I a am developer.
 */
public class 按索引范围翻转文章片段 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String content = input.nextLine();
            if (content.isEmpty()) {
                continue;
            }
            if (!input.hasNextInt()) {
                break;
            }
            int from = input.nextInt();
            int to = input.nextInt();
            ArrayList<String> preWords = new ArrayList<>();
            ArrayList<String> sufixWords = new ArrayList<>();
            ArrayList<String> words = new ArrayList<String>();
            int segStart = -1;
            int count = 0;
            for (int i = 0; i < content.length(); i++) {
                char c = content.charAt(i);
                if (c == ' ') {
                    if (segStart != -1) {
                        if (count >= from && count <= to) {
                            words.add(content.substring(segStart, i));
                        }
                        if (count < from) {
                            preWords.add(content.substring(segStart, i));
                        }
                        if (count > to) {
                            sufixWords.add(content.substring(segStart, i));
                        }
                        count++;
                        segStart = -1;
                    }
                } else {
                    if (segStart == -1) {
                        segStart = i;
                    }
                }
            }
            if (segStart != -1) {
                if (count >= from && count <= to) {
                    words.add(content.substring(segStart));
                }
                if (count < from) {
                    preWords.add(content.substring(segStart));
                }
                if (count > to) {
                    sufixWords.add(content.substring(segStart));
                }
                count++;
                segStart = -1;
            }
            if (from > to || words.size() <= 1) {
                System.out.println("EMPTY");
                continue;
            }
            int c = 0;
            for (int i = 0; i < preWords.size(); i++) {
                if (c > 0) {
                    System.out.print(" ");
                }
                System.out.print(preWords.get(i));
                c++;
            }
            for (int i = 0; i < words.size(); i++) {
                if (c > 0) {
                    System.out.print(" ");
                }
                System.out.print(words.get(words.size() - i - 1));
                c++;
            }
            for (int i = 0; i < sufixWords.size(); i++) {
                if (c > 0) {
                    System.out.print(" ");
                }
                System.out.print(sufixWords.get(i));
                c++;
            }
            System.out.println();
        }
    }
}