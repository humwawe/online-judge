package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CSubsequenceCounting {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    int d = in.nextInt();
    List<Long> list = new ArrayList<>();
    long num = 1;
    for (int i = 30; i >= 1; i--) {
      int cnt = (1 << i) - 1;
      while (x >= cnt) {
        for (int j = 0; j < i; j++) {
          list.add(num);
        }
        x -= cnt;
        num += (d + 1);
      }
    }
    out.println(list.size());
    out.println(list);
  }
}
