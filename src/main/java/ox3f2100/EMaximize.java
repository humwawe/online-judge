package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class EMaximize {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.nextInt();

    List<Integer> list = new ArrayList<>();
    int j = -1;
    long sum = 0;
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      if (t == 1) {
        int x = in.nextInt();
        list.add(x);
      } else {
        long max = list.get(list.size() - 1);
        while (j + 1 < list.size() - 1 && (sum + max) * (j + 3) > (sum + list.get(j + 1) + max) * (j + 2)) {
          sum += list.get(j + 1);
          j++;
        }
        out.println(max - (double) (sum + max) / (j + 2));
      }
    }
  }
}
