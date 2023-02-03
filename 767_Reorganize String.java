//PQ
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Queue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char ch:map.keySet()) pq.offer(ch);
        
        if(map.get(pq.peek()) > (s.length() + 1) / 2) return "";

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch1 = pq.poll();
            char ch2 = pq.isEmpty()? '@':pq.poll();
            sb.append(ch1);
            if(ch2 != '@') sb.append(ch2);
            map.put(ch1, map.get(ch1) - 1);
            if(map.get(ch1) != 0) pq.offer(ch1);
            if(ch2 != '@') {
                map.put(ch2, map.get(ch2) - 1);
                if(map.get(ch2) != 0) pq.offer(ch2);
            }
        }
        return sb.toString();
    }
}

//Greedy / counting
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int max = 0;
        char maxChar = 'a';

        for(char ch:s.toCharArray()) {
            freq[ch - 'a']++;
            if(freq[ch - 'a'] > max) {
                max = freq[ch - 'a'];
                maxChar = ch;
            }
        }

        if(max > (s.length() + 1) / 2) return "";

        char[] arr = new char[s.length()];
        int index = 0;
        while(freq[maxChar - 'a'] > 0) {
            arr[index] = maxChar;
            index += 2;
            freq[maxChar - 'a']--;
        }

        for(int i=0; i<26; i++) {
            while(freq[i] > 0) {
                if(index >= s.length()) index = 1;
                arr[index] = (char)(i + 'a');
                index += 2;
                freq[i]--;
            }
        }
        return String.valueOf(arr);
    }
}
