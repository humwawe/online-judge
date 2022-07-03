package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DVasiliysMultiset {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    insert(0);
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      char t = in.nextCharacter();
      int x = in.nextInt();
      if (t == '+') {
        insert(x);
      } else if (t == '-') {
        remove(x);
      } else {
        int query = query(x);
        out.println(query);
      }
    }
  }

  int N = (int) (6e6 + 5);
  int[][] son = new int[N][2];
  int[] cnt = new int[N];
  int idx = 0;

  void insert(int x) {
    int p = 0;
    for (int i = 30; i >= 0; i--) {
      int u = (x >> i) & 1;
      if (son[p][u] == 0) {
        son[p][u] = ++idx;
      }
      p = son[p][u];
      cnt[p]++;
    }
  }

  void remove(int x) {
    int p = 0;
    for (int i = 30; i >= 0; i--) {
      int u = (x >> i) & 1;
      p = son[p][u];
      cnt[p]--;
    }
  }

  int query(int x) {
    int p = 0;
    int max = 0;
    for (int i = 30; i >= 0; i--) {
      int u = (x >> i) & 1;
      if (cnt[son[p][u ^ 1]] > 0) {
        p = son[p][u ^ 1];
        max |= 1 << i;
      } else {
        p = son[p][u];
      }
    }
    return max;
  }
}
