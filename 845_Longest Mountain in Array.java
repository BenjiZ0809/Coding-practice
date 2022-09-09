class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;
        int res = 0;
        int index = 1;
        
        while(index < n) {
            int up = 0;
            int down = 0;
            while(index < n && arr[index] > arr[index-1]) {
                up++;
                index++;
            }
            while(index < n && arr[index] < arr[index-1]) {
                down++;
                index++;
            }
            if(up > 0 && down > 0) {
                res = Math.max(res, (down + up + 1));
            }
            while(index < n && arr[index] == arr[index-1]) {
                index++;
            }
        }
        
        return res;
    }
}
