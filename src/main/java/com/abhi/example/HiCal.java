package com.abhi.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class HiCal {

	static class Meeting {

		private int startTime;
		private int endTime;

		public Meeting(int startTime, int endTime) {
			// number of 30 min blocks past 9:00 am
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
	}

	public static List<Meeting> mergeRanges(Meeting[] meetings) {
		List<Meeting> mergedMeetings = new ArrayList<Meeting>();
		List<Meeting> listMeetings = Arrays.asList(meetings);
		Collections.sort(listMeetings, (m1, m2) -> {
			if(m1.startTime == m2.startTime){
				return m1.endTime - m2.endTime;
			}
			return m1.startTime - m2.startTime;
		});
		
		int startTime = -1;
		int endTime = -1;
		for(Meeting m:listMeetings){
			if(startTime == -1 && endTime == -1){
				startTime = m.startTime;
				endTime = m.endTime;	
			}else if(m.endTime>=endTime && m.startTime <= endTime){
				endTime = m.endTime;
				continue;
			}else if(m.endTime<endTime && m.startTime <= endTime){

			}else{
				mergedMeetings.add(new Meeting(startTime, endTime));
				startTime = m.startTime;
				endTime = m.endTime;		
			}
		}

		mergedMeetings.add(new Meeting(startTime, endTime));

		return mergedMeetings;
	}


	@Test
	public void testMergeRanges() {
		Meeting[] meetings = { new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12),
				new Meeting(9, 10) };
		List<Meeting> mergedMeetings = mergeRanges(meetings);
		mergedMeetings.stream().forEach(m ->{
			System.out.println("testMergeRanges-->"+m.startTime+"-"+m.endTime);
		});
	}
	
	@Test
	public void testMergeRangesConflict() {
		Meeting[] meetings = { new Meeting(0, 2), new Meeting(3, 10), new Meeting(4, 8), new Meeting(10, 12),
				new Meeting(9, 10), new Meeting(3, 9) };
		List<Meeting> mergedMeetings = mergeRanges(meetings);
		mergedMeetings.stream().forEach(m ->{
			System.out.println("testMergeRangesConflict-->"+m.startTime+"-"+m.endTime);
		});
	}
}
