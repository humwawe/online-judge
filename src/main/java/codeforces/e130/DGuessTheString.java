package codeforces.e130;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DGuessTheString {
  int n;
  Map<Integer, Integer> map = new HashMap<>();
  InputReader in;
  OutputWriter out;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    this.out = out;
    n = in.nextInt();
    int s = 0;
    int[] str = new int[n];
    int[] tmp = new int[26];
    List<Integer> list = new ArrayList<>();
    str[0] = s++;
    tmp[str[0]] = 0;
    list.add(0);
    for (int i = 1; i < n; i++) {
      int x = query(2, list.get(0), i);
      int y = query(2, list.get(0), i - 1);
      if (x == y + 1) {
        str[i] = s++;
      } else {
        int l = 0;
        int r = s - 1;
        while (l < r) {
          int mid = l + r + 1 >> 1;
          int q1 = query(2, list.get(mid), i);
          if (q1 == s - mid + 1) {
            r = mid - 1;
          } else {
            l = mid;
          }
        }
        str[i] = str[list.get(l)];
      }
      tmp[str[i]] = i;
      list.clear();
      for (int j = 0; j < s; j++) {
        list.add(tmp[j]);
      }
      Collections.sort(list);
    }
    char[] m = new char[26];
    for (int i = 0; i < s; i++) {
      char x = query(1, tmp[i]);
      m[i] = x;
    }
    guess(str, m);
  }

  private void guess(int[] str, char[] m) {
    out.print("!", "");
    for (int i = 0; i < n; i++) {
      out.print(m[str[i]]);
    }
    out.println();
    out.flush();

  }

  private char query(int t, int i) {

    out.println("?", t, i + 1);
    out.flush();
    return in.nextCharacter();
  }

  private int query(int t, int l, int r) {
    l++;
    r++;
    int key = l * 1005 + r;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    out.println("?", t, l, r);
    out.flush();

    int x = in.nextInt();
    map.put(key, x);
    return x;
  }
}
