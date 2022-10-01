package acwing.contest.weekly.c71;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {
  int j = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long t = in.nextLong();
    int[] a = new int[n];
    long sum = 0;
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      idx[i] = i;
      sum += a[i];
    }
    Arrays.sort(idx, (x, y) -> a[y] - a[x]);
    long res = 0;
    LST vis = new LST(n);
    vis.setRange(n);
    int cnt = n;
    while (true) {
      List<Integer> list = helper(a, idx, t);
      for (Integer integer : list) {
        sum -= a[integer];
        vis.unset(integer);
      }
      cnt -= list.size();
      boolean f = false;
      if (sum != 0 && t >= sum) {
        long x = t / sum;
        res += x * cnt;
        t = t % sum;
        f = true;
      } else {
        for (int i = vis.next(0); i != -1; i = vis.next(i + 1)) {
          if (t >= a[i]) {
            t -= a[i];
            res++;
            f = true;
          }
        }
      }
      if (!f) {
        break;
      }


    }
    out.println(res);

  }

  private List<Integer> helper(int[] a, Integer[] idx, long t) {
    List<Integer> res = new ArrayList<>();
    while (j < a.length && a[idx[j]] > t) {
      res.add(idx[j]);
      j++;
    }
    return res;
  }

  class LST {
    public long[][] set;
    public int n;
    //	public int size;

    public LST(int n) {
      this.n = n;
      int d = 1;
      for (int m = n; m > 1; m >>>= 6, d++) {
      }

      set = new long[d][];
      for (int i = 0, m = n >>> 6; i < d; i++, m >>>= 6) {
        set[i] = new long[m + 1];
      }
      //		size = 0;
    }

    // [0,r)
    public LST setRange(int r) {
      for (int i = 0; i < set.length; i++, r = r + 63 >>> 6) {
        for (int j = 0; j < r >>> 6; j++) {
          set[i][j] = -1L;
        }
        if ((r & 63) != 0) {
          set[i][r >>> 6] |= (1L << r) - 1;
        }
      }
      return this;
    }

    // [0,r)
    public LST unsetRange(int r) {
      if (r >= 0) {
        for (int i = 0; i < set.length; i++, r = r + 63 >>> 6) {
          for (int j = 0; j < r + 63 >>> 6; j++) {
            set[i][j] = 0;
          }
          if ((r & 63) != 0) {
            set[i][r >>> 6] &= -(1L << r);
          }
        }
      }
      return this;
    }

    public LST set(int pos) {
      if (pos >= 0 && pos < n) {
        //			if(!get(pos))size++;
        for (int i = 0; i < set.length; i++, pos >>>= 6) {
          set[i][pos >>> 6] |= 1L << pos;
        }
      }
      return this;
    }

    public LST unset(int pos) {
      if (pos >= 0 && pos < n) {
        //			if(get(pos))size--;
        for (int i = 0; i < set.length && (i == 0 || set[i - 1][pos] == 0L); i++, pos >>>= 6) {
          set[i][pos >>> 6] &= ~(1L << pos);
        }
      }
      return this;
    }

    public boolean get(int pos) {
      return pos >= 0 && pos < n && set[0][pos >>> 6] << ~pos < 0;
    }

    public LST toggle(int pos) {
      return get(pos) ? unset(pos) : set(pos);
    }

    public int prev(int pos) {
      for (int i = 0; i < set.length && pos >= 0; i++, pos >>>= 6, pos--) {
        int pre = prev(set[i][pos >>> 6], pos & 63);
        if (pre != -1) {
          pos = pos >>> 6 << 6 | pre;
          while (i > 0) {
            pos = pos << 6 | 63 - Long.numberOfLeadingZeros(set[--i][pos]);
          }
          return pos;
        }
      }
      return -1;
    }

    public int next(int pos) {
      for (int i = 0; i < set.length && pos >>> 6 < set[i].length; i++, pos >>>= 6, pos++) {
        int nex = next(set[i][pos >>> 6], pos & 63);
        if (nex != -1) {
          pos = pos >>> 6 << 6 | nex;
          while (i > 0) {
            pos = pos << 6 | Long.numberOfTrailingZeros(set[--i][pos]);
          }
          return pos;
        }
      }
      return -1;
    }

    private int prev(long set, int n) {
      long h = set << ~n;
      if (h == 0L) {
        return -1;
      }
      return -Long.numberOfLeadingZeros(h) + n;
    }

    private int next(long set, int n) {
      long h = set >>> n;
      if (h == 0L) {
        return -1;
      }
      return Long.numberOfTrailingZeros(h) + n;
    }

    @Override
    public String toString() {
      java.util.List<Integer> list = new ArrayList<>();
      for (int pos = next(0); pos != -1; pos = next(pos + 1)) {
        list.add(pos);
      }
      return list.toString();
    }
  }
}
