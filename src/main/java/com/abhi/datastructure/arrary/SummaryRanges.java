package com.abhi.datastructure.arrary;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;




//Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

//For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

//[1, 1]
//[1, 1], [3, 3]
//[1, 1], [3, 3], [7, 7]
//[1, 3], [7, 7]
//[1, 3], [6, 7]
//Follow up:
//What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

public class SummaryRanges {

	public static void main(String[] args){
		SummaryRanges obj = new SummaryRanges();
		obj.addNum(1);
		obj.addNum(3);
		obj.addNum(7);
		obj.addNum(2);
		obj.addNum(6);

		print(obj.getIntervals());

	}

	public static void print(List<Interval> param_2 ){
		System.out.println("print-->");
		for(Interval interval:param_2){
			System.out.println("["+interval.start+"-"+interval.end+"]");
		}
		System.out.println("<<<print");
	}

    /** Initialize your data structure here. */
    Set<Integer> set = new TreeSet<Integer>();
    public SummaryRanges() {

    }

    public void addNum(int val) {
		set.add(val);
    }

    public List<Interval> getIntervals() {
		List<Interval> intervals = null;
		int count = 0;
		int start = 0;
		int end = 0;
		for(Integer val:set){
			if(intervals == null){
				intervals = new ArrayList<Interval>();
				start = val;
				end = val;
				count++;
				continue;
			}

			if(val==start+count){
				count++;
				end = val;
			}else{
				intervals.add(new Interval(start,end));
				start = val;
				end = val;
				count = 1;
			}
		}
		if(intervals != null){
			intervals.add(new Interval(start,end));
		}
		return intervals;
    }


	private final TreeMap<Integer, Interval> rbTree = new TreeMap<>();

    /** Initialize your data structure here. */

    public void addNumB(int val) {
        if (rbTree.containsKey(val)) {
            return;
        }
        Map.Entry<Integer, Interval> left = rbTree.lowerEntry(val);
        if (left != null && left.getValue().end >= val) {
            return;
        }
        Map.Entry<Integer, Interval> right = rbTree.higherEntry(val);
        if (left != null && right != null && left.getValue().end + 1 == val && right.getValue().start == val + 1) {
            rbTree.remove(right.getKey());
            left.getValue().end = right.getValue().end;
        } else if (left != null && left.getValue().end + 1 >= val) {
            left.getValue().end = Math.max(left.getValue().end, val);
        } else if (right != null && right.getValue().start == val + 1) {
            rbTree.remove(right.getKey());
            rbTree.put(val, new Interval(val, right.getValue().end));
        } else {
            rbTree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervalsB() {
        return new ArrayList<>(rbTree.values());
    }

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}