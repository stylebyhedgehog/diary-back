package org.example.diary.service;

import org.example.diary.entity.Entry;
import org.example.diary.entity.Todo;
import org.example.diary.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
@Service
public class ActivityService {
    public Integer getCompletedTodosCount(User user){
        Set<Todo> todos=user.getTodos();
        int total=0;
        for(Todo todo: todos){
            if (todo.isCompleted()&& getDateDiff(todo.getDate(), new Date())<=7){total+=1;}
        }
        return total;
    }
    public Integer getEntriesCount(User user){
        Set<Entry> entries=user.getEntries();
        int total=0;
        for(Entry entry: entries){
            if ( getDateDiff(entry.getDate(), new Date())<=7){total+=1;}
        }
        return total;
    }
    public Long getDateDiff(Date date1, Date date2){
        long interval = date1.getTime()- date2.getTime();
        return interval/ (24 * 60 * 60 * 1000);
    }
}
