package com.smallscholar.normalPractice.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/16 10:43
 * @describe 重建二叉树
 */
public class ReConstructBinaryTree {

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
