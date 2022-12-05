package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    Arrays.sort(a);
    if (a[0] == a[1] && a[1] == a[2]) {
      int j = 2;
      while (j + 1 < n && a[j + 1] == a[j]) {
        j++;
      }
      long len = j + 1;
      out.println((len) * (len - 1) * (len - 2) / 6);
    } else if (a[1] == a[2]) {
      int j = 1;
      while (j + 1 < n && a[j + 1] == a[j]) {
        j++;
      }
      long len = j + 1 - 1;
      out.println(len * (len - 1) / 2);
    } else {
      int j = 2;
      while (j + 1 < n && a[j + 1] == a[j]) {
        j++;
      }
      long len = j + 1 - 2;
      out.println(len);
    }
  }
}
