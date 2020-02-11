package chapter2;

/**
 * 12_矩阵中的路径
 *      设计函数判断：一个矩阵中是否存在一条包含某字符串的所有字符的路径。
 *      路径可以从任意一格开始，每一步上下左右移动，如果走过一个格子，之后就不能再走这个格子
 */
public class T12_StringPathInMatrix {
    //想法：回溯法
    //每次走，走完判断这个位置是否符合要求：行列取值、没有访问过、字符符合要求。
    //若不满足则回溯，最后{返回真}的要求是将整个输入字符串比对完成
    /**
     * 判断是否有路径
     * @param matrix 字符矩阵，可以用二维也可以用一维，此处用一维
     * @param rows 行
     * @param cols 列
     * @param inputStr 某字符串
     * @return 是否存在
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] inputStr)
    {
        if (matrix == null || rows < 1 || cols < 1 || inputStr == null)
        {
            return false;
        }
        boolean[] isVisited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            isVisited[i] = false;
        }
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, inputStr, isVisited, pathLength))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 具体的回溯搜索
     * @param matrix 矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param row  当前行
     * @param col  当前列
     * @param inputStr  输入字符串
     * @param isVisited 判断某格是否访问过
     * @param pathLength 判断输入字符串已经判断的长度
     * @return
     */
    public static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                      char[] inputStr, boolean[] isVisited, int pathLength){
        if (pathLength == inputStr.length)
        {
            return true;
        }
        boolean rs = false;
        // 判断合法，开始回溯
        if (row >= 0 && col >= 0 && row < rows && col < cols && !isVisited[row * cols + col] &&
                matrix[row * cols + col] == inputStr[pathLength])
        {
            pathLength++;
            isVisited[row * cols + col] = true;
            rs = hasPathCore(matrix, rows, cols, row, col - 1, inputStr, isVisited, pathLength)
                    || hasPathCore(matrix, rows, cols, row - 1, col, inputStr, isVisited, pathLength)
                    || hasPathCore(matrix, rows, cols, row + 1, col, inputStr, isVisited, pathLength)
                    || hasPathCore(matrix, rows, cols, row, col + 1, inputStr, isVisited, pathLength);
            // 回溯
            if (!rs)
            {
                pathLength--;
                isVisited[row * cols + col] = false;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));
        System.out.println(hasPath("abtgcfcsjdeh".toCharArray(), 3, 4, "abfb".toCharArray()));
        System.out.println(hasPath("abtgcfcsjdeh".toCharArray(), 3, 4, "bfce".toCharArray()));
        System.out.println(hasPath("abccba".toCharArray(), 1, 6, "bcca".toCharArray()));
    }
}
