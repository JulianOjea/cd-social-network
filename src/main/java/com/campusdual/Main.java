package com.campusdual;

import com.campusdual.util.Input;

import java.util.Calendar;

public class Main {

    public static SocialNetwork generateData() throws Exception {
        SocialNetwork sN = new SocialNetwork();

        User u0 = new User("Adam");
        User u1 = new User("Betty");
        User u2 = new User("Carl");

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

        u0.follow(u1);
        u0.follow(u2);

        return  sN;
    };

    public static User inputUser(){
        return new User(Input.string("Nombre: "));
    }

    public static Post inputPost(){

        switch (Input.string("¿Qué tipo de post quiere añadir?")){
            case "Imagen":
                return new Image(
                        Input.integer("Id del Post: "),
                        Calendar.getInstance(),
                        Input.string("Titulo: "),
                        120,
                        200
                        );
            case "Video": return new Video(
                    Input.integer("Id del Post: "),
                    Calendar.getInstance(),
                    Input.string("Titulo: "),
                    "HD",
                    120);
            case "Texto": return new Text(
                    Input.integer("Id del Post: "),
                    Calendar.getInstance(),
                    Input.string("Contenido: ")
            );
            default:
                return null;
        }
    }

    public static void main(String[] args) throws Exception {

        SocialNetwork sN = generateData();

        boolean flag = true;
        while(flag){
            System.out.println(
                    "1 - Añadir usuario\n" +
                    "2 - Añadir post\n" +
                    "3 - Añadir comentario\n" +
                    "4 - Seguir a un usuario\n" +
                    "5 - Dejar de seguir a un usuario\n" +
                    "6 - Eliminar usuario\n" +
                    "7 - Eliminar post\n" +
                    "8 - Eliminar comentario\n" +
                    "9 - Listar todos los posts de un usuario\n" +
                    "10 - Listar los comentarios de un usuario\n" +
                    "11 - Mostrar el número de comentarios que tiene un post\n" +
                    "12 - Mostrar el muro de un usuario\n" +
                    "0 - Salir");


            int inputInteger = Input.integer("Seleccione de la lista . . . ");

            String name;
            User user;
            Post post;

            switch (inputInteger){
                case 1:
                    user = new User(Input.string("Nombre: "));
                    sN.addUser(user);
                    break;
                case 2:
                    user = sN.getUserByName(Input.string("Nombre del usuario que postea: "));
                    post = inputPost();
                    user.addPost(post);
                    break;
                case 3:
                    User owner = sN.getUserByName(Input.string("Nombre del usuario que comenta: "));
                    user = sN.getUserByName(Input.string("Nombre del usuario sobre el que se comenta: "));
                    post = user.getPostById(Input.integer("Id del post sobre el que se comenta: "));
                    String content = Input.string("Comentario: ");
                    post.addComment(new Comment(content, Calendar.getInstance(), owner));
                    break;
                case 4:
                    user = sN.getUserByName(Input.string("Nombre del usuario que quiere hacer follow: "));
                    user.follow(sN.getUserByName(Input.string("Nombre del usuario a seguir: ")));
                    break;
                case 5:
                    user = sN.getUserByName(Input.string("Nombre del usuario que quiere hacer unfollow: "));
                    user.unFollow(sN.getUserByName(Input.string("Nombre del usuario a dejar de seguir: ")));
                    break;
                case 6:
                    user = sN.getUserByName(Input.string("Nombre del usuario a eliminar: "));
                    sN.deleteUser(user);
                    break;
                case 7:
                    user = sN.getUserByName(Input.string("Nombre del usuario del que se quiere eliminar un post: "));
                    user.deletePost(user.getPostById(Input.integer("Id del post a eliminar: ")));
                    break;
                //TODO aqui hay dos maneras de eliminar un comentario, podria eliminarlo el usuario que lo contiene o
                //TODO usuario que lo ha posteado, solo se implementa eliminacion sobre el que lo contiene
                case 8:
                    user = sN.getUserByName(Input.string("Nombre del usuario del que se quiere eliminar un comentario: "));
                    post = user.getPostById(Input.integer("Id del post del que se quiere eliminar un comentario: "));
                    post.deleteComment(post.findCommentById(Input.integer("Id del comentario que se quiere eliminar: ")));
                    break;
                case 9:
                    System.out.println("Post de un usuario:");
                    name = Input.string();
                    user = sN.getUserByName(name);
                    user.showPosts();
                    break;
                case 10:
                    System.out.println("Comentarios de un usuario:");
                    name = Input.string();
                    user = sN.getUserByName(name);
                    sN.showCommentsByUser(user);
                    break;
                case 11:
                    System.out.println("Comentarios de un post:");
                    name = Input.string("Seleccione un usuario . . .");
                    user = sN.getUserByName(name);
                    post = user.getPostById( Input.integer("Seleccione un post . . .") );
                    System.out.println("Número de comentarios " + post.getNumberOfComments());
                    break;
                case 12:
                    user = sN.getUserByName(Input.string("Nombre del usuario para visualizar su muro: "));
                    user.generateWall();
                    break;
                case 0:
                    System.out.println("Saliendo . . . ");
                    flag = false;
            }

        }
    }
}
