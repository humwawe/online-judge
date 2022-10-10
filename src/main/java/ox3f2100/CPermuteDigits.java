package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CPermuteDigits {
  StringBuilder res = new StringBuilder();
  int[] numa, numb, use;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String a = in.nextString();
    String b = in.nextString();
    numa = new int[a.length()];
    use = new int[10];
    for (int i = 0; i < a.length(); i++) {
      numa[i] = a.charAt(i) - '0';
      use[numa[i]]++;
    }
    numb = new int[b.length()];
    for (int i = 0; i < b.length(); i++) {
      numb[i] = b.charAt(i) - '0';
    }
    if (numa.length < numb.length) {
      Arrays.sort(numa);
      for (int i = numa.length - 1; i >= 0; i--) {
        out.print(numa[i]);
      }
      out.println();
      return;
    }
    dfs(0, use, true, true);
    out.println(res);
  }

  boolean dfs(int i, int[] use, boolean limit, boolean lead) {
    if (i == numa.length) {
      return true;
    }
    int up = limit ? numb[i] : 9;
    int low = lead ? 1 : 0;
    for (int j = up; j >= low; j--) {
      if (use[j] > 0) {
        res.append(j);
        use[j]--;
        if (dfs(i + 1, use, limit && j == up, false)) {
          return true;
        }
        res.setLength(res.length() - 1);
        use[j]++;
      }
    }
    return false;

  }
}
