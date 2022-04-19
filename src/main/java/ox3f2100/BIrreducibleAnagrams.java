package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BIrreducibleAnagrams {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int[][] sum = new int[s.length() + 1][26];
    for (int i = 0; i < s.length(); i++) {
      System.arraycopy(sum[i], 0, sum[i + 1], 0, 26);
      sum[i + 1][s.charAt(i) - 'a']++;
    }
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      int cnt = 0;
      for (int j = 0; j < 26; j++) {
        cnt += (sum[r][j] - sum[l - 1][j] > 0 ? 1 : 0);
      }
      if (l == r || cnt >= 3 || s.charAt(l - 1) != s.charAt(r - 1)) {
        out.println("Yes");
      } else {
        out.println("No");
      }
    }


  }
}
