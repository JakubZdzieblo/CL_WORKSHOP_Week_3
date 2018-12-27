package pl.coderslab.model;

import pl.coderslab.service.DBService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {


    public static List<Solution> loadFirst(int lim) {
        String query = "select * from `solution` order by `created` desc limit " + lim;
        return getSolutions(query, null);
    }

    public static List<Solution> loadAllByUserId (int id) {
        String query = "select * from `solution` where `users_id` = ?";
        String[] param = { String.valueOf(id) };
        return getSolutions(query, param);
    }

    public static List<Solution> loadAllByExerciseId (int id) {
        String query = "select * from `solution` where `exercise_id` = ? order by `updated` desc";
        String[] param = { String.valueOf(id) };
        return getSolutions(query, param);
    }

    private static List<Solution> getSolutions(String query, String[] param) {
        List<Solution> result = new ArrayList<>();
        try {
            List<String[]> data = DBService.getData(query, param);
            for (String[] row : data) {
                result.add(createSingleSolutionObject(row));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void delete(int id){
        String query = "Delete from `solution` where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        try {
            DBService.executeQuery(query, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void save(Solution solution){

        if(solution.getId() == 0){
            addToDb(solution);
        }else{
            updateInDb(solution);
        }

    }

    public static Solution getById(int id){
        String query = "Select * from `solution` Where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        return getSingleData(query, params);
    }

    public static List<Solution> loadAll(){
        String query = "Select * from `solution`;";

        List<Solution> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, null);
            for(String[] row : data){
                Solution solution = createSingleSolutionObject(row);
                result.add(solution);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static void addToDb(Solution solution){

        String query = "Insert into `solution` Values (null,?,?,?,?,?);";
        String[] params = new String[5];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        params[0] = solution.getCreated().format(formatter);

        if (solution.getUpdated() == null) {
            params[1] = null;
        } else {
            params[1] = solution.getUpdated().format(formatter);
        }

        params[2] = solution.getDescription();
        params[3] = String.valueOf(solution.getExerciseId());
        params[4] = String.valueOf(solution.getUserId());

        try {
            int newId = DBService.executeInsert(query, params);
            solution.setId(newId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateInDb(Solution solution){

        String query = "Update `solution` Set " +
                "`created` = ?," +
                "`updated` = ?," +
                "`description` = ?," +
                "`exercise_id` = ?," +
                "`users_id` = ?" +
                " Where `id` = ?;";

        String[] params = new String[6];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        params[0] = solution.getCreated().format(formatter);
        params[1] = solution.getUpdated().format(formatter);
        params[2] = solution.getDescription();
        params[3] = String.valueOf(solution.getExerciseId());
        params[4] = String.valueOf(solution.getUserId());
        params[5] = String.valueOf(solution.getId());

        try {
            DBService.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static Solution getSingleData(String query, String[] params) {
        try {
            List<String[]> data = DBService.getData(query, params);
            if (data.size() > 0) {
                String[] firstElement = data.get(0);
                return createSingleSolutionObject(firstElement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Solution createSingleSolutionObject(String[] el) {
        int elId = Integer.valueOf(el[0]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime elCreated = null;
        LocalDateTime elUpdated = null;
        if (el[1] != null) {elCreated = LocalDateTime.parse(el[1], formatter);}
        if (el[2] != null) {elUpdated = LocalDateTime.parse(el[2], formatter);}

        String elDescription = el[3];
        int elExerciseId = Integer.parseInt(el[4]);
        int elUsersId = Integer.parseInt(el[5]);

        Solution solution = new Solution();
        solution.setId(elId);
        solution.setCreated(elCreated);
        solution.setUpdated(elUpdated);
        solution.setDescription(elDescription);
        solution.setExerciseId(elExerciseId);
        solution.setUserId(elUsersId);

        return solution;

    }



}
