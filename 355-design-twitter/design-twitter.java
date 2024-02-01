class Pair{
    int count;
    int tid;
    public Pair(int _c,int _t)
    {
        this.count = _c;
        this.tid = _t;
    }
}
class Twitter {
    int count;
    HashMap<Integer,List<Pair>> tweet;
    HashMap<Integer, HashSet<Integer>> userfollow;
    public Twitter() {
        count = 0;
        tweet = new HashMap<>();
        userfollow = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweet.containsKey(userId))
        {
            tweet.put(userId, new ArrayList<>());
        }
        tweet.get(userId).add(new Pair(count, tweetId));
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        if(userfollow.containsKey(userId))
        {
            for(int user : userfollow.get(userId))
            {
                if(tweet.containsKey(user))
                {
                    for(Pair p: tweet.get(user))
                    {
                        pq.add(p);
                    }
                }
            }
        }
        if(tweet.containsKey(userId))
        {
            for(Pair p: tweet.get(userId))
            {
                System.out.print(p.tid+" ");
                pq.add(p);
            }
        }
        int count = 0; 
        while(!pq.isEmpty() && count != 10)
        {
            Pair p = pq.poll();
            ans.add(p.tid);
            count++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userfollow.containsKey(followerId))
        {
            userfollow.put(followerId, new HashSet<>());   
        }
        
        userfollow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userfollow.containsKey(followerId))
        {
            return;
        }
        userfollow.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */