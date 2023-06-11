class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] freq = new int[10];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') continue;
                int index = Character.getNumericValue(board[i][j]);
                freq[index]++;
                if(freq[index] > 1) return false;
            }
            freq = new int[10];
        }
        
        freq = new int[10];
        for(int j=0; j<9; j++) {
            for(int i=0; i<9; i++) {
                if(board[i][j] == '.') continue;
                int index = Character.getNumericValue(board[i][j]);
                freq[index]++;
                if(freq[index] > 1) return false;
            }
            freq = new int[10];
        }

        freq = new int[10];
        for(int row=0; row<3; row++) {
            for(int col=0; col<3; col++) {
                int rowStart = row * 3;
                int rowEnd = rowStart + 3;
                int colStart = col * 3;
                int colEnd = colStart + 3;
                for(int i=rowStart; i<rowEnd; i++) {
                    for(int j=colStart; j<colEnd; j++) {
                        if(board[i][j] == '.') continue;
                        int index = Character.getNumericValue(board[i][j]);
                        freq[index]++;
                        if(freq[index] > 1) return false;
                    }
                }
                freq = new int[10];
            }
        }
        return true;
    }
}
