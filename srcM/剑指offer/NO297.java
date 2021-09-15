package 剑指offer;

import cn.hutool.core.lang.tree.Tree;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author badpoone
 */
public class NO297 {
    //二叉树序列化成字符串

    StringBuilder subTree = new StringBuilder();
    String NULL = "#";
    String SEP = ",";
    public  String  serialize(TreeNode root){
        traverse(root);
        return  subTree.toString();
    }
    //字符串反序列化二叉树
    public TreeNode deserialize2(String data){
        LinkedList<String> nodes = new LinkedList<>();
        for(String s: data.split(SEP)){
            nodes.add(s);
        }
        return deserialize(nodes);
    }


    public void traverse(TreeNode root){
        if(root==null){
            subTree.append(NULL);
            return;
        }
        traverse(root.left);
        traverse(root.right);
        subTree.append(root.val).append(SEP);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
     public TreeNode deserialize(LinkedList<String> nodes){
        if (nodes==null) {
            return  null;
        }
        String last =  nodes.removeLast();
        if(last.equals(NULL)) {
            return null;
        }
         //parseInt 返回整数  可以用valueOf替代
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);
        return root;
    }

    /**
     * 层级遍历序列化
     * @param root
     * @return
     */
    String serialize2(TreeNode root){
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            /*****************/

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    /* 将字符串反序列化为二叉树结构 */
    TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < nodes.length; ) {
            // 队列中存的都是父节点
            TreeNode parent = q.poll();
            // 父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null;
            }
            // 父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }


}
