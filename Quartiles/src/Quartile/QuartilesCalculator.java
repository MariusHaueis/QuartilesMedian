package Quartile;
/**
 * This class divides the the input Integers into 3 Quartiles and outputs their associated median values.
 * @author Marius Haueis
 * @version 30.03.2021
 */
import java.util.*;
public class QuartilesCalculator {
	

	public List<Integer> quartiles(List<Integer> arr) {
		ArrayList<Integer> helperList = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		arr.sort(Comparator.naturalOrder());
		
		int z = (int) Math.floor(arr.size()/2);
		for(int i=1; i< z;i++) {
			helperList.add(arr.get(i-1));
		}
		result.add(helper(helperList));
		if(arr.size()%2==0) {
			result.add((int)((arr.get((arr.size()/2)-1) + arr.get(arr.size()/2))/2));
		}else {
			result.add(arr.get((arr.size()/2)));
		}
		int sizes = helperList.size();
		helperList.clear();
		for(int i=1; i< sizes+1; i++) {
			helperList.add(arr.get(arr.size()-i));
		}
		result.add(helper(helperList));
		return result;
	}
	
	public int helper(List<Integer> arr2) {
		if(arr2.size()%2!=0) {
		int b = (int) Math.floor(arr2.size()/2);		
		int c = (arr2.get(b) + arr2.get(b+1))/2;
		return c;
		}else {
			return arr2.get((int)Math.ceil(arr2.size()/2));
		}
	}
}


