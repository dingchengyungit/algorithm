package com.dcy.tree;

/**
 * @author dingchengyun
 * @date 2023/2/13
 * @description 删除节点
 * 如果当前节点是叶子节点，直接删除
 * 如果当前节点是非叶子节点，则删除该子树
 */
public class TreeNodeDelete {

    public static void main(String[] args) {
//               1;
//        11,         12;
//        111 112,   121,122
        TreeNode t = new TreeNode();
        t.id = 1;

        TreeNode t11 = new TreeNode();
        t11.id = 11;
        TreeNode t12 = new TreeNode();
        t12.id = 12;

        TreeNode t111 = new TreeNode();
        t111.id = 111;
        TreeNode t112 = new TreeNode();
        t112.id = 112;

        TreeNode t121 = new TreeNode();
        t121.id = 121;
        TreeNode t122 = new TreeNode();
        t122.id = 122;

        t.left = t11;
        t.right = t12;

        t11.left = t111;
        t11.right = t112;

        t12.left = t121;
        t12.right = t122;

        delete(t, 112);
        System.out.println("preFind=" + t.id + "-----------------");
//
    }

    /**
     * 删除
     * 1. 左子节点不为空且是目标节点，this.left = null，返回
     * 2. 右子节点不为空且是是目标，this.right = null，返回
     * 3. 递归左子节点
     * 4. 递归右子节点
     */
    public static void delete(TreeNode tree, int id) {

        System.out.println(tree.id);

        TreeNode left = tree.left;
        if (left != null && left.id == id) {
            tree.left = null;
            return;
        }

        TreeNode right = tree.right;
        if (right != null && right.id == id ) {
            tree.right = null;
            return;
        }

        if (left != null) {
            delete(left, id);
        }
        if (right != null) {
            delete(right, id);
        }
    }

}
