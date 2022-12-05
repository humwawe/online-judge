package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] row = new int[n];
    int[] col = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char c = in.nextCharacter();
        if (c == 'C') {
          row[i]++;
          col[j]++;
        }
      }
    }

    long res = 0;
    for (int i = 0; i < n; i++) {
      res += row[i] * (row[i] - 1) / 2;
      res += col[i] * (col[i] - 1) / 2;
    }
    out.println(res);
  }
}
