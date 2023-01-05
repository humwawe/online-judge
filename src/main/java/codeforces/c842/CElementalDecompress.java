package codeforces.c842;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class CElementalDecompress {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] cnt = new int[n];
    List<Integer>[] lists = new List[n];
    Arrays.setAll(lists, e -> new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int x = in.nextInt() - 1;
      a[i] = x;
      cnt[x]++;
      lists[x].add(i);
    }

    for (int i = 0; i < n; i++) {
      if (cnt[i] > 2) {
        out.println("NO");
        return;
      }
    }

    int[] res1 = new int[n];
    int[] res2 = new int[n];

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) {
      if (cnt[i] == 2) {
        res1[lists[i].get(0)] = i + 1;
        res2[lists[i].get(1)] = i + 1;
        queue.add(lists[i].get(0));
        queue.add(lists[i].get(1));
      } else if (cnt[i] == 1) {
        res1[lists[i].get(0)] = i + 1;
        res2[lists[i].get(0)] = i + 1;
      } else {
        if (queue.size() < 2) {
          out.println("NO");
          return;
        }
        res2[queue.poll()] = i + 1;
        res1[queue.poll()] = i + 1;
      }
    }
    out.println("YES");
    out.println(res1);
    out.println(res2);

  }
}
