package codeforces.c773;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class AHardWay {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Integer[][] p = new Integer[3][2];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 2; j++) {
        p[i][j] = in.nextInt();
      }
    }
    Arrays.sort(p, Comparator.comparingInt(x -> x[1]));
    if (p[1][1].equals(p[2][1]) && p[0][1] < p[1][1]) {
      out.println(Math.abs(p[1][0] - p[2][0]));
    } else {
      out.println(0);
    }
  }
}
