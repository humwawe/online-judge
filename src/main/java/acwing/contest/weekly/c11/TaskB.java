package acwing.contest.weekly.c11;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int[] tmp = new int[(int) 1e5];
  int len;

  {
    int num = (int) 2e9;
    for (int i = 1; i * i <= num; i++) {
      tmp[len++] = i * i;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    char[] chars = String.valueOf(n).toCharArray();
    int res = 20;
    for (int i = 0; i < len && tmp[i] <= n; i++) {
      int x = tmp[i];
      res = Math.min(res, helper(x, chars));
    }
    if (res == 20) {
      out.println(-1);
    } else {
      out.println(res);
    }
  }

  private int helper(int x, char[] chars) {
    int len = chars.length;
    int res = 0;
    int i = len - 1;
    while (x > 0) {
      int t = x % 10;
      while (i >= 0 && chars[i] - '0' != t) {
        i--;
        res++;
      }
      if (i >= 0) {
        x /= 10;
        i--;
      } else {
        return 20;
      }
    }
    return res + i + 1;
  }
}
