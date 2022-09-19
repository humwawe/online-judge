package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class D2RemoveTheSubstringHardVersion {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    String t = in.nextString();
    int[] left = helper(s, t);
    s = new StringBuilder(s).reverse().toString();
    t = new StringBuilder(t).reverse().toString();
    int[] right = helper(s, t);
    for (int i = 0; i < right.length; i++) {
      right[i] = s.length() - 1 - right[i];
    }
    Arrays.sort(right);

    int res = 0;
    for (int i = 0; i < left.length - 1; i++) {
      res = Math.max(res, right[i + 1] - left[i] - 1);
    }
    res = Math.max(res, right[0]);
    res = Math.max(res, s.length() - left[left.length - 1] - 1);
    out.println(res);
  }

  private int[] helper(String s, String t) {
    int[] res = new int[t.length()];
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (j == t.length()) {
        break;
      }
      if (s.charAt(i) == t.charAt(j)) {
        res[j] = i;
        j++;
      }
    }
    return res;
  }
}
