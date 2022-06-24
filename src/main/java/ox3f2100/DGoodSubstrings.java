package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;


public class DGoodSubstrings {
  int ans = 0;

  void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    String t = in.nextString();
    int k = in.nextInt();
    int[] sum = new int[s.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      sum[i + 1] = sum[i] + (1 - (t.charAt(s.charAt(i) - 'a') - '0'));
    }
    TrieArray trie = new TrieArray();
    for (int i = 0; i < s.length(); i++) {
      trie.resetCur();
      for (int j = i; j < s.length(); j++) {
        if (sum[j + 1] - sum[i] <= k) {
          trie.insert(s.charAt(j) - 'a');
        } else {
          break;
        }
      }
    }
    out.println(ans);
  }

  class TrieArray {
    int n = 2250005;
    int[][] son = new int[n][26];
    int idx = 0;
    int cur = 0;

    void insert(int u) {
      if (son[cur][u] == 0) {
        son[cur][u] = ++idx;
        ans++;
      }
      cur = son[cur][u];
    }

    public void resetCur() {
      cur = 0;
    }

  }
}
