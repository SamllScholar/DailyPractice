package com.smallscholar.normalPractice.may;

import sun.awt.geom.AreaOp;

import java.util.*;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/16 11:12
 * @describe 通过一个二叉树的先序遍历和中序遍历得到一个二叉树的右视图
 */
public class RightView {

    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode root = reConstructBinaryTree(xianxu, zhongxu);
        ArrayList<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;

    }

    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        for(int i=0;i<vin.length;i++){
            map.put(vin[i],i);
        }
        return build(pre,0,pre.length,vin,0,vin.length);
    }
    public TreeNode build(int[] pre,int preStart,int preEnd,int[] vin,int vinStart,int vinEnd){
        if(preStart>=preEnd||vinStart>=vinEnd){
            return null;
        }
        int rootIndex=map.get(pre[preStart]);
        TreeNode root=new TreeNode(vin[rootIndex]);
        int leftValue=rootIndex-vinStart;
        //处理左右
        //pre 头左右 //vin 左头右
        root.left=build(pre,preStart+1,preStart+1+leftValue,vin,vinStart,rootIndex);
        root.right=build(pre,preStart+1+leftValue,preEnd,vin,rootIndex+1,vinEnd);
        return root;

    }

}
