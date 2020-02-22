package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小数
 *      例如输入数组{3, 32, 321}，则输出排成的最小数321323
 */
public class T45_SortArrayForMinNumber {

    /**
     * 方法1：按照T38的方法，先求出所有的字符全排列，在其中找到最小数字
     */

    /**
     * 方法2：贪心思想
     * 显然要保证越靠前的数越小
     * 所以将数组排序，排序的准则是越小的越前
     * 但由于各个数组中的字符元素长度不等，难以直接比较
     * 所以采取这样的方法：对于长度不等的s1和s2， 比较s1+s2和s2+s1，若前者小，则s1在前
     */
    public static String minNumber(int[] array)
    {
        String[] strNum = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strNum[i] = String.valueOf(array[i]);
        }
        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String string : strNum) {
            sb.append(string);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(minNumber(new int[] {3, 32, 321}));
    }
}
