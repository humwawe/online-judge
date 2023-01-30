package leetcode.c329;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int[][] sortTheStudents(int[][] score, int k) {
    Arrays.sort(score, (x, y) -> y[k] - x[k]);
    return score;
  }
}
