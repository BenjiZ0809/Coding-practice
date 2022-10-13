public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if(pages.length == 0 || pages == null) return 0;
        int sum = 0;
        int max = 0;
        for(int num:pages) {
            sum += num;
            max = Math.max(max, num);
        }
        int start = max;
        int end = sum;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int count = count(pages, mid);
            if(count <= k) end = mid;
            else start = mid;
        }
        
        if(count(pages, start) <= k) return start;
        if(count(pages, end) <= k) return end;
        return 0;
    }

    private int count(int[] pages, int x) {
        int count = 1;
        int sum = 0;
        for(int num:pages) {
            if(sum + num > x) {
                count++;
                sum = num;
            }
            else sum += num;
        }
        return count;
    }
}
