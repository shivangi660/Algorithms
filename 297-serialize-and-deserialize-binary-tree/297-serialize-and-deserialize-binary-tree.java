/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // Serialization Steps
    //     1. for every node put it into queue.
    //     2. If node is null, append $ and continue
    //.    3. else append node.val and push left and right subtree nodes to queue.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                sb.append("$,");
                continue;
            }
            else{
                sb.append(node.val+",");
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // Deserialization Steps
    // Recur in array and start from i = 1;
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;
        String[] arr = data.split(",");
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        for(int i = 1;i < arr.length; i++){
            TreeNode node = queue.poll();
            if(!arr[i].equals("$")){
                TreeNode lnode = new TreeNode(Integer.parseInt(arr[i]));
                node.left = lnode;
                queue.add(lnode);
            }
            if(!arr[++i].equals("$")){
                TreeNode rnode = new TreeNode(Integer.parseInt(arr[i]));
                node.right = rnode;
                queue.add(rnode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));