package pl.coderslab.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Solution {

    private Long id;
    private Long userId;
    private String exercise;
    private String content;
    private LocalDateTime created;

    public Solution() {
    }

    public Solution(Long id, Long userId, String exercise, String content, LocalDateTime created) {
        this.id = id;
        this.userId = userId;
        this.exercise = exercise;
        this.content = content;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", userId=" + userId +
                ", exercise='" + exercise + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(id, solution.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }



}
