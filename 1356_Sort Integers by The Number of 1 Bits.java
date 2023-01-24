class Solution {
    public int[] sortByBits(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        return arr;
    }

    private void mergeSort(int[] arr, int start, int end, int[] temp) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        merge(arr, start, end, temp);
    }

    private void merge(int[] arr, int start, int end, int[] temp) {
        int mid = start + (end - start) / 2;
        int left = start;
        int right = mid + 1;
        int index = start;

        while(left <= mid && right <= end) {
            if(compare(arr[left], arr[right]) < 0) {
                temp[index++] = arr[left++];
            }
            else {
                temp[index++] = arr[right++];
            }
        }
        
        while(left <= mid) {
            temp[index++] = arr[left++];
        }
        while(right <= end) {
            temp[index++] = arr[right++];
        }

        for(int i=start; i<=end; i++) {
            arr[i] = temp[i];
        }
    }

    private int compare(int a, int b) {
        int diff = Integer.bitCount(a) - Integer.bitCount(b);
        if(diff == 0) return a - b;
        return diff;
    }
}
