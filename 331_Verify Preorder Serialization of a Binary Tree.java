class Solution {
    public boolean isValidSerialization(String preorder) {
        int slot = 1;
        for(String str:preorder.split(",")) {
            slot--;
            if(slot < 0) return false;
            if(!str.equals("#")) slot += 2;
        }
        return slot == 0;
    }
}
