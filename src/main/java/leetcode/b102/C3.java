package leetcode.b102;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {

  Map<Integer, Integer> map = new HashMap<>();
  Map<TreeNode, Integer> map2 = new HashMap<>();

  public TreeNode replaceValueInTree(TreeNode root) {
    dfs(root, 1);
    dfs2(root, root, 1);
    root.val = 0;
    return root;
  }

  private void dfs2(TreeNode root, TreeNode p, int dep) {
    if (root == null) {
      return;
    }

    root.val = map.get(dep) - map2.get(p);
    dfs2(root.left, root, dep + 1);
    dfs2(root.right, root, dep + 1);

  }

  private void dfs(TreeNode root, int dep) {
    if (root == null) {
      return;
    }
    map.merge(dep, root.val, Integer::sum);
    int sum = 0;
    sum += root.left != null ? root.left.val : 0;
    sum += root.right != null ? root.right.val : 0;
    map2.merge(root, sum, Integer::sum);
    dfs(root.left, dep + 1);
    dfs(root.right, dep + 1);
  }
}
