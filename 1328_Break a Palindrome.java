class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        int index = 0;
        int n = arr.length;
        if(n == 1) return "";

        while(index < n / 2) {
            if(arr[index] != 'a') {
                arr[index] = 'a';
                return new String(arr);
            }
            index++;
        }
        
        arr[n - 1] = 'b';
        return new String(arr);
    }
}
