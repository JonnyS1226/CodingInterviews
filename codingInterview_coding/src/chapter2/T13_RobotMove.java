package chapter2;

import org.junit.Test;

/**
 * 13_机器人的运动范围
 *      m*n方格，机器人从(0,0)开始，每次上下左右四个方向，但不能进入行坐标和列坐标的数位之和大于k的格子。求机器人最多能到达多少个格子？
 *      k由用户输入
 */
public class T13_RobotMove {
    //仍然采用回溯法
    public static int movingCount(int k, int rows, int cols)
    {
        if (k < 0 || rows <= 0 || cols <= 0)
        {
            return 0;
        }
        int maxPathLength = 0;
        boolean[] isVisited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            isVisited[i] = false;
        }
        maxPathLength = movingCountCore(k, rows, cols, 0, 0, isVisited);
        return maxPathLength;
    }

    //具体回溯
    public static int movingCountCore(int k, int rows, int cols, int row, int col, boolean[] isVisited)
    {
        int maxPathLength = 0;
        if (check(k, rows, cols, row, col, isVisited))
        {
            isVisited[row * cols + col] = true;
            // 以下是回溯的翻版
            maxPathLength = 1 + movingCountCore(k, rows, cols, row + 1, col, isVisited) +
                    movingCountCore(k, rows, cols, row, col + 1, isVisited) +
                    movingCountCore(k, rows, cols, row - 1, col, isVisited) +
                    movingCountCore(k, rows, cols, row, col - 1, isVisited);
        }
        return maxPathLength;
    }

    //检查机器人能否进入某一格
    public static boolean check(int k, int rows, int cols, int row, int col, boolean[] isVisited)
    {
        if (row < rows && col < cols && row >= 0 && col >= 0
                && !isVisited[row * cols + col] && getDigitSum(row) + getDigitSum(col) <= k)
        {
            return true;
        }
        return false;
    }

    //获取数位之和
    public static int getDigitSum(int number)
    {
        int sum = 0;
        while (number > 0)
        {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
        System.out.println(movingCount(15, 10, 1));
        System.out.println(movingCount(12, 1, 1));
    }


}
