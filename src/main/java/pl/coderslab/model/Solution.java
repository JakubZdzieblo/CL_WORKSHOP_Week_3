package pl.coderslab.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Solution {

    private int id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String description;
    private int exerciseId;
    private int userId;

    public Solution() {
    }

    public Solution(int id, LocalDateTime created, LocalDateTime updated, String description, int exerciseId, int userId) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exerciseId = exerciseId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "id: " + id + " by " + userId + " to exercise " + exerciseId +"; '" + description + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(id, solution.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
