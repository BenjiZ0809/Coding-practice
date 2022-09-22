class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int j = 0;
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            if(!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) deque.pollLast();
            deque.add(i);
            if(i >= k - 1) res[j++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
