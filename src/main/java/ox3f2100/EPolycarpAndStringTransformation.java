package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EPolycarpAndStringTransformation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int n = s.length();
    int[] cnt = new int[26];
    StringBuilder sb = new StringBuilder();
    for (int i = n - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (cnt[c - 'a'] == 0) {
        sb.insert(0, c);
      }
      cnt[c - 'a']++;
    }
    int m = sb.length();
    int len = 0;
    for (int i = 0; i < m; i++) {
      if (cnt[sb.charAt(i) - 'a'] % (i + 1) != 0) {
        out.println(-1);
        return;
      }
      cnt[sb.charAt(i) - 'a'] /= (i + 1);
      len += cnt[sb.charAt(i) - 'a'];
    }
    String res = s.substring(0, len);


    StringBuilder recover = new StringBuilder(res);
    StringBuilder tmp = new StringBuilder(res);


    for (int i = 0; i < sb.length(); i++) {
      char c = sb.charAt(i);
      StringBuilder ntmp = new StringBuilder();
      for (int j = 0; j < tmp.length(); j++) {
        if (c == tmp.charAt(j)) {
          continue;
        }
        recover.append(tmp.charAt(j));
        ntmp.append(tmp.charAt(j));
      }
      tmp = ntmp;
    }
    if (recover.toString().equals(s)) {
      out.println(res, sb);
    } else {
      out.println(-1);
    }
  }
}
