package codeforces.e137;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DProblemWithRandomTests {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int i = 0;
    while (i < n && s.charAt(i) == '0') {
      i++;
    }
    if (i == n) {
      out.println("0");
      return;
    }
    int j = i;
    while (j < n && s.charAt(j) == '1') {
      j++;
    }
    if (j == n) {
      out.println(s.substring(i));
      return;
    }
    String res = s.substring(i);
    for (int k = 1; k <= j - i + 1; k++) {
      String x = s.substring(i, n - k);
      String tmp = helper(s, x, i);
      if (res.compareTo(tmp) < 0) {
        res = tmp;
      }
    }
    out.println(res);
  }

  private String helper(String s, String x, int i) {
    StringBuilder sb = new StringBuilder();
    int idx = x.length() - 1;
    for (int j = s.length() - 1; j >= i; j--) {
      int a = s.charAt(j) - '0';
      int b = idx >= 0 ? x.charAt(idx--) - '0' : 0;
      sb.append(a | b);
    }
    return sb.reverse().toString();
  }
}
