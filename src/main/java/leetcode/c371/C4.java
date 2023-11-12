package leetcode.c371;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  int n;

  public int maximumStrongPairXor(int[] nums) {
    n = nums.length;
    Arrays.sort(nums);
    TrieArray trieArray = new TrieArray(n);
    int j = 0;
    int res = 0;
    for (int i = 0; i < n; i++) {
      trieArray.insert(nums[i]);
      while (j < i && nums[i] - nums[j] > nums[j]) {
        trieArray.remove(nums[j]);
        j++;
      }
      res = Math.max(res, trieArray.query(nums[i]));
    }
    return res;

  }

  class TrieArray {
    public TrieArray(int n) {
      this.n = n * 21 + 5;
      son = new int[n][2];
      cnt = new int[n];
    }

    int n;
    int[][] son;
    int[] cnt;
    int idx = 0;

    void insert(int x) {
      int p = 0;
      for (int i = 20; i >= 0; i--) {
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
      for (int i = 20; i >= 0; i--) {
        int u = (x >> i) & 1;
        p = son[p][u];
        cnt[p]--;
      }
    }

    // 查询字符串出现的次数
    int query(int x) {
      int p = 0;
      int res = 0;
      for (int i = 20; i >= 0; i--) {
        int u = (x >> i & 1);
        if (cnt[son[p][u ^ 1]] != 0) {
          p = son[p][u ^ 1];
          res |= 1 << i;
        } else if (cnt[son[p][u]] != 0) {
          p = son[p][u];
        }
      }
      return res;
    }
  }
}
