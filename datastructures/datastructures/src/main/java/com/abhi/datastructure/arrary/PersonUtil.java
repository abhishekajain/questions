package com.abhi.datastructure.arrary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class PersonUtil {
	
	static class Person{
		int birthYear;
		int deadYear;	
		
		public Person(int birthYear, int deadYear){
			this.birthYear = birthYear;
			this.deadYear = deadYear;
		}
	}
	
	public static int calculateMostLivedPersonsYear(Person[] persons) throws IllegalArgumentException{
		if(persons == null || persons.length == 0){
			throw new IllegalArgumentException();
		}
		
		int[] minMaxBirth = getMinMaxBirth(persons);
		int[] deltas = getDeltas(persons, minMaxBirth[0], minMaxBirth[1]); 
		
		int runningMax = runningMax(deltas);
		
		return runningMax+minMaxBirth[0];
	}
	
	private static int[] getDeltas(Person[] persons, int minBirth, int maxBirth){
		int[] deltas = new int[maxBirth-minBirth+1];
		
		for(Person p: persons){
			deltas[p.birthYear-minBirth] = deltas[p.birthYear-minBirth]+1;
			if((p.deadYear+1)<maxBirth){
				deltas[p.deadYear-minBirth+1] = deltas[p.deadYear-minBirth+1]-1;
			}
		}
		return deltas;
	}
	
	private static int runningMax(int[] deltas){
		int runningCount = 0;
		int runningMaxKey = 0;
		int runningCountMax = 0;
		
		for(int i=0;i<deltas.length;i++){
			runningCount = runningCount + deltas[i];
			if(runningCount>runningCountMax){
				runningCountMax = runningCount;
				runningMaxKey = i;
			}
		}
		return runningMaxKey;
	}
	
	private static int[] getMinMaxBirth(Person[] persons){
		int minBirthYear = persons[0].birthYear;
		int maxBirthYear = persons[0].birthYear;
		for(Person p: persons){
			if(minBirthYear>p.birthYear){
				minBirthYear = p.birthYear;
			}
			if(maxBirthYear<p.birthYear){
				maxBirthYear = p.birthYear;
			}
		}
		int[] minmax = {minBirthYear,maxBirthYear};
		return minmax;
	}	

	public static int mostLivedPersonsYear(Person[] persons){
		Map<Integer, Integer> yearCountMap= createYearCountMap(persons); 
		
		int runningMax = runningMax(yearCountMap);
		
		return runningMax;
	}
	
	private static Map<Integer, Integer> createYearCountMap(Person[] persons){
		Map<Integer, Integer> yearCountMap = new HashMap<Integer, Integer>();
		for(Person person:persons){
			if(yearCountMap.containsKey(person.birthYear)){
				yearCountMap.put(person.birthYear, (yearCountMap.get(person.birthYear)+1));
			}else{
				yearCountMap.put(person.birthYear, +1);
			}
			
			if(yearCountMap.containsKey(person.deadYear+1)){
				yearCountMap.put(person.deadYear+1, (yearCountMap.get(person.deadYear+1)-1));
			}else{
				yearCountMap.put(person.deadYear+1, -1);
			}
		}
		return yearCountMap;
	}
	
	private static int runningMax(Map<Integer, Integer> map){
		Set<Integer> set = map.keySet();
		SortedSet<Integer> sortedSet = new TreeSet<Integer>(set);
		
		int runningCount = 0;
		int runningMaxKey = 0;
		int runningCountMax = 0;
		
		for(Integer key:sortedSet){
			runningCount = runningCount + map.get(key);
			if(runningCount>runningCountMax){
				runningCountMax = runningCount;
				runningMaxKey = key;
			}
		}
		return runningMaxKey;
	}
	
	@Test
	public void testMostLivedPersonsYear(){		
		Person[] persons = {new Person(1775, 1789), new Person(1758, 1789), new Person(1775, 1850), 
				new Person(1800, 1900), new Person(1750, 1825), new Person(1925, 1989),
				new Person(1910, 1979), new Person(1979, 2015), new Person(1775, 1989)};
//		1775, 1789
//		1758, 1789
//		1775, 1850
//		1800, 1900
//		1750, 1825
//		1925, 1989
//		1910, 1979
//		1979, 2015
//		1775, 1989
		Assert.assertEquals(1775, mostLivedPersonsYear(persons));
	}
	
	@Test
	public void testCalculateMostLivedPersonsYear(){		
		Person[] persons = {new Person(1775, 1789), new Person(1758, 1789), new Person(1775, 1850), 
				new Person(1800, 1900), new Person(1750, 1825), new Person(1925, 1989),
				new Person(1910, 1979), new Person(1979, 2015), new Person(1775, 1989)};
//		1775, 1789
//		1758, 1789
//		1775, 1850
//		1800, 1900
//		1750, 1825
//		1925, 1989
//		1910, 1979
//		1979, 2015
//		1775, 1989
		Assert.assertEquals(1775, calculateMostLivedPersonsYear(persons));
	}

}
