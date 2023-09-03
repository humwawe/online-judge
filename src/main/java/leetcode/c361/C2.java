package leetcode.c361;

/**
 * @author hum
 */
public class C2 {
  public int minimumOperations(String num) {
    int res = num.length();
    res = Math.min(res, helper(num, '0', '0'));
    res = Math.min(res, helper(num, '2', '5'));
    res = Math.min(res, helper(num, '5', '0'));
    res = Math.min(res, helper(num, '7', '5'));

    if (num.contains("0")) {
      res = Math.min(res, num.length() - 1);
    }
    return res;
  }


  private int helper(String num, char fir, char sec) {
    boolean f = false;
    for (int i = num.length() - 1; i >= 0; i--) {
      if (f && num.charAt(i) == fir) {
        return num.length() - i - 2;
      }
      if (num.charAt(i) == sec) {
        f = true;
      }
    }
    return num.length();
  }
}
