package com.campusdual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void suggest(User actualUser){
        List<User> posibleSuggestions = new ArrayList<>();
        List<User> suggestions = new ArrayList<>();
        for (User user:
             actualUser.getFriends()) {
            if(user != null) {
                for (User posibleFriend :
                        user.getFriends()) {
                    if (!posibleSuggestions.contains(posibleFriend)) {
                        posibleSuggestions.add(posibleFriend);
                    } else {
                        suggestions.add(posibleFriend);
                    }
                }
            }
        }

        Map<User, Integer> suggestionsMap = new HashMap<>();


        for (User suggestion : suggestions) {
            if (suggestion!=null){
                if(suggestionsMap.containsKey(suggestion)){
                    suggestionsMap.put(suggestion, suggestionsMap.get(suggestion) + 1);
                }else{
                    suggestionsMap.put(suggestion, 1);
                }
            }
        }

        System.out.println("Sugerencias de amigos: ");
        for (Map.Entry<User, Integer> entry : suggestionsMap.entrySet()){
            if (!entry.getKey().equals(actualUser)){
                if(entry.getValue() > 1){
                    System.out.println("User: " + entry.getKey().getName() + ", Ocurrencias" + entry.getValue());
                };
            }
        }
    }
}
