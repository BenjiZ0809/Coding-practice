class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        for(int i=n; i>=1; i--) {
            int pos = find(arr, i);
            if(pos == i - 1) continue;
            if(pos != 0) {
                res.add(pos + 1);
                flip(arr, pos);
            }
            res.add(i);
            flip(arr, i - 1);
        }
        return res;
    }
    
    public void flip(int[] arr, int index) {
        for(int i=0; i<=index/2; i++){
            int temp = arr[i];
            arr[i] = arr[index - i];
            arr[index - i] = temp;
        }
    }
    
    public int find(int[] arr, int tar) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == tar) {
                return i;
            }
        }
        return -1;
    }
}
