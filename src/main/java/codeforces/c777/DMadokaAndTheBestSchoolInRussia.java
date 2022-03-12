package codeforces.c777;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;


public class DMadokaAndTheBestSchoolInRussia {
  long d;
  long t;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    d = in.nextInt();

    t = d * d;
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
        if (i * i != n) {
          list.add(n / i);
        }
      }
    }
    Collections.sort(list);
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    for (int i = 0; i < list.size(); i++) {
      if (!check(list.get(i))) {
        continue;
      }
      for (int j = i; j < list.size(); j++) {
        if (list.get(j) % list.get(i) == 0) {
          map.put(list.get(j), map.getOrDefault(list.get(j), 0) + map.getOrDefault(list.get(j) / list.get(i), 0));
        }
      }
    }
    if (map.getOrDefault(n, 0) >= 2) {
      out.println("YES");
    } else {
      out.println("NO");
    }

  }

  private boolean check(int i) {
    return i % d == 0 && i % t != 0;
  }


}
