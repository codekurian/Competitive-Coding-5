//https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Problem1 {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();
        dfsHelper(root,0,this.result);
        return this.result;
    }

    //TC:O(N)
    //SC:O(N)
    void dfsHelper(TreeNode node , int level, List<Integer> result){
        if(node == null){
            return;
        }
        if(result.size() == level){
            result.add(node.val);
        }else{
            int storedVal = result.get(level);
            storedVal = Math.max(storedVal,node.val);
            result.set(level,storedVal);
        }
        dfsHelper(node.left,level+1,result);
        dfsHelper(node.right,level+1,result);
    }

    //by BFS
    //TC:O(N)
    //SC:O(N/2) = O(N)
    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int level = q.size();
            int maxNum = Integer.MIN_VALUE;
            for(int i=0;i<level;i++){
                TreeNode curr = q.poll();
                maxNum = Math.max(maxNum,curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                }

            }
            result.add(maxNum);
        }
        return result;
    }
}
