package chapter6;

import java.util.LinkedList;

/**
 * 圆圈内的最后剩下的数字
 *      0，1，2...n-1，这n个数字排成一圈，从0开始，每次从这个圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字
 */
public class T62_LastNumberInCircle {
    /**
     * 即约瑟夫环问题
     */
    /**
     * 方法1：环形链表，按照题意不断删除
     */
    //超时
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() != 1) {
            for (int i = 0; i < m; i++) {
                Integer pre = list.pollFirst();
                if (i != m - 1) {
                    list.add(pre);
                }
            }
        }
        return list.pollFirst();
    }

    /**
     * 方法2：数学规律法
     *
     */
    public int lastRemaining2(int n, int m) {
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i;
            //动态规划的思想，将f(n,m)替换成flag存储
        }
        return flag;
    }




}
