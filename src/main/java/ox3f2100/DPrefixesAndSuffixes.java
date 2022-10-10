package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DPrefixesAndSuffixes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int[] zs = zFunction(s);
    List<Integer> res = new ArrayList<>();
    int[] sum = new int[s.length() + 1];
    for (int i = 1; i < s.length(); i++) {
      if (i + zs[i] == s.length()) {
        res.add(zs[i]);
      }
      sum[1]++;
      sum[zs[i] + 1]--;
    }
    Collections.sort(res);
    for (int i = 0; i < s.length(); i++) {
      sum[i + 1] += sum[i];
    }
    out.println(res.size() + 1);
    for (Integer r : res) {
      out.println(r, sum[r] + 1);
    }

    out.println(s.length(), 1);

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
