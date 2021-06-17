package org.abhi.tree;

import java.util.*;

public class BinaryTree {

    static class Node{
        int value;
        Node right = null;
        Node left = null;

        Node(int value){
            this.value = value;
        }
    }

    public static Integer[] avgEachLevelD(Node root){
        List<Integer> result = new ArrayList<>();
        avgEachLevelDirect(root, result, 0);
        return result.toArray(new Integer[0]);
    }

    private static void avgEachLevelDirect(Node root, List<Integer> result, int depth){
        if(root == null){
            return;
        }
        if(result.size()>depth){
            result.set(depth, ((result.get(depth)+root.value)/2));
        }else{
            result.add(depth, root.value);
        }
        avgEachLevelDirect(root.left, result, depth+1);
        avgEachLevelDirect(root.right, result, depth+1);
    }


    public static int[] avgEachLevel(Node root){
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        dft(root, list, map, 0);
        int[] result = new int[map.size()];
        for(int key : map.keySet()){
            List<Node> nodes = map.get(key);
            int count = 0;
            int total = 0;
            while (count<nodes.size()){
                total += nodes.get(count).value;
                count++;
            }
            result[key] = total/count;
        }
        return result;
    }

    public static List<Integer> bft(Node root){
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            list.add(current.value);
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
        return list;
    }


    public static List<Integer> dft(Node root){
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        dft(root, list, map, 1);
        return list;
    }

    private static void dft(Node root, List<Integer> list, Map<Integer, List<Node>> map, Integer height){
        list.add(root.value);
        if(!map.containsKey(height)){
            map.put(height, new ArrayList<Node>());
        }
        map.get(height).add(root);
        if(root.left != null){
            dft(root.left, list, map, height+1);
        }
        if(root.right != null){
            dft(root.right, list, map, height+1);
        }
    }
}
