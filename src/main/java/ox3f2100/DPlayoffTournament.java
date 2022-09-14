package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DPlayoffTournament {
  int k;
  String s;
  char[] ss;
  int[] cnt;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    k = in.nextInt();
    s = in.nextString();
    ss = s.toCharArray();
    int i = 0;
    int j = ss.length - 1;
    while (i < j) {
      char t = ss[i];
      ss[i] = ss[j];
      ss[j] = t;
      i++;
      j--;
    }

    int n = 1 << k;
    cnt = new int[n * 2];
    Arrays.fill(cnt, 1);
    for (int l = n - 2; l >= 0; l--) {
      upd(l);
    }
    int q = in.nextInt();
    for (int l = 0; l < q; l++) {
      int p = in.nextInt();
      char c = in.nextCharacter();
      p = n - p - 1;
      ss[p] = c;
      while (p > 0) {
        upd(p);
        p = (p - 1) / 2;
      }
      out.println(upd(0));
    }
  }

  private int upd(int i) {
    return cnt[i] = (ss[i] != '0' ? cnt[i * 2 + 1] : 0) + (ss[i] != '1' ? cnt[i * 2 + 2] : 0);
  }


}
