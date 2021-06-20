import java.util.*;

public class BinaryTreeUtil {

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int value) {
            this.left = new BinaryTreeNode(value);
            return this.left;
        }

        public BinaryTreeNode insertRight(int value) {
            this.right = new BinaryTreeNode(value);
            return this.right;
        }
    }
    //lowest common ancestors
    public static BinaryTreeNode findLCA(BinaryTreeNode root, int n1, int n2){
        if(root == null){
            return null;
        }

        if(root.value == n1 || root.value == n2){
            return root;
        }

        BinaryTreeNode leftLCA = findLCA(root.left, n1, n2);
        BinaryTreeNode rightLCA = findLCA(root.right, n1, n2);
        if(leftLCA != null && rightLCA != null){
            return root;
        }
        if(leftLCA != null){
            return leftLCA;
        }else{
            return rightLCA;
        }
    }

    private static void findLCA(BinaryTreeNode root, int n1, int n2, Stack<BinaryTreeNode> stack) {
        if(root == null){
            return;
        }
        if(root.value == n1 || root.value == n2){
            stack.push(root);
        }
        findLCA(root.left, n1, n2, stack);
        findLCA(root.right, n1, n2, stack);
    }


    public static boolean isBalanced(BinaryTreeNode treeRoot) {
        // determine if the tree is super balanced
//        calculate depths of leafnodes and store in Set.
        return depth(treeRoot, new HashSet<>(), 0);
    }

    private static boolean depth(BinaryTreeNode current, Set<Integer> depths, int depth){
//        if leaf node (left and right are null)
        if(current.left == null && current.right == null){
            depths.add(depth);//add depth to depths
            if(depths.size()>2){//if size of depths is more than 2 return false
                return false;
            }
            if(depths.size() == 2){//if size is 2 and depth differ more than 1 return false
                Integer[] arr= depths.toArray(new Integer[0]);
                if(Math.abs(arr[1] - arr[0])>1){
                    return false;
                }
            }
        }
        if(current.left != null){//calculate for left tree
            if(!depth(current.left, depths, depth+1)){//if calculation returns false return
                return false;
            }
        }
        if(current.right != null){//calculate for right tree
            if(!depth(current.right, depths, depth+1)){//if calculation returns false return
                return false;
            }
        }
        return true;//if condition does not return false tree continue checking other part of tree
    }

    public static boolean isBinarySearchTree(BinaryTreeNode root) {

        // determine if the tree is a valid binary search tree
        return isValidBinarySearchTree(root);
    }

    private static boolean isValidBinarySearchTree(BinaryTreeNode node){
        if(node.left != null){
            if(node.value<findMax(node.left, node.left.value)){
                return false;
            }else{
                if(!isValidBinarySearchTree(node.left)){
                    return false;
                }
            }
        }
        if(node.right != null){
            if(node.value>findMin(node.right, node.right.value)){
                return false;
            }else{
                if(!isValidBinarySearchTree(node.right)){
                    return false;
                }
            }
        }
        return true;
    }

    public static int findMax(BinaryTreeNode node, int max){
        if(node.value>max){
            max = node.value;
        }
        if(node.right != null){
            max = findMax(node.right, max);
        }
        if(node.left != null){
            max = findMax(node.left, max);
        }
        return max;
    }

    public static int findMin(BinaryTreeNode node, int min){
        if(node.value<min){
            min = node.value;
        }
        if(node.right != null){
            min = findMin(node.right, min);
        }
        if(node.left != null){
            min = findMin(node.left, min);
        }
        return min;
    }

    private static boolean isValidBST(BinaryTreeNode current){
        if(current.left != null && current.value<current.left.value){
            return false;
        }
        if(current.right != null && current.value>current.right.value){
            return false;
        }
        if(current.left != null) {
            if(!isValidBST(current.left)){
                return false;
            }
        }
        if(current.right != null) {
            if(!isValidBST(current.right)){
                return false;
            }
        }
        return true;
    }

    public static int height(BinaryTreeNode root){
        int[] maxHeight = new int[1];
        height(root, 0, maxHeight);
        return maxHeight[0];
    }

    private static void height(BinaryTreeNode current, int height, int[] maxHeight){
        if(current.left == null && current.right == null){
            maxHeight[0] = Math.max(height, maxHeight[0]);
        }
        if(current.left != null){
            height(current.left, height+1, maxHeight);
        }
        if(current.right != null){
            height(current.right, height+1, maxHeight);
        }
    }

    private static int height(BinaryTreeNode current, int height, int maxHeight){
        if(current.left == null && current.right == null){
            return Math.max(height, maxHeight);
        }
        if(current.left != null){
            maxHeight = height(current.left, height+1, maxHeight);
        }
        if(current.right != null){
            maxHeight = height(current.right, height+1, maxHeight);
        }
        return maxHeight;
    }

    public static BinaryTreeNode lca(BinaryTreeNode root, int v1, int v2) {
        // Write your code here.
        Queue<BinaryTreeNode> queue1 = findValue(root, v1);
        Queue<BinaryTreeNode> queue2 = findValue(root, v2);
        BinaryTreeNode lca = null;
        while(queue1.peek()==queue2.peek()){
            lca = queue1.poll();
            queue2.poll();
        }
        return lca;
    }
    public static Queue<BinaryTreeNode> findValue(BinaryTreeNode node, int value){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode current = node;
        while(current != null){
            queue.offer(current);
            if(current.value == value){
                return queue;
            }
            if(value<current.value)
                current = current.left;
            else
                current = current.right;
        }
        throw new RuntimeException("Not Found");
    }

    public static boolean checkBST(BinaryTreeNode root) {
        if(root == null){
            return false;
        }
        return checkBSTSubTree(root);
    }
    private static boolean checkBSTSubTree(BinaryTreeNode node) {
        if(node.left != null && node.value<=findMinMax(node.left, node.left.value, false)){
            return false;
        }
        if(node.right!= null && node.value>=findMinMax(node.right, node.right.value, true)){
            return false;
        }
        if(node.left != null) {
            if(!checkBSTSubTree(node.left)){
                return false;
            }
        }
        if(node.right != null){
            if(!checkBSTSubTree(node.right)){
                return false;
            }
        }
        return true;
    }
    private static int findMinMax(BinaryTreeNode node, int result, boolean isMin){
        result = isMin?Math.min(result, node.value):Math.max(result, node.value);
        if(node.left != null){
            result = findMinMax(node.left, result, isMin);
        }
        if(node.right != null){
            result = findMinMax(node.right, result, isMin);
        }
        return result;
    }


    public static class NodeXDistance{
        BinaryTreeNode node;
        int xDistance;

        public NodeXDistance(BinaryTreeNode node, int xDistance){
            this.node  = node;
            this.xDistance = xDistance;
        }
    }

    public static void topView(BinaryTreeNode root) {
        if(root == null){
            return;
        }
        Map<Integer, NodeXDistance> distanceAlreadyPrinted = new TreeMap<>();
        Queue<NodeXDistance> queue = new LinkedList<>();
        queue.offer(new NodeXDistance(root, 0));


        while (!queue.isEmpty()){
            NodeXDistance nodeXDistance = queue.poll();
            if(!distanceAlreadyPrinted.containsKey(nodeXDistance.xDistance)) {
                distanceAlreadyPrinted.put(nodeXDistance.xDistance, nodeXDistance);
            }
            if(nodeXDistance.node.left != null){
                queue.offer(new NodeXDistance(nodeXDistance.node.left, nodeXDistance.xDistance-1));
            }
            if(nodeXDistance.node.right != null){
                queue.offer(new NodeXDistance(nodeXDistance.node.right, nodeXDistance.xDistance+1));
            }
        }


        for(Integer key: distanceAlreadyPrinted.keySet()){
            System.out.print(distanceAlreadyPrinted.get(key).node.value+" ");
        }
    }
    //traverse tree and send distance
    private static void topViewWithDistance(BinaryTreeNode node, int distance, int depth, Map<Integer, BinaryTreeNode> distanceAlreadyPrinted){
        if(node.left != null){
            topViewWithDistance(node.left, distance-1, depth+1, distanceAlreadyPrinted);
        }
        if(!distanceAlreadyPrinted.containsKey(distance)){
            distanceAlreadyPrinted.put(distance, node);
        }
        if(node.right != null){
            topViewWithDistance(node.right, distance+1, depth+1, distanceAlreadyPrinted);
        }
    }

    public static BinaryTreeNode insert(BinaryTreeNode root, int data) {
        BinaryTreeNode node = new BinaryTreeNode(data);
        if(root == null){
            return node;
        }
        BinaryTreeNode current = root;
        BinaryTreeNode previous = null;
        while(current != null) {
            previous = current;
            if (data < current.value) {
                current = current.left;
            }else if(data>current.value){
                current = current.right;
            }
        }
        if (data < previous.value) {
            previous.left = node;
        }else if(data>previous.value){
            previous.right = node;
        }

        return root;
    }
    public static void swap(BinaryTreeNode root) {
        BinaryTreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if(root.left != null){
            swap(root.left);
        }
        if(root.right != null){
            swap(root.right);
        }
    }


    /*
     * Complete the swapNodes function below.
     * each [][] tells how many total nodes [left] [right]
     * queries[] which depth to swap
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
//        child = 2*p+1 and 2*p+2
//
//        element 1
//        2, 2*(elementup)
//        4,
//        8,
//        16,
        int i = 0;
        int k = 0;
        int depth = 1;



        while(i<indexes.length){
            int query = queries[k];
            int[] element = indexes[i];
            if(true){

            }

            if(i==2*depth){
                depth++;
            }
            i++;
        }
        return null;
    }

    static void flattenTree(BinaryTreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        preordertraversal(root, queue);
        BinaryTreeNode current = queue.poll();
        current.left = null;
        current.right = null;
        while (!queue.isEmpty()){
            current.right = queue.poll();
            current = current.right;
            current.left = null;
            current.right = null;
        }
    }

    static void preordertraversal(BinaryTreeNode node, Queue<BinaryTreeNode> queue){
        queue.add(node);
        if(node.left != null){
            preordertraversal(node.left, queue);
        }
        if(node.right != null){
            preordertraversal(node.right, queue);
        }
    }

}
