package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class E1SquareFreeDivisionEasyVersion {
  int N = (int) (1e7 + 5);
  List<Integer> prime = new ArrayList<>();
  int[] sieve = new int[N + 1];

  {
    sieve[1] = 1;
    for (int i = 2; i <= N; i++) {
      if (sieve[i] == 0) {
        sieve[i] = i;
        prime.add(i);
      }
      for (int j = 0; j < prime.size() && prime.get(j) <= sieve[i] && i * prime.get(j) <= N; j++) {
        sieve[i * prime.get(j)] = prime.get(j);
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      int j = i;
      Set<Integer> set = new HashSet<>();
      int t = helper(a[i]);
      set.add(t);
      while (j + 1 < n) {
        int x = helper(a[j + 1]);
        if (!set.contains(x)) {
          j++;
        } else {
          break;
        }
        set.add(x);
      }
      i = j;
      res++;
    }
    out.println(res);
  }

  private int helper(int t) {
    Map<Integer, Integer> map = new HashMap<>();
    while (t > 1) {
      map.put(sieve[t], map.getOrDefault(sieve[t], 0) + 1);
      t = t / sieve[t];
    }
    int res = 1;
    for (Integer integer : map.keySet()) {
      if (map.get(integer) % 2 == 1) {
        res *= integer;
      }
    }
    return res;
  }

}
