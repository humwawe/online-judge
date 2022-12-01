package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.BitSet;

import java.util.Arrays;

public class Task1024 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    BitSet[] bitSets = new BitSet[n];
    Arrays.setAll(bitSets, e -> new BitSet(n));
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      bitSets[a].set(b);
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        if (bitSets[i].get(k)) {
          bitSets[i].or(bitSets[k]);
        }
      }
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (!bitSets[i].get(j) && !bitSets[j].get(i)) {
          res++;
        }
      }
    }
    out.println(res);
  }
}
