package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheQueue {

    static class Item{//DLinkedList Node
        Integer key;
        Integer value;
        Item next = null;
        Item previous = null;

        Item(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    //head and tail of the LinkedList
    private Item head;
    private Item tail;

    private Integer capacity;
    private Integer size;

    Map<Integer, Item> cache;

    public LRUCacheQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>(this.capacity);
    }

    public void put(int key, int value){
        //if cache of zero capacity
        if(this.capacity.equals(0)){
            return;
        }
        if(this.cache.containsKey(key)){
            Item item = this.cache.get(key);
            //update value
            item.value = value;
            //remove from queue and move to head
            this.deleteItemFromQueue(item);
            this.addToHead(item);
        }else{
            if(this.size.equals(this.capacity)){
                //remove last item of the queue
                Item item = this.removeTail();
                this.cache.remove(item.key);
                this.size--;
            }
            Item item = new Item(key, value);
            //add to head of the queue and add to cache
            this.addToHead(item);
            this.cache.put(key, item);
            this.size++;
        }
    }

    public int get(int key){
        if(this.cache.containsKey(key)){
            Item item = this.cache.get(key);
            //now remove this item from existing location and move to the head of the queue
            this.deleteItemFromQueue(item);
            this.addToHead(item);
            return item.value;
        }
        return -1;
    }

    private void deleteItemFromQueue(Item item){
        //get next and previous
        Item next = item.next;
        Item previous = item.previous;

        if(previous != null) {
            previous.next = next;
        }else{//head
            this.head = next;
        }

        if(next != null) {
            next.previous = previous;
        }else{//tail
            this.tail = previous;
        }

        item.next = null;
        item.previous = null;
    }

    private Item removeTail(){
        Item tail = this.tail;
        if(this.tail.equals(this.head)){//if head and tail are same mean queue is of size one
            this.tail = null;
            this.head = null;
        }else {
            this.tail = tail.previous;//assign previous of current tail to new tail
            this.tail.next = null;//next of the tail is null
            tail.previous = null;//making pointer null
        }
        return tail;
    }

    private void addToHead(Item item){
        if(this.head == null){//if it is a first item in the queue
            this.head = item;
            this.tail = item;
        }else {
            Item head = this.head;
            head.previous = item;//curren head moving make item previous
            item.next = head;//item next is current head
            this.head = item;//make item head
        }
    }
}
