class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Queue<int[]>> tweetMap;
    int time;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] post = new int[] {tweetId, time++};
        Queue<int[]> tweets = tweetMap.getOrDefault(userId, new ArrayDeque<>());
        tweets.add(post);
        tweetMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follow = followMap.getOrDefault(userId, new HashSet<>());
        follow.add(userId);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int id:follow) {
            Queue<int[]> tweets = tweetMap.getOrDefault(id, new ArrayDeque<>());
            for(int[] tweet:tweets) pq.offer(tweet);
        }

        int k = 0;
        List<Integer> res = new ArrayList<>();
        while(k < 10 && !pq.isEmpty()) {
            res.add(pq.poll()[0]);
            k++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> follow = followMap.getOrDefault(followerId, new HashSet<>());
        follow.add(followeeId);
        followMap.put(followerId, follow);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> follow = followMap.getOrDefault(followerId, new HashSet<>());
        follow.remove(followeeId);
        followMap.put(followerId, follow);
    }
}
