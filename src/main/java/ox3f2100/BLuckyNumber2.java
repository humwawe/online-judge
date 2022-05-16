package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BLuckyNumber2 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int c1 = in.nextInt();
    int c2 = in.nextInt();
    int c3 = in.nextInt();
    int c4 = in.nextInt();
    if (Math.abs(c3 - c4) > 1) {
      out.println(-1);
      return;
    }
    StringBuilder sb = new StringBuilder();
    boolean f = true;

    sb.append("47".repeat(c3));
    int t4 = c4 - (c3 - 1);
    int t1 = c1 - c3;
    int t2 = c2 - c3;
    if (t4 == 1) {
      if (t1 > 0) {
        sb.append("4");
        t1--;
      } else if (t2 > 0) {
        sb.insert(0, "7");
        t2--;
      } else {
        f = false;
      }
    }
    if (t4 > 1 || t1 < 0 || t2 < 0) {
      f = false;
    }
    if (t1 > 0) {
      for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == '4') {
          sb.insert(i, "4".repeat(t1));
          break;
        }
      }
    }

    if (t2 > 0) {
      for (int i = sb.length() - 1; i >= 0; i--) {
        if (sb.charAt(i) == '7') {
          sb.insert(i, "7".repeat(t2));
          break;
        }
      }
    }


    if (f) {
      out.println(sb.toString());
      return;
    }

    f = true;
    sb = new StringBuilder();
    sb.append("74".repeat(c4));
    int t3 = c3 - (c4 - 1);
    t1 = c1 - c4;
    t2 = c2 - c4;
    if (t3 == 1) {
      if (t1 > 0) {
        sb.append("4");
        t1--;
      } else if (t2 > 0) {
        sb.insert(0, "7");
        t2--;
      } else {
        f = false;
      }
    }
    if (t3 > 1 || t1 < 0 || t2 < 0) {
      f = false;
    }
    if (t1 > 0) {
      for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == '4') {
          sb.insert(i, "4".repeat(t1));
          break;
        }
      }
    }

    if (t2 > 0) {
      for (int i = sb.length() - 1; i >= 0; i--) {
        if (sb.charAt(i) == '7') {
          sb.insert(i, "7".repeat(t2));
          break;
        }
      }
    }


    if (f) {
      out.println(sb.toString());
      return;
    }

    out.println(-1);

  }
}
