package nowcoder.r1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    char[] tmp = new char[4 * n];
    for (int i = 0; i < 3 * n; i++) {
      Arrays.fill(tmp, '.');
      for (int j = 0; j < n; j++) {
        tmp[j] = '*';
        tmp[4 * n - 1 - j] = '*';
      }
      out.println(new String(tmp));
    }

    for (int i = 0; i < n; i++) {
      Arrays.fill(tmp, '.');

      for (int j = 0; j < n; j++) {
        tmp[i + j + 1] = '*';
        tmp[4 * n - 2 - i - j] = '*';
      }

      out.println(new String(tmp));
    }
  }
}
