package cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LFUCache {

    //item that store key, value and frequency of how many times item accessed get and put
    static class Item{
        Integer key;
        Integer value;
        Integer frequency = 1;

        Item(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }


    private Integer size = 0;
    private Integer capacity = 0;

    private Map<Integer, Item> cache = null;
    private Map<Integer, Queue<Item>> frequencyMap = new HashMap<>();

    private Integer lowestFrequency = 0;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>(this.capacity);
    }

    public void put(int key, int value){
        if (this.capacity.equals(0)) {
            return;
        }
        if(this.cache.containsKey(key)){
            Item item = this.cache.get(key);
            item.value = value;
            this.frequencyMap.get(item.frequency).remove(item);
            //if this makes frequency map empty update lowest frequency
            if(this.frequencyMap.get(item.frequency).isEmpty()){
                if(this.lowestFrequency.equals(item.frequency)){
                    this.lowestFrequency = item.frequency+1;
                }
            }
            item.frequency++;
            if(!this.frequencyMap.containsKey(item.frequency)){
                this.frequencyMap.put(item.frequency, new LinkedList<>());
            }
            this.frequencyMap.get(item.frequency).offer(item);
        }else{
            if(this.size.equals(this.capacity)){//if cache is full
                //remove lowest frequency item from map's queue
                Item item = this.frequencyMap.get(this.lowestFrequency).poll();
                this.cache.remove(item.key);
                this.size--;
            }
            Item item = new Item(key, value);
            this.cache.put(key, item);
            // this is a lowest frequency
            this.lowestFrequency = item.frequency;
            if(!this.frequencyMap.containsKey(this.lowestFrequency)){
                this.frequencyMap.put(this.lowestFrequency, new LinkedList<>());
            }
            this.frequencyMap.get(this.lowestFrequency).offer(item);
            this.size++;
        }
    }


    public int get(int key){
        if(this.cache.containsKey(key)){
            Item item = this.cache.get(key);
            //remove item from frequency map's queue
            this.frequencyMap.get(item.frequency).remove(item);
            // if this removal map queue empty
            if(this.frequencyMap.get(item.frequency).isEmpty()){
                if(item.frequency.equals(this.lowestFrequency)){// if item frequency is lowest frequency update lowest
                    this.lowestFrequency = item.frequency+1;
                }
            }
            //update frequency of the item and update frequency map and queue
            item.frequency++;
            if(!this.frequencyMap.containsKey(item.frequency)){
                this.frequencyMap.put(item.frequency, new LinkedList<>());
            }
            this.frequencyMap.get(item.frequency).offer(item);
            return item.value;
        }
        return -1;
    }
}
