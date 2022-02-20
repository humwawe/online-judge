package codeforces.e113;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BChessTournament {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) - '0' == 1) {
        list1.add(i);
      } else {
        list2.add(i);
      }

    }
    if (list2.size() == 0) {
      out.println("YES");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i == j) {
            out.print('X');
            continue;
          }
          out.print('=');
        }
        out.println();
      }
      return;
    }
    if (list2.size() <= 2) {
      out.println("NO");
      return;
    }
    char[][] res = new char[n][n];

    for (int i = 0; i < list2.size(); i++) {
      res[list2.get(i)][list2.get((i + 1) % list2.size())] = '+';
      res[list2.get((i + 1) % list2.size())][list2.get(i)] = '-';
    }

    out.println("YES");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          out.print('X');
          continue;
        }
        if (res[i][j] != '+' && res[i][j] != '-') {
          out.print('=');
          continue;
        }
        out.print(res[i][j]);
      }
      out.println();
    }
  }
}
