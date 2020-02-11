package chapter2;

import java.util.Scanner;

/**
 * 04_二维数组的查找
 *      每一行从左向右递增，每一列从上向下递增，输入二维数组和一个整数，判断二维数组中是否含有该整数。
 */
public class T04_FindInPartiallySortedMatrix {
    //方法1 蛮力法，从左上角或者右下角开始寻找 T(n) = O(mn)
    //方法2 蛮力法+二分 每一行看成有序数组 用二分法查找 m行n列 T(n) = mO(logn)
    public static boolean findValueMid(int[][] matrix, int rows, int columns, int value)
    {
        boolean isFound = false;
        if (matrix != null && rows > 0 && columns > 0)
        {
            for (int i = 0; i < rows; i++) {
                int start = 0;
                int end = columns - 1;
                while (start <= end)
                {
                    int mid = (start + end) / 2;
                    if (value == matrix[i][mid])
                    {
                        isFound = true;
                        return isFound;
                    }
                    else if (value > matrix[i][mid])
                    {
                        start = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
            }
        }
        return isFound;
    }


    //方法3 书中所用，从右上角开始逐渐向左下角减小范围，每一次列首元素和要寻找元素比较，然后剔除一列，或者剔除一行，直至找到
    public static boolean findValue(int[][] matrix, int rows, int columns, int value){
        boolean isFound = false;
        if (matrix != null && rows > 0 && columns > 0)
        {
            int row = 0;
            int column = columns - 1;
            while (column >= 0 && row < rows)
            {
                if (matrix[row][column] == value)
                {
                    isFound = true;
                    break;
                }
                else if (matrix[row][column] < value)
                {
                    row++;
                }
                else
                {
                    column--;
                }
            }
        }
        return isFound;
    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int value;
        System.out.println("输入要寻找的元素:");
        Scanner sc = new Scanner(System.in);
        value = sc.nextInt();
        System.out.print("行列排除法--寻找元素");
        System.out.print(value + "的结果是:");
        System.out.println(findValue(matrix, matrix.length, matrix[0].length, value)? "存在":"不存在");
        System.out.print("蛮力法--寻找元素");
        System.out.print(value + "的结果是:");
        System.out.println(findValue(matrix, matrix.length, matrix[0].length, value)? "存在":"不存在");
    }
}
