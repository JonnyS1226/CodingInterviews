package chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 *      如‘arabcacfr’ 最长不含重复字符的子字符串就是acfr，计算出其长度
 */
public class T48_LongestSubStringWithoutDup {

    /**
     * 使用滑动窗口
     */
    public int lengthOfLongestSubstring(String s)
    {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int end;
        int start = 0;
        for (end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end)))
            {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
