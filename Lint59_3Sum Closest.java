public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        int res = 0;
        int diff = Integer.MAX_VALUE;

        for(int i=0; i<numbers.length-2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            
            while(left < right) {
                int sum = numbers[left] + numbers[right] + numbers[i];
                if(Math.abs(sum - target) < diff) {
                    res = sum;
                    diff = Math.abs(sum - target);
                }
                if(sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return res;
    }
}
