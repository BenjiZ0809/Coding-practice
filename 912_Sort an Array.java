//merge sort
//Time:O(nlogn)  Space:O(n)
class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, temp);
        return nums;
    }
    
    public void mergeSort(int[]nums, int start, int end, int[]temp){
        if(start >= end) return;
        int mid = (start + end) / 2;
        
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, end, temp);
    }
    
    public void merge(int[] nums, int start, int end, int[] temp){
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int index = start;
        
        while(left <= mid && right <= end){
            if(nums[left] < nums[right]){
                temp[index++] = nums[left++];
            }    
            else{
                temp[index++] = nums[right++];
            }
        }
        
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        while(right <= end){
            temp[index++] = nums[right++];
        }
        
        for(int i=start; i<=end; i++){
            nums[i] = temp[i];
        }
    }
}

//quick sort
//Time:O(nlogn) (Worst could be O(n^2))  Space:O(1)
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    
    public void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int left = start;
        int right = end;
        int pivot = arr[(start + end) / 2];
        while(left <= right) {
            while(left <= right && arr[left] < pivot){
                left++;
            }
            while(left <= right && arr[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}
