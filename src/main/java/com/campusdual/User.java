package com.campusdual;

import java.util.*;

public class User {
    private String name;
    private List<User> followedUsers = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    /*
    public User(String name, List<User> followedUsers, List<Post> posts) {
        this.name = name;
        this.followedUsers = followedUsers;
        this.posts = posts;
    }*/

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(List<User> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getFollowedUsers(), user.getFollowedUsers()) && Objects.equals(getPosts(), user.getPosts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFollowedUsers(), getPosts());
    }

    //--------------features
    public void addPost(Post post){
        this.posts.add(post);
    };

    public void follow(User user) throws Exception {
        boolean flag = true;
        for (User u : this.followedUsers) {
            if (user.equals(u)) {
                flag = false;
                break;
            }
        }

        if (flag){
            this.followedUsers.add(user);
        } else {
            throw new Exception("This user was already followed");
        }
    }

    public void unFollow(User user) throws Exception {
        boolean flag = true;
        for (User u : this.followedUsers) {
            if (user.equals(u)) {
                flag = false;
                break;
            }
        }

        if (!flag) {
            this.followedUsers.remove(user);
        } else {
            throw new Exception("This user was not followed");
        }
    }

    public void deletePost(Post post){
        this.posts.remove(post);
    }

    public void showPosts(){
        for (Post post:
             posts) {
            System.out.println(post.showPost() + "\n");
        }
    }

    public Post getPostById(int id){
        for (Post p:
                posts) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

     public void generateWall(){
        List<Post> postList = new ArrayList<>();
         for (User u:
              followedUsers) {
             postList.addAll(u.posts);
         }
         Collections.sort(postList, new Comparator<Post>(){
             public int compare(Post p1, Post p2){
                return p1.getDate().compareTo(p2.getDate());
             }
         });

         for (int i = 0; i < postList.size(); i++) {
             System.out.println(postList.get(i).showPost());
             if (i>10){
                 break;
             }
         }
     }
}