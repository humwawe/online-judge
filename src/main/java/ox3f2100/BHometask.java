package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BHometask {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] cnt = new int[3];
    boolean f0 = false;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == 0) {
        f0 = true;
      }
      cnt[a[i] % 3]++;
    }
    if (!f0) {
      out.println(-1);
      return;
    }
    Arrays.sort(a);
    StringBuilder sb = new StringBuilder();
    int t = (cnt[1] + cnt[2] * 2) % 3;
    if (t == 0) {
      for (int i = n - 1; i >= 0; i--) {
        sb.append(a[i]);
      }
      if (sb.charAt(0) == sb.charAt(sb.length() - 1) && sb.charAt(0) == '0') {
        out.println(0);
      } else {
        out.println(sb.toString());
      }
      return;
    }

    if (t == 1) {
      if (cnt[1] == 0) {
        if (cnt[2] < 2) {
          out.println(-1);
          return;
        }
        int r1 = -1;
        int r2 = -1;
        for (int i = 0; i < n; i++) {
          if (a[i] % 3 == 2) {
            if (r1 == -1) {
              r1 = i;
            } else {
              r2 = i;
            }
            if (r2 != -1) {
              break;
            }
          }
        }
        for (int i = n - 1; i >= 0; i--) {
          if (i == r1 || i == r2) {
            continue;
          }
          sb.append(a[i]);
        }

        if (sb.charAt(0) == sb.charAt(sb.length() - 1) && sb.charAt(0) == '0') {
          out.println(0);
        } else {
          out.println(sb.toString());
        }


      } else {
        int ri = -1;
        for (int i = 0; i < n; i++) {
          if (a[i] % 3 == t) {
            ri = i;
            break;
          }
        }
        for (int i = n - 1; i >= 0; i--) {
          if (i == ri) {
            continue;
          }
          sb.append(a[i]);
        }
        if (sb.charAt(0) == sb.charAt(sb.length() - 1) && sb.charAt(0) == '0') {
          out.println(0);
        } else {
          out.println(sb.toString());
        }
      }
    }
    if (t == 2) {
      if (cnt[2] == 0) {
        int r1 = -1;
        int r2 = -1;
        for (int i = 0; i < n; i++) {
          if (a[i] % 3 == 1) {
            if (r1 == -1) {
              r1 = i;
            } else {
              r2 = i;
            }
            if (r2 != -1) {
              break;
            }
          }
        }
        for (int i = n - 1; i >= 0; i--) {
          if (i == r1 || i == r2) {
            continue;
          }
          sb.append(a[i]);
        }
        if (sb.charAt(0) == sb.charAt(sb.length() - 1) && sb.charAt(0) == '0') {
          out.println(0);
        } else {
          out.println(sb.toString());
        }
      } else {
        int ri = -1;
        for (int i = 0; i < n; i++) {
          if (a[i] % 3 == t) {
            ri = i;
            break;
          }
        }
        for (int i = n - 1; i >= 0; i--) {
          if (i == ri) {
            continue;
          }
          sb.append(a[i]);
        }
        if (sb.charAt(0) == sb.charAt(sb.length() - 1) && sb.charAt(0) == '0') {
          out.println(0);
        } else {
          out.println(sb.toString());
        }
      }
    }


  }
}
