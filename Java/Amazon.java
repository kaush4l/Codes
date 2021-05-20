import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Amazon {

    /**
     * Question 1
     *
     * @param numDestinations
     * @param allLocations
     * @param numDeliveries
     * @return
     */
    static List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
                                                    int numDeliveries) {
        Map<Integer, ArrayList<ArrayList<Integer>>> sortedList = new TreeMap<>();
        for (List<Integer> locationCoordinates : allLocations) {
            int distance = distace(locationCoordinates.get(0), locationCoordinates.get(1));
            List<ArrayList<Integer>> list = new ArrayList<>();
            if (sortedList.containsKey(distance)) {
                list = sortedList.get(distance);
            }
            list.add((ArrayList<Integer>) locationCoordinates);
            sortedList.put(distance, (ArrayList<ArrayList<Integer>>) list);
        }
        List<List<Integer>> result = new ArrayList<>();
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
     * Question 2
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
        List<List<Integer>> forw = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int max = 0, i = 0;
        while (i < foreGroundList.size()) {
            int j = 0;
            while (j < backGroundList.size()) {
                List<Integer> list = new ArrayList<Integer>();
                int sum = backGroundList.get(j).get(1) + foreGroundList.get(i).get(1);
                if (sum <= deviceCapacity && sum >= max) {
                    if (sum != max) {
                        ans = new ArrayList<>();
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

    // Given Quotes and popular toys return a list of topToys
    public static ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys, int numQuotes,
                                                 List<String> quotes) {
        TreeMap<Integer, TreeSet<String>> map = new TreeMap<>();
        TreeSet<String> temp;
        for (String toy : toys) {
            int count = 0;
            for (String quote : quotes) {
                if (quote.toLowerCase().contains(toy.toLowerCase())) {
                    count++;
                }
            }
            if (count != 0) {
                temp = map.getOrDefault(numToys - count, new TreeSet<>());
                temp.add(toy);
                map.put(numToys - count, temp);
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int rank : map.keySet()) {
            temp = map.get(rank);
            for (String toy : temp) {
                if (topToys-- > 0) {
                    ans.add(toy);
                }
                if (topToys == 0)
                    return ans;
            }
        }
        return ans;
    }

    // Storage optimization
    // Given a storage with a block of (1x1x1) storage, we are given a matrix of NxM
    // and H, V represting the rods in the matrix to remove, calculate the biggest storage block that can be formed
    public static long storage(int n, int m, int[] h, int[] v) {
        HashSet<Integer> x = new HashSet<Integer>();
        HashSet<Integer> y = new HashSet<Integer>();
        for (int i = 0; i <= n + 1; i++)
            x.add(i);
        for (int j = 0; j <= m + 1; j++)
            y.add(j);
        for(int i : h) x.remove(i);
        for(int i : v) y.remove(i);

        int xMaxDiff = 0;
        int prev = 0;
        for(int i : x) {
            xMaxDiff = (i - prev) > xMaxDiff ? (i - prev) : xMaxDiff;
            prev = i;
        }
        int yMaxDiff = 0;
        prev = 0;
        for(int i : y) {
            yMaxDiff = (i - prev) > yMaxDiff ? (i - prev) : yMaxDiff;
            prev = i;
        }
        return xMaxDiff * yMaxDiff;
    }

    // Cloudfront Caching
    // Cloufront wants to build an efficient caching algorithm. So when given a set of connected nodes,
    // ans = Math.ceil(Math.sqrt(sum of connected node)) // for all nodes
    public static int connectedSum(int n, List<String> edges) {
        Map<Integer, Node> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new Node(i));
        }
        for(String edge : edges) {
            String[] nums = edge.split(" ",2);
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            map.get(a).neighbors.add(map.get(b));
            map.get(b).neighbors.add(map.get(a));
        }
        ArrayList<Integer> visited = new ArrayList<>();
        double ans = 0;
        for(int node: map.keySet()) {
            if(!visited.contains(node)) {
                visited.add(node);
                int weight = calculate(map.get(node), visited, 1);
                ans += Math.ceil(Math.sqrt(weight));
            }
        }
        return (int) ans;
    }
    public static int calculate(Node n, ArrayList<Integer> visited, int weight) {
        for(Node neighbor: n.neighbors) {
            if(!visited.contains(neighbor.data)) {
                visited.add(neighbor.data);
                weight = calculate(neighbor, visited, weight)+1;
            }
        }
        return weight;
    }

    public static class Node {
        public int data;
        public List<Node> neighbors = new ArrayList<>();
        public Node(int d) {
            data = d;
        }
    }

    /**
     * Given a set of instruction L, R or G
     * L -> turn left R -> turn right G -> move forward
     * @param instructions containing 
     * @return true if the robot return to origin after the sequence
     */
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dir = 0;
        for(int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if(ch == 'L') {
                dir = (dir + 3) % 4;
            } else if(ch =='R') {
                dir = (dir + 1) % 4;
            } else {
                if(dir == 0) {
                    y++;
                } else if(dir == 1) {
                    x++;
                } else if(dir == 2) {
                    y--;
                } else {
                    x--;
                }
            }
        }
        return (x == 0 && y == 0) || (dir != 0);
    }

    /**
     * |**|*|*
     * Given a string containing | or * and start and end indexes
     * return the number of items between the '|'
     * @param s the String input
     * @param startIndices list of start indices
     * @param endIndices list of end indies
     * @return list of integer where integer represents the number of '*'s that are inbetween |'s
     */
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        String calculate = "";
        int occurance = 0;
        for (char c : s.toCharArray()) {
            if (c != '|') {
                occurance++;
            }
            calculate += occurance;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < startIndices.size(); i++) {
            String sub = s.substring(0, endIndices.get(i));
            int start = calculate.charAt(sub.indexOf('|', startIndices.get(i) - 1));
            int end = calculate.charAt(sub.lastIndexOf('|'));
            ans.add(end - start);
        }
        return null;
    }

    /**
     * Given a String replace a digit and find number of combinations that are divisible by 3
     *
     * @return number of combinations possible
     */
    public static int divisibility(String s) {
        return calculate(getNumbers(s), s.length() - 1, 0);
    }
    public static ArrayList<Integer> getNumbers(String s) {
        int number = Integer.parseInt(s);
        ArrayList<Integer> digits = new ArrayList<>();
        while(number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }
    public static int calculate(ArrayList<Integer> digits, int index, int count) {
        if(index < 0) return count;
        int sum = 0;
        for(int i = 0; i < digits.size(); i++)
            sum += (i == index) ? 0 : digits.get(i);
        if(sum % 3 == 0) count += 4;
        else count += 3;
        return calculate(digits, index - 1, count);
    }
}
