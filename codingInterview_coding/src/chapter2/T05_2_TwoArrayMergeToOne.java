package chapter2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个排序的数组A1和A2，A1末尾有足够多空余空间容纳A2，合并这两个数组，形成有序数组
 */
public class T05_2_TwoArrayMergeToOne {

    //orignalLength是A1的有意义部分（即原始长度）
    public static int[] twoArrayMerge(int[] A1, int[] A2, int originalLength)
    {
        int indexOfA1 = originalLength;
        int indexOfA2 = A2.length - 2;
        int indexOfNew = originalLength + A2.length - 1;
        while (indexOfA1 >= 0 && indexOfA2 >= 0)
        {
            if (A1[indexOfA1] >= A2[indexOfA2])
            {
                A1[indexOfNew--] = A1[indexOfA1];
                indexOfA1--;
            }
            else
            {
                A1[indexOfNew--] = A2[indexOfA2];
                indexOfA2--;
            }
        }
        return A1;
    }

    public static void main(String[] args) {
//        List<Integer> l1 = new ArrayList<>();
//        List<Integer> l2 = new ArrayList<>();
//        List list = Arrays.asList(1, 2, 4, 5, 8, 11);
//        l1.addAll(list);
//        list = Arrays.asList(0, 3, 4, 6, 7, 10, 13);
//        l2.addAll(list);
        //下面为初始化
        int[] A2 = new int[]{1, 4, 8, 11, 13, 20, 29};
        int[] A1 = new int[100];
        for (int i = 0; i < 10; i++) {
            A1[i] = i + 2;
        }
        int originalLength = 10;
        twoArrayMerge(A1, A2, originalLength);
        for (int i = 0; i < originalLength + A2.length; i++) {
            System.out.print(i + "  ");
        }
    }
}
