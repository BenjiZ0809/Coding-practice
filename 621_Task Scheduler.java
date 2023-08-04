// PQ (slow)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch:tasks) freq[ch - 'A']++;

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int num:freq) {
            if(num != 0) pq.offer(num);
        }

        int time = 0;
        while(!pq.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            for(int i=0; i<=n; i++) {
                if(!pq.isEmpty()) {
                    int count = pq.poll();
                    count--;
                    if(count > 0) arr.add(count);
                }
                time++;
                if(pq.isEmpty() && arr.size() == 0) break;
            }
            pq.addAll(arr);
        }
        return time;
    }
}

//Math (fast)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char ch:tasks) {
            freq[ch - 'A']++;
        }

        int maxFreq = 0;
        for(int num:freq) {
            maxFreq = Math.max(maxFreq, num);
        }

        int maxFreqTask = 0;
        for(int num:freq) {
            if(num == maxFreq) maxFreqTask++;
        }

        int res = (n + 1) * (maxFreq - 1) + maxFreqTask;
        return res >= tasks.length? res : tasks.length;
    }
}
