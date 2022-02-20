package acwing.contest.weekly.c23;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    //        int n = in.nextInt();
    //        int k = in.nextInt();

    for (int k = 3; k <= 20; k += 3) {
      for (int n = 4; n <= 20; n++) {
        if (!helper(n, k)) {
          out.println(n + " " + k);
        }
      }
    }
  }

  boolean right(int n, int k) {
    if (k % 3 != 0) {
      return n % 3 != 0;
    } else {
      n %= k + 1;
      return n == k || n % 3 != 0;
    }
  }

  private boolean helper(int i, int j) {
    if (i == 0) {
      return false;
    }
    if (i >= 1 && !helper(i - 1, j)) {
      return true;
    }
    if (i >= 2 && !helper(i - 2, j)) {
      return true;
    }
    if (i >= j && !helper(i - j, j)) {
      return true;
    }
    return false;
  }
}
