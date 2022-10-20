package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BDreamoonLikesSequences {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int d = in.nextInt();
    int len = Integer.toBinaryString(d).length();

    int m = in.nextInt();
    int[] cnt = new int[len + 1];
    int p = 1;
    for (int i = 1; i < len; i++) {
      cnt[i] = p;
      p *= 2;
    }
    cnt[len] = d - Integer.highestOneBit(d) + 1;
    long res = 1;
    for (int i = 1; i <= len; i++) {
      res = res * (cnt[i] + 1) % m;
    }
    out.println((res - 1 + m) % m);
  }


}
