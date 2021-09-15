package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author badpoone
 */
public class TreeView {
    //层级遍历二叉树
    public void traverse(TreeNode root){
        if(root==null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();

            //检验空指针
            if(cur==null) {
                continue;
            }
            /* 层级遍历代码位置 */
            System.out.println(root.val);

            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }
    }

}
