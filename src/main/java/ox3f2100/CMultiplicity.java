package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CMultiplicity {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int N = (int) (1e6 + 5);
    int mod = (int) (1e9 + 7);
    int[] cnt = new int[N];
    int[] tmp = new int[N];
    cnt[0] = 1;
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 1; j * j <= a[i] && j <= i + 1; j++) {
        if (a[i] % j == 0) {
          int x = j;
          int y = a[i] / j;
          if (x != y) {
            if (cnt[x - 1] != 0) {
              tmp[x] = cnt[x - 1];
              tmp[x] %= mod;
              list.add(x);
            }
          }
          if (cnt[y - 1] != 0) {
            tmp[y] = cnt[y - 1];
            tmp[y] %= mod;
            list.add(y);
          }
        }
      }
      for (Integer integer : list) {
        cnt[integer] += tmp[integer];
        cnt[integer] %= mod;
      }
    }
    int res = 0;
    for (int i = 1; i < N; i++) {
      res += cnt[i];
      res %= mod;
    }
    out.println(res);
  }
}
