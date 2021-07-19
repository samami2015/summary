package summary.twostar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 【可以组成网络的服务器】
 * 在一个机房中，服务器的位置标识在 n*m 的整数矩阵网格中，1 表示单元格上有服务器，0 表示没有。如果两台服务器位于同一行或者同
 * 一列中紧邻的位置，则认为它们之间可以组成一个局域网。
 * 请你统计机房中最大的局域网包含的服务器个数。
 * <p>
 * 输入描述：
 * 第一行输入两个正整数，n和m，0<n,m<=100
 * 之后为n*m的二维数组，代表服务器信息
 * <p>
 * 输出描述：
 * 最大局域网包含的服务器个数。
 * <p>
 * 示例1：
 * 输入
 * <p>
 * 2 2
 * 1 0
 * 1 1
 * <p>
 * 输出
 * 3
 */
public class 可以组成网络的服务器 {
    private static class Node {
        public int id;
        public int parentId;

        public Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int n;
        int m;
        while (scanner.hasNextInt()) {
            line = scanner.nextLine();
            String[] arr = line.split(" ");
            n = Integer.parseInt(arr[0]);
            m = Integer.parseInt(arr[1]);
            int[][] matrix = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                line = scanner.nextLine();
                arr = line.split(" ");
                for (int j = 1; j <= m; j++) {
                    matrix[i][j] = Integer.parseInt(arr[j - 1]);
                }
            }
            List<Node> nodes = new ArrayList<>();
            Map<Integer, List<Integer>> adj = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }
                    nodes.add(new Node(i * m + j));
                    if (j + 1 <= m && matrix[i][j + 1] == 1) {
                        adj.computeIfAbsent(i * m + j, key -> new ArrayList<>()).add(i * m + j + 1);
                    }
                    if (i + 1 <= n && matrix[i + 1][j] == 1) {
                        adj.computeIfAbsent(i * m + j, key -> new ArrayList<>()).add(i * m + m + j);
                    }
                    if (j - 1 >= 1 && matrix[i][j - 1] == 1) {
                        adj.computeIfAbsent(i * m + j, key -> new ArrayList<>()).add(i * m + j - 1);
                    }
                    if (i - 1 >= 1 && matrix[i - 1][j] == 1) {
                        adj.computeIfAbsent(i * m + j, key -> new ArrayList<>()).add(i * m - m + j);
                    }
                }
            }
            Map<Integer, Node> nodeMap = nodes.stream().collect(Collectors.toMap(node -> node.id, node -> node));
            for (Node node : nodes) {
                if (node.parentId == 0) {
                    node.parentId = node.id;
                }
                if (adj.get(node.id) == null) {
                    continue;
                }
                for (Integer next : adj.get(node.id)) {
                    Node cur = nodeMap.get(next);
                    if (cur.parentId == 0) {
                        cur.parentId = node.parentId;
                    } else if (cur.parentId != node.parentId) {
                        nodes.stream().filter(ns -> ns.parentId == cur.parentId).forEach(ns -> ns.parentId = node.parentId);
                    }
                }
            }
            Map<Integer, List<Node>> parentMap = nodes.stream().collect(Collectors.groupingBy(node -> node.parentId));
            Optional<Integer> max = parentMap.values().stream().map(values -> values.size()).max(Integer::compareTo);
            System.out.println(max.get());
        }
    }
}
