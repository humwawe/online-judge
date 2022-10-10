package atcoder.arc150;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AContinuous1 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    String s = in.nextString();
    int a = n;
    int b = 0;
    int cnt = 0;
    int cntx = 0;

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        a = Math.min(i, a);
        b = i;
        cnt++;
      }
    }
    int c1 = 0;
    int max = 0;
    int max2 = 0;
    if (cnt == 0) {
      for (int i = 0; i < n; i++) {
        if (s.charAt(i) == '?') {
          c1++;
        } else {
          c1 = 0;
        }
        if (c1 > max) {
          max = c1;
          max2 = 1;
        } else if (c1 == max) {
          max2++;
        }
      }
    }
    if (cnt == 0) {
      if (max2 == 1 && max == k) {
        out.println("Yes");
      } else {
        out.println("No");
      }
      return;
    }

    if (cnt > k) {
      out.println("No");
      return;
    }
    for (int i = a; i <= b; i++) {
      if (s.charAt(i) == '0') {
        out.println("No");
        return;
      }
    }
    int l = b - a + 1;
    if (l == k) {
      out.println("Yes");
      return;
    }
    if (l > k) {
      out.println("No");
      return;
    }
    int cn1 = 0;
    int cnt2 = 0;
    while (a - 1 >= 0 && s.charAt(a - 1) == '?') {
      a--;
      cn1++;
    }
    while (b + 1 < n && s.charAt(b + 1) == '?') {
      b++;
      cnt2++;
    }

    if (b - a + 1 >= k) {
      if (b - a + 1 == k || cn1 == 0 || cnt2 == 0) {
        out.println("Yes");
      } else {
        out.println("No");
      }
    } else {
      out.println("No");
    }

  }
}
