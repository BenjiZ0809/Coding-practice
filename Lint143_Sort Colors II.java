public class Solution {
    public void sortColors2(int[] colors, int k) {
        colorSort(colors, 1, k, 0, colors.length - 1);
    }

    public void colorSort(int[] colors, int colorFrom, int colorTo, int indexFrom, int indexTo) {
        if(colorFrom == colorTo || indexFrom == indexTo) return;
        int color = (colorFrom + colorTo) / 2;
        int left = indexFrom;
        int right = indexTo;

        while(left <= right) {
            while(left <= right && colors[left] <= color) {
                left++;
            }
            while(left <= right && colors[right] > color) {
                right--;
            }

            if(left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }

        colorSort(colors, colorFrom, color, indexFrom, right);
        colorSort(colors, color + 1, colorTo, left, indexTo);
    }
}
