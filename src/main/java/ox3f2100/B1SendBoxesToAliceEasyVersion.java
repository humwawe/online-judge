package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class B1SendBoxesToAliceEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    List<Integer> list = new ArrayList<>();
    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == 1) {
        list.add(i);
      }
      sum[i + 1] = sum[i] + a[i];
    }
    long res = (long) 1e15;
    for (int k = 1; k * k <= sum[n]; k++) {
      if (sum[n] % k == 0) {
        long tmp = 0;
        int t1 = k;
        int t2 = sum[n] / k;
        if (t1 != 1) {
          for (int i = 0; i < list.size(); i += t1) {
            int mid = list.get((i + t1 + i - 1) / 2);
            for (int j = i; j < i + t1; j++) {
              tmp += Math.abs(list.get(j) - mid);
            }
          }
          res = Math.min(res, tmp);
        }
        if (t2 != 1) {
          tmp = 0;
          for (int i = 0; i < list.size(); i += t2) {
            int mid = list.get((i + t2 + i - 1) / 2);
            for (int j = i; j < i + t2; j++) {
              tmp += Math.abs(list.get(j) - mid);
            }
          }
          res = Math.min(res, tmp);
        }
      }
    }
    out.println(res == (long) 1e15 ? -1 : res);
  }
}
