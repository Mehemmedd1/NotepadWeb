package com.NotepadWeb.NotepadWebBackEnd.Controller;


import com.NotepadWeb.NotepadWebBackEnd.Entity.Note;
import com.NotepadWeb.NotepadWebBackEnd.Security.UserPrincipal;
import com.NotepadWeb.NotepadWebBackEnd.Service.NoteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notepad")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal){
        return "you are logged in as a user " + principal.getEmail()+" UserId : "+
                principal.getUserId();
    }

    @GetMapping("/getall")

    public List<Note> getAll(){
        return (List<Note>) noteService.getAll();
    }
    @GetMapping("/{id}")

    public Note getById(@PathVariable Long id){
        Note note=  noteService.getById(id);
        if (note==null) {
            return null ;

        }else{
            return note;


        }
    }
    @PostMapping("/save")

    public ResponseEntity<Void> addNote(@RequestBody Note newNote){
        Note note=noteService.addNote(newNote);
        if (note != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/{id}")

    public ResponseEntity<Void> updateNote(@PathVariable Long id,@RequestBody Note updNote){
        Note note=noteService.updateNote(id,updNote);
        if (note != null) {
            return new ResponseEntity<>(HttpStatus.OK);

        }return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @DeleteMapping("/{id}")

    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return "You are Admin Welcome!"+" UserId "+userPrincipal.getUserId();

    }


}
