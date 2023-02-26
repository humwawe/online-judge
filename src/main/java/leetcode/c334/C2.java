package leetcode.c334;

/**
 * @author hum
 */
public class C2 {
  public int[] divisibilityArray(String word, int m) {
    int n = word.length();
    int[] res = new int[n];
    long cur = 0;
    for (int i = 0; i < n; i++) {
      cur = cur * 10 + (word.charAt(i) - '0');
      if (cur % m == 0) {
        res[i] = 1;
      }
      cur %= m;
    }
    return res;
  }
}
