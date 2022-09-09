//Approach one
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


//Approach two
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int index = 1;
        int res = 0;
        
        while(index < n - 1) {
            boolean isPeak = false;
            if(arr[index - 1] < arr[index] && arr[index] > arr[index + 1]) {
                isPeak = true;
            }
            if(!isPeak) {
                index++;
                continue;
            }
            int left = index - 2;
            int right = index + 2;
            while(left >= 0 && arr[left + 1] > arr[left]) {
                left--;
            }
            while(right < n && arr[right - 1] > arr[right]) {
                right++;
            }
            int dist = (right - left) - 1;
            res = Math.max(res, dist);
            index = right;
        }
        return res;
    }
}
