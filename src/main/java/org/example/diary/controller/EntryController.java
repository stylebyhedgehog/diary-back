package org.example.diary.controller;

import org.example.diary.entity.Entry;
import org.example.diary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user/{idUser}/entries")
public class EntryController {
    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }
    @PostMapping
    public @ResponseBody
    Entry addEntry(@PathVariable Long idUser,@RequestBody final Entry entry){
        return entryService.addEntry(idUser,entry);
    }

    @GetMapping("/{id}")
    public Entry getEntry(@PathVariable Long id) {
        return entryService.getEntry(id);
    }

    @GetMapping()
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public  @ResponseBody
    Set<Entry> getEntries(@PathVariable Long idUser){
        return entryService.getEntries(idUser);
    }

    @PutMapping("/{id}")
    public Entry editEntry(@PathVariable final Long id, @RequestBody Entry entry){
        return entryService.editEntry(id,entry);
    }

    @DeleteMapping("/{id}")
    public Entry deleteEntry(@PathVariable final Long id){
        return entryService.deleteEntry(id);
    }


}