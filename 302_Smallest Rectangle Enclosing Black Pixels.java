class Solution {
    public int minArea(char[][] image, int x, int y) {
        int n = image.length;
        int m = image[0].length;
        int left = searchRowLeft(image, y);
        int right = searchRowRight(image, y);
        int top = searchColUp(image, x);
        int bottom = searchColBottom(image, x);
        int w = right - left + 1;
        int h = bottom - top + 1;
        return w * h;
    }

    public int searchRowLeft(char[][] image, int y) {
        int l = 0;
        int r = y;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(checkCol(image, mid)) r = mid;
            else l = mid;
        }
        if(checkCol(image, l)) return l;
        if(checkCol(image, r)) return r;
        return -1;
    }

    public int searchRowRight(char[][] image, int y) {
        int l = y;
        int r = image[0].length - 1;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(checkCol(image, mid)) l = mid;
            else r = mid;
        }
        if(checkCol(image, r)) return r;
        if(checkCol(image, l)) return l;
        return -1;
    }

    public int searchColUp(char[][] image, int x) {
        int l = 0;
        int r = x;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(checkRow(image, mid)) r = mid;
            else l = mid;
        }
        if(checkRow(image, l)) return l;
        if(checkRow(image, r)) return r;
        return -1;
    }

    public int searchColBottom(char[][] image, int x) {
        int l = x;
        int r = image.length - 1;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(checkRow(image, mid)) l = mid;
            else r = mid;
        }
        if(checkRow(image, r)) return r;
        if(checkRow(image, l)) return l;
        return -1;
    }

    public boolean checkRow(char[][] image, int x) {
        for(int j=0; j<image[0].length; j++) {
            if(image[x][j] == '1') {
                return true;
            }
        }
        return false;
    }

    public boolean checkCol(char[][] image, int y) {
        for(int i=0; i<image.length; i++) {
            if(image[i][y] == '1') {
                return true;
            }
        }
        return false;
    }
}
