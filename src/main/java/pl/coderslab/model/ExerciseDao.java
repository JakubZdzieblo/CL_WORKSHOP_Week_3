package pl.coderslab.model;

import pl.coderslab.service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {

    public static void save(Exercise exercise) {
        if (exercise.getId() == 0) {
            addToDb(exercise);
        } else {
            updateInDb(exercise);
        }
    }

    public static Exercise getByIndex(int index) {
        String query = "select * from `exercise` where `id`=?";
        String[] param = { String.valueOf(index) };

        return getSingleData(query, param);
    }

    public static Exercise getByTitle(String title) {
        String query = "select * from `exercise` where `title`=?";
        String[] param = { title };

        return getSingleData(query, param);
    }

    public static List<Exercise> loadAll(){
        String query = "select * from `exercise`";
        List<Exercise> loadedAll = new ArrayList<>();
        try {
            List<String[]> result = DBService.getData(query, null);
            for (String[] row : result) {
                loadedAll.add(createSingleExerciseObject(row));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadedAll;
    }

    public static List<Exercise> loadExcluded(int userId) {
        String query = "select distinct e.* from exercise e where not exists (\n" +
                "    select * from exercise e2 join solution s on e2.id = s.exercise_id where e2.id=e.id and s.users_id =?\n" +
                "    )";
        List<Exercise> list = new ArrayList<>();
        String[] param = {Integer.toString(userId)};
        try {
            List<String[]> result = DBService.getData(query, param);
            for (String[] row : result) {
                list.add(createSingleExerciseObject(row));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static void delete(Exercise exercise) {
        String query = "delete from `exercise` where id=?";
        String[] params = {String.valueOf(exercise.getId())};
        try {
            DBService.executeQuery(query, params);
            exercise = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        Exercise exercise = getByIndex(id);
        delete(exercise);
    }


    private static void addToDb(Exercise exercise) {
        String query = "insert into `exercise` values (null, ?, ?)";
        String[] params = new String[2];
        params[0] = exercise.getTitle();
        params[1] = exercise.getDescription();

        try {
            int index = DBService.executeInsert(query, params);
            exercise.setId(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateInDb(Exercise exercise) {
        String query = "update `exercise` set `title`=?, `description`=? where id=?";
        String[] params = new String[3];
        params[0] = exercise.getTitle();
        params[1] = exercise.getDescription();
        params[2] = String.valueOf(exercise.getId());

        try {
            DBService.executeQuery(query, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Exercise getSingleData(String query, String[] params) {
        try {
            List<String[]> data = DBService.getData(query, params);
            if (data.size() > 0) {
                return createSingleExerciseObject(data.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Exercise createSingleExerciseObject(String[] element) {
        int elementId = Integer.valueOf(element[0]);
        String elementTitle = element[1];
        String elementDescription = element[2];

        Exercise exercise = new Exercise();
        exercise.setId(elementId);
        exercise.setTitle(elementTitle);
        exercise.setDescription(elementDescription);
        return exercise;
    }

}
