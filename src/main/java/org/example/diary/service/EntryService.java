package org.example.diary.service;

import org.example.diary.entity.Entry;
import org.example.diary.entity.User;
import org.example.diary.repository.EntryRepository;
import org.example.diary.security.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Date;
import java.util.Set;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    private final UserService userService;
    private final AccessService accessService;

    @Autowired
    public EntryService(EntryRepository entryRepository, UserService userService, AccessService accessService) {
        this.entryRepository = entryRepository;
        this.userService = userService;
        this.accessService = accessService;
    }

    public Entry addEntry(Long idUser,Entry entry){
        User user = userService.getUserById(idUser);
        accessService.checkPermissionsForPage(idUser);
        entry.setDate(new Date());
        entry.setUser(user);
        return entryRepository.save(entry);
    }

    public Set<Entry> getEntries(Long idUser){
        User user = userService.getUserById(idUser);
//        accessService.checkPermissions(idUser);
        return user.getEntries();
    }

    public Entry getEntry(Long idUser, Long id){
        Entry entry= entryRepository.findById(id).orElseThrow(()->
         new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Запись не найдена"));
        accessService.checkPermissionsForPage(idUser);
        return entry;
    }
    public Entry deleteEntry(Long idUser, Long id){
        Entry entry= getEntry( idUser, id);
        accessService.checkPermissionsForObject(entry);
        entryRepository.delete(entry);
        return entry;
    }

    public Entry editEntry(Long idUser, Long id, Entry entry){
        Entry editEntry = getEntry(idUser,id);
        editEntry.setTitle(entry.getTitle());
        editEntry.setText(entry.getText());
        editEntry.setDate(new Date());
        accessService.checkPermissionsForObject(editEntry);
        entryRepository.save(editEntry);
        return editEntry;
    }

}
