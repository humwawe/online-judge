package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPalindromeTransformation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int p = in.nextInt() - 1;
    String s = in.nextString();
    long sum = 0;
    for (int i = 0; i < n / 2; i++) {
      char a = s.charAt(i);
      char b = s.charAt(n - 1 - i);
      sum += Math.min(Math.abs(a - b), 26 - Math.abs(a - b));
    }

    if (p >= n / 2) {
      p = n - 1 - p;
    }
    int r = n / 2;
    while (r - 1 > 0 && s.charAt(r - 1) == s.charAt(n - r)) {
      r--;
    }
    int l = -1;
    while (l + 1 < n && s.charAt(l + 1) == s.charAt(n - (l + 1) - 1)) {
      l++;
    }
    if (l < r) {
      sum += Math.min(Math.abs((l + 1) - p) + Math.abs((r - 1) - (l + 1)), Math.abs((r - 1) - p) + Math.abs((r - 1) - (l + 1)));
    }

    out.println(sum);
  }
}
