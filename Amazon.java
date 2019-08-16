import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
	 * Given a list foreground and background applications that are identified by <ID, MemoryUsed>,
	 * Find the best pair of foreground and background applications that use the best optimal memory
	 * that is less the given limit and max for the given combinations
	 * input c = 1000 f = [[1,200],[2,300],[3,500],[4,600]] b = [[1,400],[2,500]]
	 * output = [[4,1],[3,2]]
	 *
	 * @param deviceCapacity , Integer representing the maximum available memory
	 * @param foreGroundList , List of foreground applications with ID and Memory usage as list values
	 * @param backGroundList , List of foreground applications with ID and Memory usage as list values
	 * @return List<List<Integer>> best possible combination of applications that use the optimal memory
	 */
	public List<List<Integer>> maxOptimized(int deviceCapacity, List<List<Integer>> foreGroundList,
			List<List<Integer>> backGroundList) {
		List<List<Integer>> forw = new ArrayList<List<Integer>>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int max = 0, i = 0;
		while (i < foreGroundList.size()) {
			int j = 0;
			while (j < backGroundList.size()) {
				List<Integer> list = new ArrayList<Integer>();
				int sum = backGroundList.get(j).get(1) + foreGroundList.get(i).get(1);
				if (sum <= deviceCapacity && sum >= max) {
					if (sum != max) {
						ans = new ArrayList<List<Integer>>();
						max = sum;
					}
					list.add(foreGroundList.get(i).get(0));
					list.add(backGroundList.get(j).get(0));
					ans.add(list);
				}
				j++;
			}
			i++;
		}
		return ans;
	}

	/**
	 * Amazon Question 3
	 * Fulfilment builders are given items of size s. The workers can combine 2 parts at a time.
	 * Recursively combine all the given parts to get one part. And we need to calculate the best possible
	 * optimal time for the worker to build the final product.
	 *
	 * @param numOfSubFiles , Integer representing number of parts
	 * @param files , List<Integer> representing the parts that are available
	 * @return Integer , that is the best possible time to create the item
	 */
	public static int minimumTime(int numOfSubFiles, List<Integer> files) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < numOfSubFiles; i++) {
			pq.add(files.get(i));
		}
		int res = 0;
		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			res += first + second;
			pq.add(first + second);
		}
		return res;
	}
}
