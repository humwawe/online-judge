package leetcode.c340;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class C4 {
  public int minimumVisitedCells(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> queue = new ArrayDeque<>();

    LST[] row = new LST[n];
    for (int i = 0; i < n; i++) {
      row[i] = new LST(m);
      row[i].setRange(m);
    }
    LST[] col = new LST[m];
    for (int i = 0; i < m; i++) {
      col[i] = new LST(n);
      col[i].setRange(n);
    }

    row[0].unset(0);
    col[0].unset(0);

    queue.add(new int[]{0, 0});
    int[][] dist = new int[n][m];
    int inf = (int) 1e8;
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], inf);
    }
    dist[0][0] = 1;
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int i = poll[0];
      int j = poll[1];
      for (int k = row[i].next(j + 1); k <= Math.min(grid[i][j] + j, m - 1) && k != -1; k = row[i].next(k)) {
        dist[i][k] = dist[i][j] + 1;
        queue.add(new int[]{i, k});
        row[i].unset(k);
        col[k].unset(i);
      }

      for (int k = col[j].next(i + 1); k <= Math.min(grid[i][j] + i, n - 1) && k != -1; k = col[j].next(k)) {
        dist[k][j] = dist[i][j] + 1;
        queue.add(new int[]{k, j});
        col[j].unset(k);
        row[k].unset(j);
      }
    }

    return dist[n - 1][m - 1] == inf ? -1 : dist[n - 1][m - 1];
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
