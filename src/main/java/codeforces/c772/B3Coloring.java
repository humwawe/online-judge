package codeforces.c772;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class B3Coloring {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    List<int[]> w = new ArrayList<>();
    List<int[]> b = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if ((i + j) % 2 == 0) {
          w.add(new int[]{i, j});
        } else {
          b.add(new int[]{i, j});
        }
      }
    }
    int wi = 0;
    int bi = 0;
    for (int i = 0; i < n * n; i++) {
      int a = in.nextInt();
      if (a == 1) {
        if (bi < b.size()) {
          out.println(2, b.get(bi)[0], b.get(bi)[1]);
          out.flush();
          bi++;
        } else {
          out.println(3, w.get(wi)[0], w.get(wi)[1]);
          out.flush();
          wi++;
        }
      } else if (a == 2) {
        if (wi < w.size()) {
          out.println(1, w.get(wi)[0], w.get(wi)[1]);
          out.flush();
          wi++;
        } else {
          out.println(3, b.get(bi)[0], b.get(bi)[1]);
          out.flush();
          bi++;
        }
      } else {
        if (wi < w.size()) {
          out.println(1, w.get(wi)[0], w.get(wi)[1]);
          out.flush();
          wi++;
        } else {
          out.println(2, b.get(bi)[0], b.get(bi)[1]);
          out.flush();
          bi++;
        }
      }
    }
  }
}
