package com.abhi.datastructure.arrary;


//Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

//Note:
//You may assume the interval's end point is always bigger than its start point.
//Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
//Example 1:
//Input: [ [1,2], [2,3], [3,4], [1,3] ]
//
//Output: 1
//
//Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
//Example 2:
//Input: [ [1,2], [1,2], [1,2] ]
//
//Output: 2
//
//Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
//Example 3:
//Input: [ [1,2], [2,3] ]
//
//Output: 0
//
//Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
public class OverlapIntervals {

	public static void main(String[] args){
		Interval[] intervals = {new Interval(1,2), new Interval(2,3), new Interval(3,4), new Interval(1,3)};
		System.out.println(eraseOverlapIntervals(intervals));

		Interval[] intervals1 = {new Interval(1,2), new Interval(1,2), new Interval(1,2)};
		System.out.println(eraseOverlapIntervals(intervals1));

		Interval[] intervals2 = {new Interval(1,2), new Interval(2,3)};
		System.out.println(eraseOverlapIntervals(intervals2));

		Interval[] intervals3 = {new Interval(1,2)};
		System.out.println(eraseOverlapIntervals(intervals3));

		System.out.println(eraseOverlapIntervals(null));

		Interval[] intervals4 = {new Interval(1,10), new Interval(11,22), new Interval(1,11), new Interval(2,12)};
		System.out.println(eraseOverlapIntervals(intervals4));

	}

	public static int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals == null || intervals.length<2){
			return 0;
		}

		int start = intervals[0].start;
		int end = intervals[0].end;
		int count = 0;
		for(int i=1; i<intervals.length;i++){
			Interval interval = intervals[i];
			if(start<=interval.start && end>=interval.end){
				count++;
			}else if(interval.start>=end){
				end = interval.end;
			}else if(interval.end<=start){
				start = interval.start;
			}
		}
		return count;
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