package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPassword {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int[] z = zFunction(s);
    int max = 0;
    for (int i = 1; i <= s.length() - 1; i++) {
      if (z[i] + i == s.length() && max >= s.length() - i) {
        out.println(s.substring(i));
        return;
      }
      max = Math.max(max, z[i]);
    }
    out.println("Just a legend");
  }

  int[] zFunction(String s) {
    int n = s.length();
    int[] z = new int[n];
    for (int i = 1, l = 0, r = 0; i < n; ++i) {
      if (i <= r && z[i - l] < r - i + 1) {
        z[i] = z[i - l];
      } else {
        z[i] = Math.max(0, r - i + 1);
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
          ++z[i];
        }
      }
      if (i + z[i] - 1 > r) {
        l = i;
        r = i + z[i] - 1;
      }
    }
    return z;
  }
}
