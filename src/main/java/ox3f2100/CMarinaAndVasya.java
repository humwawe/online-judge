package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CMarinaAndVasya {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int t = in.nextInt();

    String s1 = in.nextString();
    String s2 = in.nextString();
    char[] res = new char[n];
    Arrays.fill(res, '#');
    int x = n - t;
    for (int i = 0; i < n; i++) {
      if (s1.charAt(i) == s2.charAt(i) && x > 0) {
        res[i] = s1.charAt(i);
        x--;
      }
    }
    int t1 = x;
    int t2 = x;
    for (int i = 0; i < n; i++) {
      if (res[i] == '#') {
        if (t1 > 0) {
          res[i] = s1.charAt(i);
          t1--;
        } else if (t2 > 0) {
          t2--;
          res[i] = s2.charAt(i);
        } else {
          for (char c : "abc".toCharArray()) {
            if (c != s1.charAt(i) && c != s2.charAt(i)) {
              res[i] = c;
              break;
            }
          }
        }
      }
    }
    if (t1 > 0 || t2 > 0) {
      out.println(-1);
    } else {
      out.println(res);
    }
  }
}
