package db;

import models.Comment;
import models.Item;
import models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    public DBManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/G115-JSP",
                    "postgres",
                    "14112006jj");
        } catch (Exception e) {
            // Обработка ошибки подключения к базе данных
            e.printStackTrace();
        }
    }

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, name, price, description,specification FROM items");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getString("price"));
                item.setDescription(resultSet.getString("description"));
                item.setDescription(resultSet.getString("specification"));
                items.add(item);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserByEmailAndPass(String email, String password) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select *from users where email = ? and password =?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(email);
                user.setPassword(password);
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getUser(String email) {


        User user = null;


        try {


            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? LIMIT 1");

            statement.setString(1, email);


            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                user = new User();

                user.setEmail(resultSet.getString("email"));

                user.setId(resultSet.getLong("id"));

                user.setPassword(resultSet.getString("password"));

                user.setFullName(resultSet.getString("full_name"));

            }


            statement.close();


        } catch (Exception e) {

            e.printStackTrace();

        }

        return user;

    }


    public static boolean addUser(User user) {


        int rows = 0;


        try {


            PreparedStatement statement = connection.prepareStatement("" +

                    "INSERT INTO users (email, password, full_name) " +

                    "VALUES (?, ?, ?)");


            statement.setString(1, user.getEmail());

            statement.setString(2, user.getPassword());

            statement.setString(3, user.getFullName());


            rows = statement.executeUpdate();

            statement.close();


        } catch (Exception e) {

            e.printStackTrace();

        }

        return rows > 0;

    }

    public static void addItem(String name, String description, String price, String specification) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into items(name, description, price, specification) values (?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, price);
            statement.setString(4, specification);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Item getItemById(Long id) {
        Item item = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select *from items where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item();
                item.setId(id);
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setDescription(resultSet.getString("price"));
                item.setDescription(resultSet.getString("specification"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    private static List<Item> items = new ArrayList<>();

    public static Item getItem(Long id) {
        Item item = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item();
                item.setId(id);
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getString("price"));
                item.setSpecification(resultSet.getString("specification"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
    public static void editItem(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE items "
                            + "SET name = ?, description = ?, price = ?, specification = ? "
                            + "WHERE id = ?");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getPrice());
            statement.setString(4, item.getSpecification());
            statement.setLong(5, item.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteItemById(Long id){
        try {
            PreparedStatement statement =connection.prepareStatement(
              "delete from items where id=?");
            statement.setLong(1,id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static User getUserById(Long id){
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select *from users where id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new User();
                user.setId(id);
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public static void peopleUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users "
                            + "SET email = ?, password = ?, full_name = ? "
                            + "WHERE id = ?");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
            statement.close(); // Закрыть Prepared Statement после использования
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addComment(String description,Long itemId,Long userId){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into comments(description,post_date,items_id,users_id)"
                    +"values (?,now(),?,?)");
            statement.setString(1 , description);
            statement.setLong(2 , itemId);
            statement.setLong(3 , userId);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Comment> getCommentsByItemId(Long itemId) {
        List<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.id, c.description, c.post_date, c.users_id, u.full_name " +
                            "FROM comments c " +
                            "INNER JOIN users u ON c.users_id = u.id " +
                            "WHERE c.items_id = ?");
            statement.setLong(1, itemId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setDescription(resultSet.getString("description"));
                comment.setPostDate(resultSet.getDate("post_date"));
                User user = new User();
                user.setId(resultSet.getLong("users_id"));
                user.setFullName(resultSet.getString("full_name"));
                comment.setUser(user);
                comments.add(comment);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }
    public static void deleteCommentById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from comments "
                            + "where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


