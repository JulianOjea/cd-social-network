package com.campusdual;

import com.campusdual.util.Input;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        User u0 = new User("Adam");
        User u1 = new User("Betty");
        User u2 = new User("Carl");

        SocialNetwork sN = new SocialNetwork();

        sN.addUser(u0);
        sN.addUser(u1);
        sN.addUser(u2);

        //u0 posts
        Calendar cal =  Calendar.getInstance();
        cal.set(2020, Calendar.JANUARY, 15);
        Post p0 = new Video(0, cal, "Ducks swimming", "HQ", 120);
        cal.set(2020, Calendar.NOVEMBER, 12);
        Post p1 = new Image(1, cal, "Cute cat", 100, 200);

        //u1 posts
        cal.set(2020, Calendar.MARCH, 8);
        Post p2 = new Text(2, cal, "Im just writing about my life.");
        cal.set(2022, Calendar.DECEMBER, 25);
        Post p3 = new Image(3, cal, "My new house", 100, 200);
        cal.set(2021, Calendar.APRIL, 2);
        Post p4 = new Video(4, cal, "Me walking", "HQ", 120);

        //u2 posts
        cal.set(2019, Calendar.MARCH, 15);
        Post p5 = new Text(5, cal, "Yesterday was an awesome day.");

        u0.addPost(p0);
        u0.addPost(p1);
        u1.addPost(p2);
        u1.addPost(p3);
        u1.addPost(p4);
        u2.addPost(p5);

        cal.set(2022, Calendar.APRIL, 2);
        Comment c0 = new Comment("Your post is horrible o.O", cal, u0);
        cal.set(2022, Calendar.APRIL, 17);
        Comment c1 = new Comment("I really think earth is flat", cal, u0);
        cal.set(2022, Calendar.FEBRUARY, 3);
        Comment c2 = new Comment("Please shut up!", cal, u2);

        p0.addComment(c0);
        p0.addComment(c1);
        p1.addComment(c2);

        while(true){
            System.out.println("1 - Listar todos los posts de un usuario\n" +
                    "2 - Listar los comentarios de un usuario\n" +
                    "3 - Mostrar el número de comentarios que tiene un post\n" +
                    "0 - Salir");

            int input = Input.integer();
            String name;
            User user;

            switch (input){
                case 1:
                    name = Input.string();
                    user = sN.getUserByName(name);
                    user.showPosts();
                    break;
                case 2:
                    name = Input.string();
                    user = sN.getUserByName(name);
                    sN.showCommentsByUser(user);
                    break;
                case 3:
                    break;
            }

        }
    }
}
