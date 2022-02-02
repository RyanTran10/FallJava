package introJava;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class SortAlgorithims {
	
	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int minInd = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					minInd = j;
				}
			}
			int temp = arr[i];
			arr[i] = min;
			arr[minInd] = temp;
		}
	}
	

	

	public int solver(int num) {
		LinkedList<Integer> people = new LinkedList<Integer>();
		for(int i=0; i<num; i++) {
			people.add(i);
		}
		int index = 1;
		while(people.size()>1) {
			people.remove(index);
			index+=1;
			if(index>people.size()-1) {
				if(index==people.size()) {
					index = 0;
				}else {
					index = 1;
				}
			}
		}
		
		return people.get(0);
	}
	
	//Medium (Logic): Take a positive integer as input. Return the next smallest positive number that contains 
	//the same digit as the input. Return -1 if there is no such number. For example, an input of 1234 would return -1. 
	//An input of 6739 would return 6397. An input of 6379 would return 3976.	
	
	
	public int Medium(int num) {
		String[] temp = Integer.toString(num).split("");
		int[] numbers = new int[temp.length];
		for(int i=0; i<temp.length; i++) {
			numbers[i]  = Integer.valueOf(temp[i]);
		}
		for(int i=numbers.length-1; i>=0; i--) {
			if(!smallest(numbers,i)) {
				int nextSmall = findNextSmall(numbers,i);
				int tempint = numbers[nextSmall];
				numbers[nextSmall]  = numbers[i];
				numbers[i] = tempint;
				ArrayList<Integer> templist = new ArrayList<Integer>();
			
				for(int j=i+1; j<numbers.length; j++) {
					templist.add(numbers[j]);
				}	
				if(templist.size()==1) {
					return arrayToint(numbers);
				}
				Collections.sort(templist);
				Collections.reverse(templist);
				for(int j=0; j<templist.size(); j++) {
					numbers[j+i+1] = templist.get(j);
				}
				return arrayToint(numbers);
			}
		}
		return -1;
	}
	
	public boolean smallest(int[] num, int ind) {
		for(int i=num.length-1; i>ind; i--) {
			if(num[i]<=num[ind]) {
				return false;
			}
		}
		return true;
	}
	
	public int findNextSmall(int[] num, int index) {
		int maxind = num.length-1;
		
		for(int i=num.length-2; i>index; i--) {
			if(num[i]<num[index] && num[maxind]>num[i]) {
				maxind = i;
			}
		}
		return maxind;
		
	}
	
	public int arrayToint(int[] num) {
		
		int ans = 0;
		for(int i=0; i<num.length; i++) {
			ans += num[i] * (int)(Math.pow(10, num.length-i-1));
		}
		return ans;
	}
	
	public static void duplicateEncoder(String s) {
		String s2 = "";
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			System.out.println(Arrays.toString(s.split(s.charAt(i)+"")));
			System.out.println(s + " " + s.charAt(i) + " " + (s.split(s.charAt(i) +"").length-1));
			System.out.println("");
			if(s.split(s.charAt(i) +"").length-1 > 1) {
				s2 += ")";
			} else {
				s2 += "(";
			}
		}
		System.out.println(s2);
	}
		
	public static void main(String[] args) {
		SortAlgorithims runner = new SortAlgorithims();
		duplicateEncoder("din");
		duplicateEncoder("recede");
		duplicateEncoder("Success");
		
//		System.out.println(runner.Medium(4253645));
//		int[] arr = new int[] {5,2,56,8,4,2,5,8,76};
//		selectionSort(arr);
//		System.out.println(Arrays.toString(arr));
	}
}