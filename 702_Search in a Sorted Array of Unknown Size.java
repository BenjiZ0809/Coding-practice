class Solution {
    public int search(ArrayReader reader, int target) {
        int index = 1;
        while(reader.get(index) < target) {
            index *= 2;
        }
        
        int left = 0;
        int right = index;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(reader.get(mid) > target) right = mid;
            else left = mid;
        }
        
        if(reader.get(left) == target) return left;
        if(reader.get(right) == target) return right;
        return -1;
    }
}
