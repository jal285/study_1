package 剑指offer;

import cn.hutool.core.lang.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author badpoone
 * NO.652
 */
public class findDuplicateSubTrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }

    /**
     *
     * @param root
     * @return 树节点数
     *
     */
    int count(TreeNode root){
        if(root == null){
            return 0;
        }
        //先算出右子树有多少节点
        int left = count(root.left);
        int right = count(root.right);
        /* 后序遍历代码位置 */
        //加上自己, 就是整颗二叉树的节点数
        int res = left + right + 1;
        return res;
    }

    //记录所有子树 hashSet 改为hashMap,额外记录没课子树出现次数
    HashMap<String,Integer> memo = new HashMap();
    //记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    /**
     *
     * @param root
     * @return 一颗二叉树的样子
     */
    String traverse(TreeNode root){
        //空节点用特殊字符表示
        if(root==null){
            return  "#";
        }
        //左右子树序列化成字符串
        String left = traverse(root.left);
        String right = traverse(root.right);
        /* 后续遍历代码位置 */
        //左右子树加上自己就是以自己为根的二叉树序列化结果
        String subTree = left+","+right+","+root;

        int freq = memo.getOrDefault(subTree, 0);
        //多次重复也只会加入结果集一次
        if (freq==1){
            //有人和我重复,把自己加入结果列表
            res.add(root);
        }
        //给子树对应的出现次数加一
        memo.put(subTree,freq+1);
        return subTree;

    }




}
