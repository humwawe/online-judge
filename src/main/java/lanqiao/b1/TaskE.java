package lanqiao.b1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    String t = in.nextString();
    t = helper(t);
    String tmp = t + "#" + s + s;
    int[] z = zFunction(tmp);
    int res = 2 * n;
    for (int i = n + 1; i < z.length - n; i++) {
      if (z[i] == n) {
        res = Math.min(res, i - n - 1);
        res = Math.min(res, n - (i - n - 1));
      }
    }
    if (res != 2 * n) {
      out.println("Yes");
      out.println(res);
    } else {
      out.println("No");
    }

  }

  private String helper(String t) {
    StringBuilder sb = new StringBuilder();
    for (char c : t.toCharArray()) {
      if (Character.isLowerCase(c)) {
        sb.append(Character.toUpperCase(c));
      } else {
        sb.append(Character.toLowerCase(c));
      }
    }
    return sb.toString();
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
