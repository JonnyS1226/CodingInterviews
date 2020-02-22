package chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一次只出现一次的字符
 */
public class T50_FirstNotRepeatingChar {

    /**
     * t51_01
     * 使用Hashmap保存每个字符出现的次数，
     * 然后第二次遍历扫描，输出map中存放的只出现一次，且位置靠前的字符
     */
    public static char getFirstNotRepearting(String str)
    {
        if (str == null) return ' ';
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c))
            {
                //重新放是会覆盖的
                int cnt = map.get(c);
                map.put(c, cnt + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1)
            {
                return chars[i];
            }
        }
        return ' ';
    }





    public static void main(String[] args) {
        System.out.println(getFirstNotRepearting("abaccbdeffd"));
    }
}
