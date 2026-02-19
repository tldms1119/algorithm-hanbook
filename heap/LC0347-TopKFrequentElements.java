/**
 * LeetCode #347 - Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * 🧠 Core Insight (HashMap + Min Heap)
 *
 * Step 1: Count frequency using HashMap
 * Step 2: Maintain a Min Heap of size k
 *         - Heap stores elements ordered by frequency
 *         - If size exceeds k, remove smallest frequency
 *
 * ⏱ Time Complexity: O(n log k)
 * 💾 Space Complexity: O(n)
 *
 * 🔥 Pattern Recognition Signal
 *
 * If problem says:
 * - "Top K"
 * - "Most frequent"
 * - "Largest K elements"
 *
 * → Think: Heap or Bucket Sort
 */

import java.util.*;

public class LC0347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Frequency count
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap (frequency 기준 오름차순)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract result
        int[] result = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll()[0];
        }

        return result;
    }
}
