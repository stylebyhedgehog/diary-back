package org.example.diary.payload.response;

public class ActivityResponse {
    private Integer entriesCount;
    private Integer todosCompletedCount;

    public ActivityResponse(Integer entriesCount, Integer todosCompletedCount) {
        this.entriesCount = entriesCount;
        this.todosCompletedCount = todosCompletedCount;
    }

    public Integer getEntriesCount() {
        return entriesCount;
    }

    public void setEntriesCount(Integer entriesCount) {
        this.entriesCount = entriesCount;
    }

    public Integer getTodosCompletedCount() {
        return todosCompletedCount;
    }

    public void setTodosCompletedCount(Integer todosCompletedCount) {
        this.todosCompletedCount = todosCompletedCount;
    }
}
