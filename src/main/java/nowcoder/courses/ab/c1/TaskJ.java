package nowcoder.courses.ab.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskJ {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int res = 0;
    int[] a = in.nextInt(n);
    Arrays.sort(a);
    for (int i = n - 1; i > 0; i -= 2) {
      res ^= a[i] - a[i - 1] - 1;
    }
    if (n % 2 == 1) {
      res ^= a[0] - 1;
    }

    if (res != 0) {
      out.println("Georgia will win");
    } else {
      out.println("Bob will win");
    }
  }
}
