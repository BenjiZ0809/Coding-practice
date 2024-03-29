class Solution {
    public boolean winnerOfGame(String colors) {
        if(colors.length() < 3) return false;
        int a = 0;
        int b = 0;
        for(int i=1; i<colors.length() - 1; i++) {
            if(colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if(colors.charAt(i) == 'A') a++;
                else b++;
            }
        }
        return a > b;
    }
}
