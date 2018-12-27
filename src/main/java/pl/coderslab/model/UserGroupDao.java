package pl.coderslab.model;

import pl.coderslab.service.DBService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {


    public static void delete(UserGroup group){
        String query = "Delete from `user_group` where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(group.getId());

        try {
            DBService.executeQuery(query, params);
            group = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        UserGroup group = getById(id);
        delete(group);
    }

    public static void save(UserGroup group){

        if(group.getId() == 0){
            addToDb(group);
        }else{
            updateInDb(group);
        }

    }

    public static UserGroup getById(int id){
        String query = "Select `id`, `name` from `user_group` Where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        UserGroup group = null;

        UserGroup group1 = getSingleData(query, params);

        if (group1 != null) return group1;

        return null;
    }

    public static UserGroup getByName(String name){
        String query = "Select `id`, `name` from `user_group` Where `name` = ?;";
        String[] params = new String[1];
        params[0] = name;

        UserGroup group = getSingleData(query, params);

        if (group != null) return group;

        return null;
    }


    public static List<UserGroup> loadAll(){
        String query = "Select `id`, `name` from `user_group`;";
        //prepare list for data from DB
        List<UserGroup> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, null);

            for(String[] row : data){
                int id = Integer.parseInt(row[0]);
                String name = row[1];

                UserGroup group = new UserGroup(id, name);

                result.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    private static void addToDb(UserGroup group){

        String query = "Insert into `user_group` Values (?,?);";
        String[] params = new String[2];
        params[0] = String.valueOf(group.getId());
        params[1] =group.getName();

        try {
            int newId = DBService.executeInsert(query, params);
            group.setId(newId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateInDb(UserGroup group){

        String query = "Update `user_group` Set `name` = ? Where `id` = ?;";
        String[] params = new String[2];
        params[0] =group.getName();
        params[1] = String.valueOf(group.getId());

        try {
            DBService.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static UserGroup getSingleData(String query, String[] params) {
        UserGroup group;
        try {
            List<String[]> data = DBService.getData(query, params);
            if (data.size() > 0) {
                String[] firstElement = data.get(0);
                int elementId = Integer.valueOf(firstElement[0]);
                String name = firstElement[1];

                group = new UserGroup(elementId, name);
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
