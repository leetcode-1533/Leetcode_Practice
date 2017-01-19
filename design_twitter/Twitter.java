package design_twitter;

/**
 * Created by y1275963 on 1/19/17.
 */
import java.util.*;

public class Twitter {
    int tc = 0;
    HashMap<Integer, HashSet<Integer>> FollowerList = new HashMap<>();
    HashMap<Integer, List<tweet>> TwitterList = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        createNewUser(userId);

        if (!TwitterList.containsKey(userId))
            TwitterList.put(userId, new ArrayList<tweet>());

        List<tweet> temp = TwitterList.get(userId);
        temp.add(new tweet(tc, tweetId));
        tc++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<tweet> container = new PriorityQueue<>();
        if (FollowerList.containsKey(userId)) {
            Set<Integer> followees = FollowerList.get(userId);
            for (int followee : followees) {
                List<tweet> alltweets = TwitterList.get(followee);
                if (alltweets != null) {
                    List<tweet> least10 = alltweets.subList(Math.max(alltweets.size() - 10, 0), alltweets.size());
                    for (tweet least10tweet : least10) {
                        container.add(least10tweet);
                    }
                }
            }
        }
        List<Integer> re = new ArrayList<>(10);
        for (int i = 0; i < 10 && !container.isEmpty(); i++) {
            re.add(container.poll().id);
        }
        return re;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        createNewUser(followerId);

        Set<Integer> temp = FollowerList.get(followerId);
        temp.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (FollowerList.containsKey(followerId) && followerId != followeeId) {
            HashSet<Integer> temp = FollowerList.get(followerId);
            temp.remove(followeeId);
        }
    }

    private void createNewUser(int followerId) {
        if (!FollowerList.containsKey(followerId)) {
            HashSet<Integer> followerset = new HashSet<>();
            followerset.add(followerId);
            FollowerList.put(followerId, followerset);
        }
    }

    public static void main(String[] args) {
        Twitter sol = new Twitter();
        List<Integer> re;
        sol.postTweet(1, 1);
//        List<Integer> re = sol.getNewsFeed(1);
//        for (int item : re) {
//            System.out.printf("%d ", item);
//        }
        sol.follow(2, 1);
        re = sol.getNewsFeed(2);
    }

    class tweet implements Comparable<tweet> {
        int time;
        int id;

        tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }

        public int compareTo(tweet that) {
            // priorityqueue maintain the least element
            return -(this.time - that.time);
        }
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