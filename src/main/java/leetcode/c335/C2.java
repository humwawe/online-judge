package leetcode.c335;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C2 {
  Map<Integer, Long> map = new HashMap<>();

  public long kthLargestLevelSum(TreeNode root, int k) {
    dfs(root, 1);
    List<Long> values = new ArrayList<>(map.values());
    values.sort((x, y) -> Long.compare(y, x));
    k--;
    return values.size() <= k ? -1 : values.get(k);
  }

  private void dfs(TreeNode root, int i) {
    if (root == null) {
      return;
    }
    map.put(i, map.getOrDefault(i, 0L) + root.val);
    dfs(root.left, i + 1);
    dfs(root.right, i + 1);
  }
}
