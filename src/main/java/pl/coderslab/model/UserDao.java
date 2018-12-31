package pl.coderslab.model;

import pl.coderslab.service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static void save(User user){

        if(user.getId() == 0){
            addToDb(user);
        }else{
            updateInDb(user);
        }

    }

    public static List<User> loadAllByGroupId(int id){
        String query = "select * from users where user_group_id=?";
        String[] param = { String.valueOf(id) };
        List<User> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, param);
            for (String[] row : data) {
                result.add(createSingleUserObject(row));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static User getById(int id){
        String query = "Select * from `users` Where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        return getSingleData(query, params);
    }

    public static User getByUsername(String name){
        String query = "Select * from `users` Where `username` = ?;";
        String[] params = new String[1];
        params[0] = name;

        return getSingleData(query, params);
    }


    public static List<User> loadAll(){
        String query = "Select * from `users`;";

        //prepare list for data from DB
        List<User> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, null);

            for(String[] row : data){
                User user = createSingleUserObject(row);
                result.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    private static void addToDb(User user){

        String query = "Insert into `users` Values (null,?,?,?,?);";
        String[] params = new String[4];
        params[0] = String.valueOf(user.getUsername());
        params[1] = user.getEmail();
        params[2] = user.getPassword();
        params[3] = String.valueOf(user.getUserGroupId());

        try {
            int newId = DBService.executeInsert(query, params);
            user.setId(newId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateInDb(User user){

        String query = "Update `users` Set " +
                "`username` = ?," +
                "`email` = ?," +
                "`password` = ?," +
                "`user_group_id` = ?" +
                " Where `id` = ?;";

        String[] params = new String[5];
        params[0] = user.getUsername();
        params[1] = user.getEmail();
        //TODO - encode if changed
        params[2] = user.getPassword();
        params[3] = String.valueOf(user.getUserGroupId());
        params[4] = String.valueOf(user.getId());

        try {
            DBService.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(User user){
        String query = "Delete from `users` where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(user.getId());

        try {
            DBService.executeQuery(query, params);
            user = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        User user = getById(id);
        delete(user);
    }


    private static User getSingleData(String query, String[] params) {
        try {
            List<String[]> data = DBService.getData(query, params);
            if (data.size() > 0) {
                String[] firstElement = data.get(0);
                return createSingleUserObject(firstElement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static User createSingleUserObject(String[] element) {

        int elementId = Integer.valueOf(element[0]);
        String elementUsername = element[1];
        String elementEmail = element[2];
        String elementPassword = element[3];
        int elementGroupId = Integer.parseInt(element[4]);

        User user = new User();
        user.setId(elementId);
        user.setUsername(elementUsername);
        user.setEmail(elementEmail);
        user.setPassword(elementPassword);
        user.setUserGroupId(elementGroupId);
        return user;
    }

}
