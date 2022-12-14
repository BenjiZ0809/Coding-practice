class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                int tar = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                
                while(right > left) {
                    int sum = nums[left] + nums[right];
                    if(sum == tar) {
                        List<Integer> minires = new ArrayList<>();
                        minires.add(nums[i]);
                        minires.add(nums[left]);
                        minires.add(nums[right]);
                        res.add(minires);
                        
                        while(left < right && nums[left + 1] == nums[left]) left++;
                        //Only need to move one side 
                        //while(left < right && nums[right - 1] == nums[right]) right--;
                        
                        left++;
                        right--;
                    }
                    else if(sum > tar) {
                        right--;
                    }
                    else left++;
                }
            }
        }
        return res;
    }
}
