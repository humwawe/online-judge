package codeforces.e128;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBinaryString {
  String s;
  int n;
  int cnt1;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    n = s.length();
    cnt1 = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        cnt1++;
      }
    }
    int l = 0;
    int r = cnt1;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    out.println(l);
  }

  private boolean check(int mid) {
    int cnt0 = mid;
    int need = cnt1 - mid;
    int sum = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        sum++;
      }
      while (j <= i && sum >= need) {
        if (i - j + 1 - need <= cnt0) {
          return true;
        }
        if (s.charAt(j) == '1') {
          sum--;
        }
        j++;
      }
    }

    return false;
  }
}
