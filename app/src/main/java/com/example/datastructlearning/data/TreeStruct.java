package com.example.datastructlearning.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数据结构中  树 的操作
 * <p>
 * 树的操作 一般包括   前序遍历   中序遍历   后序遍历   层次遍历
 */
public class TreeStruct {

    boolean ans = true;

    public class TreeNode {
        //节点值
        int val = 0;
        //左子树
        TreeNode left = null;
        //右子树
        TreeNode right = null;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 前序遍历
     * （1）遍历根节点
     * （2）左子树
     * （3）右子树
     */
    public void preOrder(TreeNode root, List<Integer> ans) {
        //边界处理 如果树为空，那么不需要处理
        if (root != null) {
            //访问根节点
            ans.add(root.val);
            //再分别访问左子树
            preOrder(root.left, ans);
            //再访问右子树
            preOrder(root.left, ans);
        }
    }

    /**
     * 使用栈来实现 树的前序遍历
     */
    public List<Integer> preOrderStack(TreeNode root) {
        //用来递归的栈
        Stack<TreeNode> s = new Stack<>();
        //用来存放遍历的结果 不算在空间复杂度上面
        List<Integer> ans = new ArrayList<>();
        //开始用 栈来进行遍历
        while (root != null || !s.empty()) {
            //模拟递归压栈过程
            while (root != null) {
                s.push(root);
                ans.add(root.val);
                root = root.left;
            }
            //当无法 压栈的时候 ，将 root.right进行压栈
            root = s.peek();
            s.pop();
            root = root.right;
        }
        return ans;
    }

    /**
     * 二叉 搜索树 的验证
     * 跟节点大于左孩子节点   小于右孩子节点
     */

    /**
     * 判断一颗树  是否为二叉搜索树
     */
    /******************************************************************/
    public void preOrder(TreeNode root, Long l, Long r) {

        //如果为空树
        //如果已经有节点不满足BST的需求
        if (root == null || !ans) {
            return;
        }
        if (!(l < root.val && root.val < r)) {
            ans = false;
            return;
        }
        //同时遍历左子树
        preOrder(root.left, l, Long.valueOf(root.val));
        //同时遍历 右子树
        preOrder(root.right, Long.valueOf(root.val), r);
    }

    public boolean isValidBST(TreeNode root) {
        ans = true;
        preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
    /*****************************************************************/


    /**
     * 中序遍历
     */
    public void  preOrderShow(TreeNode root ,List<Integer> ans){
        if ( root!=null){
            //先遍历左子树
            preOrder(root.left,ans);
            //遍历中间 的根节点
            ans.add(root.val);
            //最后遍历右子树
            preOrder(root.right,ans);
        }
    }

    /**
     * 后序遍历
     */
    void  postOrder(TreeNode root,List<Integer> ans){
        if (root!=null){
            //先遍历 左子树
            postOrder(root.left,ans);
            //最后遍历右子树
            postOrder(root.right,ans);
            //遍历中间的跟节点
            ans.add(root.val);
        }

    }

}
