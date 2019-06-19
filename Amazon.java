package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Amazon {

	/**
	 * Amazon question 1
	 * 
	 * @param numDestinations
	 * @param allLocations
	 * @param numDeliveries
	 * @return
	 */
	static List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
			int numDeliveries) {
		Map<Integer, ArrayList<ArrayList<Integer>>> sortedList = new TreeMap<Integer, ArrayList<ArrayList<Integer>>>();
		for (List<Integer> locationCoordinates : allLocations) {
			int distance = distace(locationCoordinates.get(0), locationCoordinates.get(1));
			List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			if (sortedList.containsKey(distance)) {
				list = sortedList.get(distance);
			}
			list.add((ArrayList<Integer>) locationCoordinates);
			sortedList.put(distance, (ArrayList<ArrayList<Integer>>) list);
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int key : sortedList.keySet()) {
			List<ArrayList<Integer>> list = sortedList.get(key);
			for (ArrayList<Integer> sameDistance : list) {
				if (numDeliveries > 0) {
					result.add(sameDistance);
					numDeliveries--;
				} else {
					break;
				}
			}
		}
		return result;
	}

	private static int distace(int x, int y) {
		return (x * x) + (y * y);
	}

	/**
	 * Amazon Question 2
	 * 
	 * @param target
	 * @param forwardRouteList
	 * @param returnRouteList
	 * @return
	 */
	public List<List<Integer>> maxOptimized(int target, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {
		List<List<Integer>> forw = new ArrayList<List<Integer>>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int max = 0, i = 0;
		while (i < forwardRouteList.size()) {
			int j = 0;
			while (j < returnRouteList.size()) {
				List<Integer> list = new ArrayList<Integer>();
				int sum = returnRouteList.get(j).get(1) + forwardRouteList.get(i).get(1);
				if (sum <= target && sum >= max) {
					if (sum != max) {
						ans = new ArrayList<List<Integer>>();
						max = sum;
					}
					list.add(forwardRouteList.get(i).get(0));
					list.add(returnRouteList.get(j).get(0));
					ans.add(list);
				}
				j++;
			}
			i++;
		}
		return ans;
	}
	
	
	public static int minimumTime(int numOfSubFiles, List<Integer> files) {
		Set<Integer> fileSet = new TreeSet<Integer>(files);
		int ans = 0;
		numOfSubFiles = numOfSubFiles <= files.size() ? numOfSubFiles : files.size();
		for (int num : fileSet) {
			if (numOfSubFiles == 0)
				break;
			ans += (numOfSubFiles == fileSet.size()) ? num * (numOfSubFiles-- - 1) : num * numOfSubFiles--;
		}
		return ans;
	}
}
