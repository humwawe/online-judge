package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class AStrangeAddition {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] cnt = new int[5];
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      if (a == 0) {
        cnt[0] = 1;
      } else if (a == 100) {
        cnt[1] = 1;
      } else if (a % 10 == 0) {
        cnt[2] = a;
      } else if (a < 10) {
        cnt[3] = a;
      } else {
        cnt[4] = a;
      }
    }
    List<Integer> res = new ArrayList<>();
    if (cnt[0] != 0) {
      res.add(0);
    }
    if (cnt[1] != 0) {
      res.add(100);
    }
    if (cnt[2] != 0) {
      res.add(cnt[2]);
    }
    if (cnt[3] != 0) {
      res.add(cnt[3]);
    }
    if (cnt[2] == 0 && cnt[3] == 0 & cnt[4] != 0) {
      res.add(cnt[4]);
    }
    out.println(res.size());
    out.println(res);

  }
}
