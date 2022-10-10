//2 binary search approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target < matrix[mid][0]) end = mid;
            else start = mid;
        }
        
        if(target <= matrix[start][n - 1]) {
            int left = 0;
            int right = n - 1;
            while(left + 1 < right) {
                int mid = left + (right - left) / 2;
                if(matrix[start][mid] > target) right = mid;
                else left = mid;
            }
            if(matrix[start][left] == target || matrix[start][right] == target) return true;
            else return false;
        }
        if(target >= matrix[end][0]) {
            int left = 0;
            int right = n - 1;
            while(left + 1 < right) {
                int mid = left + (right - left) / 2;
                if(matrix[end][mid] > target) right = mid;
                else left = mid;
            }
            if(matrix[end][left] == target || matrix[end][right] == target) return true;
            else return false;
        }
        return false;
    }
}


//1 binary search approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) return false; 
        if(matrix[0].length == 0 || matrix[0] == null) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = m * n - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int num = matrix[mid / n][mid % n];
            if(num > target) right = mid;
            else left = mid;
        }
        
        if(matrix[left / n][left % n] == target || matrix[right / n][right % n] == target) return true;
        else return false;
    }
}
