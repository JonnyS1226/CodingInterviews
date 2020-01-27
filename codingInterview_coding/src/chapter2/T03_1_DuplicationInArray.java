package chapter2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 找出数组中重复的数字
 */
public class T03_1_DuplicationInArray {

    // 先排序，再找任意一个重复的
    public static int sortToFind(int[] array, int length)
    {
        Arrays.sort(array);
        for (int i = 0; i < length - 1; i++)
        {
            if(array[i] == array[i + 1])
            {
                return array[i];
            }
        }
        throw new IllegalArgumentException("没有重复的");
    }

    // 通过Hash函数存放每一位，判断是否有重复
    public static int hashToFind(int[] array, int length)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i ++)
        {
            if(map.containsKey(array[i]))
            {
                return array[i];
            }
            map.put(array[i], i);
        }
        throw new IllegalArgumentException("没有重复的");
    }

    /**
     *   若假定数组长度为n，而数组中所有值在[0, n-1]，则有如下方法
     *   若正常升序后，无重复的数字的结果：值i一定在第i位上。
     *   故模拟排序的过程，来寻找
     *   1. 先判断第i位是不是i，若是则下一位，若不是，则将其与第array[i]位对换，这样第array[i]上就是array[i]
     *   2. 同时要判断array[i]是否等于array[array[i]]，若相等，说明这个array[i]即重复数字
     */
    public static int specialFind(int[] array, int length){
        for(int i = 0; i < length; i++)
        {
            if(array[i] != i)
            {
                if(array[i] == array[array[i]])
                {
                    return array[i];
                }
                int tmp = array[i];
                array[i] = array[tmp];
                array[tmp] = tmp;
            }
        }
        throw new IllegalArgumentException("没有重复元素");
    }

    public static void main(String[] args) {
        System.out.println("输入数组长度：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("输入数组：");
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = sc.nextInt();
        }
        System.out.println("哈希方法--重复的数字是:" + hashToFind(array, n));
        System.out.println("排序方法--重复的数字是:" + sortToFind(array, n));
        System.out.println("特殊方法--重复的数字是:" + specialFind(array, n));
    }

}
