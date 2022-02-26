package acwing.contest.weekly.c40;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  String a, b;
  StringBuilder res = new StringBuilder();
  int[] cnt = new int[10];
  int len;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    a = in.nextString();
    b = in.nextString();
    len = a.length();
    StringBuilder sb = new StringBuilder();
    for (char c : a.toCharArray()) {
      cnt[c - '0']++;
    }
    int[] cb = new int[10];
    for (char c : b.toCharArray()) {
      cb[c - '0']++;
    }
    for (int i = 9; i >= 0; i--) {
      for (int j = 0; j < cnt[i]; j++) {
        sb.append(i);
      }
    }
    if (a.length() < b.length()) {
      out.println(sb.toString());
      return;
    }
    if (check(cnt, cb)) {
      out.println(b);
      return;
    }


    f:
    for (int i = len - 1; i >= 0; i--) {
      cb[b.charAt(i) - '0']--;
      StringBuilder tmp = new StringBuilder(b.substring(0, i));
      int[] clone = cnt.clone();
      for (int j = 0; j < 10; j++) {
        clone[j] -= cb[j];
        if (clone[j] < 0) {
          continue f;
        }
      }
      int lim = b.charAt(i) - '0';
      for (int j = lim - 1; j >= 0; j--) {
        if (clone[j] > 0) {
          tmp.append(j);
          clone[j]--;
          tmp.append(helper(clone));
          out.println(tmp.toString());
          return;
        }
      }
    }
  }

  private boolean check(int[] cnt, int[] cb) {
    for (int i = 0; i < 10; i++) {
      if (cnt[i] != cb[i]) {
        return false;
      }
    }
    return true;
  }

  private String helper(int[] cnt) {
    StringBuilder sb = new StringBuilder();
    for (int i = 9; i >= 0; i--) {
      for (int j = 0; j < cnt[i]; j++) {
        sb.append(i);
      }
    }
    return sb.toString();
  }

}
