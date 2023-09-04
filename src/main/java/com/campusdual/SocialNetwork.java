package com.campusdual;

import java.util.List;

public class SocialNetwork {
    private List<User> userList;

    public SocialNetwork(List<User> userList) {
        this.userList = userList;
    }

    public SocialNetwork(){

    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUserByName(String name){
        for (User user:
             userList) {
            if (user.getName().equals(name)){
                return user;
            }
        }
        //todo throw exception
        return null;
    }

    // ---- features
    public void addUser(User user){
        this.userList.add(user);
    }
    public void deleteUser(User user){this.userList.remove(user);}

    public void showCommentsByUser(User user){
        for (User u: userList) {
            for (Post p: u.getPosts()) {
                for (Comment c: p.getCommentList()) {
                    if (c.getOwner().equals(user)){
                        System.out.println(c.getText());
                    }
                }
            }

        }
    }

}
