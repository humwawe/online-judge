package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D2PrefixSuffixPalindromeHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    int i = 0;
    int j = len - 1;
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        break;
      }
    }
    if (i == j || i - 1 == j) {
      out.println(s);
      return;
    }

    String str = s.substring(i, j + 1);

    manacher(str.toCharArray());
    int max = 0;
    int dir = -1;
    for (int k = 1; k < 2 * str.length() + 2; k++) {
      int l = mp[k] - 1;
      if (k - l == 1) {
        if (l > max) {
          max = l;
          dir = 0;
        }
      }
      if (2 * str.length() + 2 - k - 1 == l) {
        if (l > max) {
          max = l;
          dir = 1;
        }
      }
    }
    if (dir == 0) {
      out.print(s.substring(0, i));
      out.print(s.substring(i, i + max));
      out.print(s.substring(j + 1));
    } else {
      out.print(s.substring(0, i));
      out.print(s.substring(j + 1 - max));
    }
    out.println();

  }

  int[] ma, mp;


  void manacher(char s[]) {
    int N = s.length;
    ma = new int[N * 2 + 5];
    mp = new int[N * 2 + 5];
    int l = 0;
    ma[l++] = '$';
    ma[l++] = '#';
    for (char c : s) {
      ma[l++] = c;
      ma[l++] = '#';
    }

    mp[0] = 1;
    int mx = 0, id = 0;
    for (int i = 1; i < l; i++) {
      mp[i] = mx > i ? Math.min(mp[2 * id - i], mx - i) : 1;
      // 如果没有哨兵，比如求奇数回文串，可以直接在原串上处理，需要保证 i - mp[i] >= 0 && i + mp[i] < size
      while (ma[i + mp[i]] == ma[i - mp[i]]) {
        mp[i]++;
      }
      if (i + mp[i] > mx) {
        mx = i + mp[i];
        id = i;
      }
    }
  }
}


