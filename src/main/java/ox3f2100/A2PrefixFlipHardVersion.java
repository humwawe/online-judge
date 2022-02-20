package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class A2PrefixFlipHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String a = in.nextString();
    String b = in.nextString();

    List<Integer> list = new ArrayList<>();
    int j = 0;
    int k = n - 1;
    boolean f = true;
    for (int i = n - 1; i >= 0; i--) {
      if (f) {
        if (b.charAt(i) == a.charAt(j)) {
          list.add(1);
        }
        list.add(i + 1);
        j++;
        f = false;
      } else {
        if (b.charAt(i) != a.charAt(k)) {
          list.add(1);
        }
        list.add(i + 1);
        k--;
        f = true;
      }
    }
    out.print(list.size());
    for (Integer i : list) {
      out.print(" " + i);
    }
    out.println();
  }
}
