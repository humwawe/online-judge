package leetcode.c356;

/**
 * @author hum
 */
public class C1 {
  public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
    int res = 0;
    for (int h : hours) {
      if (h >= target) {
        res++;
      }
    }
    return res;
  }
}
