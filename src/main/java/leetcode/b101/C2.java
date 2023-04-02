package leetcode.b101;

/**
 * @author hum
 */
public class C2 {
  public int maximumCostSubstring(String s, String chars, int[] vals) {
    int[] a = new int[26];
    for (int i = 0; i < 26; i++) {
      a[i] = i + 1;
    }

    char[] charArray = chars.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      a[c - 'a'] = vals[i];
    }

    int res = 0;
    int min = 0;
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      sum += a[s.charAt(i) - 'a'];
      res = Math.max(res, sum - min);
      min = Math.min(min, sum);
    }
    return res;
  }
}
