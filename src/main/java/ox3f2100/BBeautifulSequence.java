package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BBeautifulSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] old = new int[4];
    int sum = 0;
    for (int i = 0; i < 4; i++) {
      old[i] = in.nextInt();
      sum += old[i];
    }

    f:
    for (int i = 0; i < 4; i++) {
      List<Integer> list = new ArrayList<>();
      var a = old.clone();
      if (a[i] > 0) {
        list.add(i);
        a[i]--;

        int last = i;
        for (int j = 0; j < sum - 1; j++) {
          if (last - 1 >= 0 && a[last - 1] > 0) {
            list.add(last - 1);
            a[last - 1]--;
            last = last - 1;
          } else if (last + 1 < 4 && a[last + 1] > 0) {
            list.add(last + 1);
            a[last + 1]--;
            last = last + 1;
          } else {
            continue f;
          }
        }
        out.println("YES");
        out.println(list);
        return;
      }

    }
    out.println("NO");

  }
}
