package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Max_Sliding_Window_PriorityQueue {
    public static List<Integer> maxSlidingWindow(int[] arr,
                                                 int k)
    {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> b.value - a.value);

        for (int i = 0; i < k; i++) {
            heap.offer(new Pair(arr[i], i));
        }

        ans.add(heap.peek().value);

        for (int i = k; i < arr.length; i++) {
            heap.offer(new Pair(arr[i], i));

            while (heap.peek().index <= i - k) {
                heap.poll();
            }

            ans.add(heap.peek().value);
        }

        return ans;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 7, 9, 5, 1, 6, 4, 3 };
        int k = 3;

        List<Integer> result = maxSlidingWindow(arr, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

