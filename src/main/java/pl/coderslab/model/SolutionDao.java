package pl.coderslab.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {


    public static List<Solution> loadFirst(int i) {
        ArrayList<Solution> solutions = new ArrayList<>();
        solutions.add(new Solution(1L, 1L, "Hello", "Nie umiem", LocalDateTime.now()));
        return solutions;
    }
}
