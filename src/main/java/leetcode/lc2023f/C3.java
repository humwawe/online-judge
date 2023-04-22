package leetcode.lc2023f;

import java.util.*;

/**
 * @author hum
 */
public class C3 {
  public int fieldOfGreatestBlessing(int[][] forceField) {
    int n = forceField.length;
    int[][] fs = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    int res = 0;
    Set<Integer> set = new HashSet<>();
    List<Point> list = new ArrayList<>();
    for (int i = 0; i < forceField.length; i++) {
      int[] ints = forceField[i];
      list.add(new Point((double) ints[0] - (double) ints[2] / 2, ints[1], ints[2], 0, i));
      list.add(new Point((double) ints[0] + (double) ints[2] / 2, ints[1], ints[2], 1, i));
    }
    list.sort(Comparator.comparingDouble(x -> x.x));

    for (int i = 0; i < list.size(); i++) {
      int t = list.get(i).f;
      if (t == 0) {
        set.add(list.get(i).i);
      } else {
        set.remove(list.get(i).i);
      }
      double x = list.get(i).x;
      for (Integer integer : set) {
        double y = (double) forceField[integer][1] + (double) forceField[integer][2] / 2;
        res = Math.max(res, helper(x, y, forceField));
        y = (double) forceField[integer][1] + (double) forceField[integer][2] / 2;
        res = Math.max(res, helper(x, y, forceField));
      }
    }
    return res;
  }

  private int helper(double x, double y, int[][] forceField) {
    int res = 0;
    for (int[] ints : forceField) {
      double len = ints[2];
      double x1 = (double) ints[0] - len / 2;
      double y1 = (double) ints[1] - len / 2;
      double x2 = (double) ints[0] + len / 2;
      double y2 = (double) ints[1] + len / 2;
      if (cmp(x, x2) <= 0 && cmp(x, x1) >= 0 && cmp(y, y1) >= 0 && cmp(y, y2) <= 0) {
        res++;
      }
    }
    return res;
  }

  double eps = 1e-3;

  int cmp(double a, double b) {
    if (Math.abs(a - b) < eps) {
      return 0;
    }
    if (a < b) {
      return -1;
    }
    return 1;
  }

  class Point {
    double x;
    int y;
    int len;
    int f;
    int i;

    public Point(double x, int y, int len, int f, int i) {
      this.x = x;
      this.y = y;
      this.len = len;
      this.f = f;
      this.i = i;
    }
  }
}
