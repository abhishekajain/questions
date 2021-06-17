package cache;

import java.util.*;

public class LFUCacheQueue {

    static class Node{
        Integer key;
        Integer value;
        Integer frequency;

        Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    Integer size;
    Integer capacity;

    Map<Integer, Node> cache;
    Map<Integer, Queue<Node>> lfuMap;

    Integer lowestFrequency;

    public LFUCacheQueue(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>(this.capacity);
        this.lfuMap = new HashMap<>();
        this.size = 0;
    }

    public int get(int key){
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            updateNodeFrequency(node);//update node frequency
            return node.value;
        }
        return -1;
    }
    // this method will remove current node from lfumap queue, update node freq to one and move to new queue
    // if find lowest freq queue is empty, move up lowest frequency to one same as node
    private void updateNodeFrequency(Node node) {
        Integer cuFreq = node.frequency;
        lfuMap.get(cuFreq).remove(node);
        if (lfuMap.get(cuFreq).isEmpty() && cuFreq.equals(lowestFrequency)) {
            lowestFrequency += 1;
        }
        node.frequency += 1;
        if (!lfuMap.containsKey(node.frequency)) {
            lfuMap.put(node.frequency, new LinkedList<>());
        }
        lfuMap.get(node.frequency).offer(node);
    }

    public void set(int key, int value){
        if (this.capacity.equals(0)) {
            return;
        }
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            node.value = value;//update value of the node
            updateNodeFrequency(node);//update node frequency
        }else{
            if(this.size.equals(this.capacity)){
                //find one node of the lowest frequency from queue
                Node node = lfuMap.get(this.lowestFrequency).poll();
                this.cache.remove(node.key);//remove from the cache... this and addition of the new element should happen in the lock
                this.size--;
            }
            //create new node and this is now the lowest frequency
            Node node = new Node(key, value);
            this.lowestFrequency = 1;
            this.cache.put(key, node);
            if(!lfuMap.containsKey(node.frequency)){
                lfuMap.put(node.frequency, new LinkedList<>());
            }
            lfuMap.get(node.frequency).offer(node);
            this.size++;
        }
    }
}
