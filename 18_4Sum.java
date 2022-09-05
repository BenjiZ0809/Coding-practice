class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length-3; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                for(int j=i+1; j<nums.length-2; j++) {
                    if(j == i+1 || nums[j-1] != nums[j]) {
                        long tar = (long)target - nums[i] - nums[j];
                        int left = j + 1;
                        int right = nums.length - 1;
                        
                        while(right > left) {
                            int sum = nums[left] + nums[right];
                            if(sum == tar) {
                                List<Integer> minires = new ArrayList<>();
                                minires.add(nums[i]);
                                minires.add(nums[j]);
                                minires.add(nums[left]);
                                minires.add(nums[right]);
                                res.add(minires);
                                
                                while(left < right && nums[left + 1] == nums[left]) left++;
                                while(left < right && nums[right - 1] == nums[right]) right--;
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
            }
        }
        return res;
    }
}
