package code.jam.o2022.qualification;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class PunchedCards {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    out.printf("Case #%d:\n", testNumber);
    int r = in.nextInt();
    int c = in.nextInt();
    List<String> list = new ArrayList<>();
    for (int i = 0; i < r; i++) {
      StringBuilder a = new StringBuilder();
      StringBuilder b = new StringBuilder();
      for (int j = 0; j < c; j++) {
        a.append("+-");
        b.append("|.");
      }
      a.append("+");
      b.append("|");
      if (i == 0) {
        a.setCharAt(0, '.');
        a.setCharAt(1, '.');
        b.setCharAt(0, '.');
      }
      list.add(a.toString());
      list.add(b.toString());
    }
    StringBuilder tmp = new StringBuilder();
    for (int i = 0; i < c; i++) {
      tmp.append("+-");
    }
    tmp.append("+");
    list.add(tmp.toString());
    for (String s : list) {
      out.println(s);
    }
  }
}
