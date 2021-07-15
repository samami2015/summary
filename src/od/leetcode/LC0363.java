package od.leetcode;

public class LC0363 {
    public static void main(String[] args) {
        LC0363 solution = new LC0363();
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int ans = solution.maxSumSubmatrix(matrix,2);
        System.out.println(ans);
    }
    // 在数组 arr 中，求不超过 k 的最大值
    private int dpmax(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
            }
        }
        return max;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {// 枚举左边界
            int[] rowSum = new int[rows];// 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) {// 枚举右边界
                for (int i = 0; i < rows; i++) {// 按每一行累计到 geektime.dp
                    rowSum[i] += matrix[i][r];
                }
                // 求 rowSum 连续子数组 的 和
                // 和 尽量大，但不大于 k
                max = Math.max(max, dpmax(rowSum, k));
            }
        }
        return max;
    }
}
