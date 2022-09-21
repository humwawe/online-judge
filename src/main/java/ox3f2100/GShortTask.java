package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class GShortTask {
  int N = (int) (1e7 + 5);
  long[] fc = new long[N + 1];
  long[] res = new long[N + 1];

  {

    fc[1] = 1;

    int[] pr = new int[N + 1];
    // sieve存每个数的最小质因子
    int[] sieve = new int[N + 1];
    int cnt = 0;


    for (int i = 2; i <= N; i++) {
      if (sieve[i] == 0) {
        sieve[i] = i;
        pr[cnt++] = i;
        fc[i] = i + 1;
      }
      // 给当前i乘一个质因子
      for (int j = 0; j < cnt && pr[j] <= N / i; j++) {
        sieve[i * pr[j]] = pr[j];
        if (pr[j] == sieve[i]) {
          fc[i * pr[j]] = fc[i] + (fc[i] - fc[i / pr[j]]) * pr[j];
          break;
        }
        fc[i * pr[j]] = fc[i] + fc[i] * pr[j];

      }
    }


    for (int i = 2; i < N; i++) {
      res[i] = -1;
    }
    res[1] = 1;
    for (int i = 2; i < N; i++) {
      if (fc[i] >= N) {
        continue;
      }
      if (res[(int) fc[i]] == -1) {
        res[(int) fc[i]] = i;
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int c = in.nextInt();
    out.println(res[c]);
  }
}
