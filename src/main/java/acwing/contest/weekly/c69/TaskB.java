package acwing.contest.weekly.c69;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int n, a, b, k;
  String s;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = in.nextInt();
    b = in.nextInt();
    k = in.nextInt();
    s = in.nextString();
    char[] os = s.toCharArray();
    int cnt = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (os[i] == '1') {
        sum += cnt / b;
        cnt = 0;
      } else {
        cnt++;
      }
    }
    sum += cnt / b;
    int res = sum - a + 1;
    out.println(res);

    s = "1" + s + "1";

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        int j = i;
        while (j + 1 < s.length() && s.charAt(j + 1) == '0') {
          j++;
        }
        int len = j - i;
        if (len >= b) {
          for (int l = i + b; l <= j && res-- > 0; l += b) {
            out.print(l, "");
          }
        }
        i = j;
      }
    }

  }


}
