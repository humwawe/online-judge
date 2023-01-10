package codeforces.c843;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BGardenerAndTheArray {
  int N = (int) (2e5 + 5);
  int[] cnt = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    boolean res = false;
    List<Integer>[] lists = new List[n];
    Arrays.setAll(lists, e -> new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        int x = in.nextInt();
        cnt[x]++;
        lists[i].add(x);
      }
    }
    for (int i = 0; i < n; i++) {
      boolean f = true;
      for (Integer x : lists[i]) {
        cnt[x]--;
        if (cnt[x] <= 0) {
          f = false;
        }
      }

      res |= f;
      for (Integer x : lists[i]) {
        cnt[x]++;
      }
    }

    for (int i = 0; i < n; i++) {
      boolean f = true;
      for (Integer x : lists[i]) {
        cnt[x]--;
      }
    }


    if (res) {
      out.println("Yes");
    } else {
      out.println("No");
    }
  }
}
