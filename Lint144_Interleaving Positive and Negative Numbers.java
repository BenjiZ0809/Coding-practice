public class Solution {
    public void rerange(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while(left <= right) {
            while(left <= right && a[left] < 0) {
                left++;
            }
            while(left <= right && a[right] > 0) {
                right--;
            }

            if(left <= right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }

        int posCount = 0;
        int negCount = 0;
        for(int num:a){
            if(num > 0) posCount++;
            else negCount++;
        }

        if(posCount > negCount) {
            interleave(a, 0, a.length - 2);
        }
        else if(posCount < negCount) {
            interleave(a, 1, a.length - 1);
        }
        else interleave(a, 0, a.length - 1);
    }

    public void interleave(int[] a, int start, int end) {
        int left = start;
        int right = end;
        while(right > left) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left += 2;
            right -= 2;
        }
    }
}
