package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D1TooManyImpostorsEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int last = -1;
    int[] a = new int[n + 1];
    Arrays.fill(a, -1);
    int i1 = -1;
    int i2 = -1;
    for (int i = 1; i + 2 <= n; i++) {
      out.println("?", i, i + 1, i + 2);
      out.flush();
      int x = in.nextInt();
      if (last != -1 && x != last) {
        a[i + 2] = x;
        a[i - 1] = 1 - x;
        i1 = i - 1;
        i2 = i + 2;
        break;
      }
      last = x;
    }

    for (int i = 1; i <= n; i++) {
      if (i == i1 || i == i2) {
        continue;
      }
      out.println("?", i, i1, i2);
      out.flush();
      int x = in.nextInt();
      a[i] = x;
    }
    out.print("! ");
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (a[i] == 0) {
        list.add(i);
      }
    }
    out.print(list.size() + " ");
    for (Integer i : list) {
      out.print(i, "");
    }
    out.println();
    out.flush();
  }
}
