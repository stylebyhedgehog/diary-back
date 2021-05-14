package org.example.diary.service;

import org.example.diary.entity.Entry;
import org.example.diary.entity.User;
import org.example.diary.repository.EntryRepository;
import org.example.diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    private final UserRepository userRepository;

    public EntryService(@Autowired EntryRepository entryRepository, @Autowired UserRepository userRepository) {
        this.entryRepository = entryRepository;
        this.userRepository = userRepository;
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userName= auth.getName();
    }

    public Entry addEntry(Long idUser,Entry entry){
        User user = userRepository.findById(idUser).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User Not Found"));
        entry.setDate(new Date());
        entry.setUser(user);
        return entryRepository.save(entry);
    }

    public Set<Entry> getEntries(Long idUser){
        User user = userRepository.findById(idUser).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User Not Found"));
        return user.getEntries();
    }

    public Entry getEntry(Long id){
        return entryRepository.findById(id).orElseThrow(()->
         new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Entry Not Found"));
    }
    public Entry deleteEntry(Long id){
        Entry entry= getEntry(id);
        entryRepository.delete(entry);
        return entry;
    }

    public Entry editEntry(Long id, Entry entry){
        Entry editEntry = getEntry(id);
        editEntry.setTitle(entry.getTitle());
        editEntry.setText(entry.getText());
        editEntry.setDate(new Date());
        entryRepository.save(editEntry);
        return editEntry;
    }
}
