package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by csy99 on 4/19/20.
 */
public class Q355_Design_Twitter {
    static int timeStamp = 0;
    private HashMap<Integer, User> userMap;
    
    class Tweet {
        public int id;
        public int time;
        public Tweet next;
        
        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
    
    class User {
        int uid;
        HashSet<Integer> followed;
        Tweet head;
        
        public User(int id) {
            uid = id;
            followed = new HashSet();
            follow(id);  // follow itself
            head = null;
        }
        
        public void follow(int id) {
            followed.add(id);
        }
        
        public void unfollow(int id) {
            followed.remove(id);
        }
        
        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = head;
            head = t;
        }
    }
    

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList();
        if (!userMap.containsKey(userId))
            return res;
        HashSet<Integer> follows = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(follows.size(), (a,b)->(b.time-a.time));
        for (int user: follows) {
            Tweet t = userMap.get(user).head;
            if (t != null)
                pq.add(t);
        }
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if (t.next != null)
                pq.offer(t.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) 
            return;
        if (!userMap.containsKey(followeeId)) 
            return;
        if (followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
