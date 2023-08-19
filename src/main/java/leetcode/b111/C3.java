package leetcode.b111;

import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public int minimumOperations(List<Integer> nums) {
    int n = nums.size();
    int res = 105;
    int t = 0;
    for (int i = 0; i < n; i++) {
      if (nums.get(i) != 1) {
        t++;
      }
    }
    res = Math.min(res, t);

    t = 0;
    for (int i = 0; i < n; i++) {
      if (nums.get(i) != 2) {
        t++;
      }
    }
    res = Math.min(res, t);
    t = 0;
    for (int i = 0; i < n; i++) {
      if (nums.get(i) != 3) {
        t++;
      }
    }
    res = Math.min(res, t);


    for (int i = 0; i < n; i++) {
      t = 0;
      for (int j = 0; j < n; j++) {
        if (j < i) {
          if (nums.get(j) != 1) {
            t++;
          }
        } else {
          if (nums.get(j) != 2) {
            t++;
          }
        }
      }
      res = Math.min(res, t);
    }


    for (int i = 0; i < n; i++) {
      t = 0;
      for (int j = 0; j < n; j++) {
        if (j < i) {
          if (nums.get(j) != 1) {
            t++;
          }
        } else {
          if (nums.get(j) != 3) {
            t++;
          }
        }
      }
      res = Math.min(res, t);
    }


    for (int i = 0; i < n; i++) {
      t = 0;
      for (int j = 0; j < n; j++) {
        if (j < i) {
          if (nums.get(j) != 2) {
            t++;
          }
        } else {
          if (nums.get(j) != 3) {
            t++;
          }
        }
      }
      res = Math.min(res, t);
    }


    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        t = 0;
        for (int k = 0; k < n; k++) {
          if (k < i) {
            if (nums.get(k) != 1) {
              t++;
            }
          } else if (k > j) {
            if (nums.get(k) != 3) {
              t++;
            }
          } else {
            if (nums.get(k) != 2) {
              t++;
            }
          }
        }
        res = Math.min(res, t);
      }
    }
    return res;
  }
}
