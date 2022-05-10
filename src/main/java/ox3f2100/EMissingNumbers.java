package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.List;

public class EMissingNumbers {
  int N = (int) (2e5 + 5);
  List<Integer>[] lists = new List[N];


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    //    for (int i = 0; i < N; i++) {
    //      lists[i] = new ArrayList<>();
    //    }

    //    for (int i = 1; i < N; i++) {
    //      for (int j = i; j < N; j += i) {
    //        lists[j].add(i);
    //      }
    //    }
    int n = in.nextInt();
    long[] a = new long[n + 1];
    for (int i = 2; i <= n; i += 2) {
      a[i] = in.nextInt();
    }
    long sum = 0;

    for (int i = 2; i <= n; i += 2) {
      //      for (Integer j : lists[(int) a[i]]) {
      for (int j = 1; j * j <= a[i]; j++) {
        if (a[i] % j == 0) {
          long x = j;
          long y = a[i] / j;

          if (x % 2 != y % 2 || x == y) {
            continue;
          }
          //          if (x >= y) {
          //            break;
          //          }
          long p = (y - x) / 2;
          if (sum < p * p) {
            a[i - 1] = p * p - sum;
          }
        }

      }
      if (a[i - 1] == 0) {
        out.println("No");
        return;
      }

      sum += a[i - 1] + a[i];
    }
    out.println("Yes");
    for (int i = 1; i <= n; i++) {
      out.print(a[i], "");
    }
  }
}
