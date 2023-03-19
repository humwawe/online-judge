package leetcode.c337;

/**
 * @author hum
 */
public class C1 {
  public int[] evenOddBit(int n) {
    String s = Integer.toBinaryString(n);
    s = new StringBuilder(s).reverse().toString();
    int[] res = new int[2];
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0 && s.charAt(i) == '1') {
        res[0]++;
      } else if (i % 2 == 1 && s.charAt(i) == '1') {
        res[1]++;
      }
    }
    return res;
  }
}
