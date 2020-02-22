package chapter4;

/**
 * 顺时针打印矩阵
 *      按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class T29_PrintMatrix {

    /**
     * 这个问题的关键是要判断出什么时候遍历顺序改变方向
     * 可以看出四段：
     *      a[i, j]:  j=j+1
     *      a[j, n-i-1]: j=j+1
     *      a[n-i-1, j]: j=j-1
     *      a[j, i]: j=j-1
     * 而对于奇数的情况，最终要再输出一次
     * 但下面的方法只适用于方阵
     * @param matrix
     * @param n
     */
    public static void printMatrixMethod1(int[][] matrix, int n)
    {
        if (matrix == null || n <= 0) return;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            for (int j = i; j < n - i - 1; j++) {
                System.out.print(matrix[j][n- i - 1] + " ");
            }
            for (int j = n - i - 1; j > i; j--) {
                System.out.print(matrix[n - i -1][j] + " ");
            }
            for (int j = n - i - 1; j > i; j--) {
                System.out.print(matrix[j][i] + " ");
            }
        }
        if ((n & 1) == 1)
        {
            System.out.print(matrix[(n - 1) / 2][(n - 1) / 2]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printMatrixMethod1(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 4);
    }
}
