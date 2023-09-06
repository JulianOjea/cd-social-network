package com.campusdual;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<User> userList = new ArrayList<>();

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

    public void suggestFriends(User user) {
        List<User> suggestions = new ArrayList<>();

        for (User friend : this.userList) {
            // Evitar sugerir al propio usuario ni a sus amigos actuales
            if (friend != user && !user.getFriends().contains(friend)) {
                // Calcular la cantidad de amigos en común
                int amigosEnComun = 0;
                List<User> amigosDelOtro = friend.getFriends();
                for (User amigo : user.getFriends()) {
                    if (amigosDelOtro.contains(amigo)) {
                        amigosEnComun++;
                    }
                }

                // Si tienen al menos un amigo en común, agregarlo a las sugerencias
                if (amigosEnComun > 0) {
                    suggestions.add(friend);
                }
            }
        }

        for (User u:
                suggestions) {
            System.out.println(u.getName());
        }
    }

}
