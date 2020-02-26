package chapter6;

/**
 * 三道发散思维题目
 */
public class T64_T65_T66 {
    /**
     * 不使用乘除法，条件判断，循环等关键字   实现1+2+3+。。。。+n
     */
    public int sum1(int n)
    {
        int sum = n;
        // && 短路与 n > 0为假时，不会再进行后面的判断，递归终止
        boolean res = (n > 0) && ((sum += sum1(n - 1)) > 0);
        return sum;

    }

    /**
     * 不使用四则运算，实现两个数加法
     * 异或+进位
     */
    public int sum2(int a, int b)
    {
        while (b != 0) {
            int curSum = (a ^ b);
            b = ((a & b) << 1); // 计算进位. 先保留同为1的位，都为1的位要向左进位，因此左移1位
            a = curSum;
        }
        return a;
    }


    /**
     * 给定一个数组A[0,1,...N-1],构建一个B[0,1,...,N-1]，其中B的元素B[i]=A[0]xA[1]....xA[i-1]xA[i+1]x....xA[n-1]
     * 不使用除法
     *
     * 解决方法：第一个循环先求出左半边A[0]xA[1]....xA[i-1]，第二个循环求出右半边A[i+1]x....xA[n-1]
     */
    public int[] constructArr(int[] a) {
        if(a == null || a.length == 0) return new int[0];
        int[] ans = new int[a.length];
        int left = 1;
        int right = 1;
        for(int i = 0;i < a.length; i++){
            ans[i] = left;
            left *= a[i];
        }

        for(int i = a.length - 1; i >= 0; i--){
            ans[i] *= right;
            right *= a[i];
        }
        return ans;
    }

}
