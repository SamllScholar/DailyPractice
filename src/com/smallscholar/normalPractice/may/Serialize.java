package com.smallscholar.normalPractice.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/16 10:39
 * @describe 序列化与反序列化二叉树
 */
public class Serialize {

    String Serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        return root.val+","+Serialize(root.left)+","+Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        Queue<String> qu=new LinkedList<>(Arrays.asList(str.split(",")));
        return build(qu);
    }
    TreeNode build(Queue<String> qu){
        String val=qu.poll();
        if("null".equals(val)){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(val));
        root.left=build(qu);
        root.right=build(qu);
        return root;
    }

}
