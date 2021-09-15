package 剑指offer;


/**
 * @author badpoone
 * 根据而二叉树中序和后序遍历构建二叉树
 */
public class BildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    public TreeNode build(int[]inorder,int inStart,int inEnd,
                          int [] postorder,int postStart, int postEnd) {
        if(inStart>inEnd){
            return  null;
        }

        //后序遍历 root对应值为最后一个元素
        int rootVal = postorder[postEnd];
        int index = 0;
        //中序遍历的索引
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                index = i;
                break;
            }
        }

        int leftSize=index-inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left=build(inorder,inStart,index-1,postorder,postEnd,postEnd+leftSize-1);
        root.right=build(inorder,index+1,inEnd,postorder,leftSize,postEnd-1);
        return root;
    }


}
