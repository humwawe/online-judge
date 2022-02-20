package acwing.contest.weekly.c26;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int len;
  int[][] cnt;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    len = s.length();
    cnt = new int[len + 1][26];

    for (int i = 1; i <= len; i++) {
      char c = s.charAt(i - 1);
      System.arraycopy(cnt[i - 1], 0, cnt[i], 0, 26);
      cnt[i][c - 'a']++;
    }

    int k = s.length();
    for (int i = 0; i < 26; i++) {
      k = Math.min(k, helper(i));
    }
    out.println(k);
  }

  private int helper(int c) {
    if (cnt[len][c] == 0) {
      return len;
    }
    int l = 1;
    int r = len;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid, c)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private boolean check(int mid, int c) {
    for (int i = mid; i <= len; i++) {
      if (cnt[i][c] - cnt[i - mid][c] == 0) {
        return false;
      }
    }
    return true;
  }
}
