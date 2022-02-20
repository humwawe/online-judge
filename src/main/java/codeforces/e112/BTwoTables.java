package codeforces.e112;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BTwoTables {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int W = in.nextInt();
    int H = in.nextInt();
    int x1 = in.nextInt();
    int y1 = in.nextInt();
    int x2 = in.nextInt();
    int y2 = in.nextInt();

    int w = in.nextInt();
    int h = in.nextInt();
    int inf = (int) 1e9;
    int res = inf;

    if (y1 >= h) {
      out.println(0);
      return;
    } else if (h + y2 - y1 <= H) {
      res = Math.min(res, h - y1);
    }

    if (x1 >= w) {
      out.println(0);
      return;
    } else if (w + x2 - x1 <= W) {
      res = Math.min(res, w - x1);
    }

    if (H - y2 >= h) {
      out.println(0.0);
      return;
    } else if (h + y2 - y1 <= H) {
      res = Math.min(res, h - (H - y2));
    }

    if (W - x2 >= w) {
      out.println(0);
      return;
    } else if (w + x2 - x1 <= W) {
      res = Math.min(res, w - (W - x2));
    }
    if (res == inf) {
      out.println(-1);
    } else {
      out.println(res);
    }
  }
}
