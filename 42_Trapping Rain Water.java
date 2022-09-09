//Two pointer approach
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        
        while(left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            
            if(maxLeft < maxRight) {
                left++;
                int amount = Math.min(maxLeft, maxRight) - height[left];
                if(amount > 0) res += amount;
            }
            else {
                right--;
                int amount = Math.min(maxLeft, maxRight) - height[right];
                if(amount > 0) res += amount;
            }
        }
        return res;
    }
}

//Normal approach with O(n) space
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        for(int i=1; i<n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        int[] maxRight = new int[n];
        for(int i=n-2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        int[] minLR = new int[n];
        for(int i=0; i<n; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        
        int res = 0;
        for(int i=0; i<n; i++) {
            if(minLR[i] - height[i] > 0) {
                res += minLR[i] - height[i];
            }
        }
        
        return res;
    }
}
