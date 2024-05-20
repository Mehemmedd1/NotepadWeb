package com.NotepadWeb.NotepadWebBackEnd.Service;


import com.NotepadWeb.NotepadWebBackEnd.Entity.Note;
import com.NotepadWeb.NotepadWebBackEnd.Repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAll() {
         return (List<Note>) noteRepository.findAll();

    }

    public Note getById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note addNote(Note newNote) {
        return noteRepository.save(newNote);
    }

    public Note updateNote(Long id, Note updNote) {
        Optional<Note> note=noteRepository.findById(id);
        if (note.isPresent()) {
            Note foundNote=note.get();
            foundNote.setTitle(updNote.getTitle());
            foundNote.setMain(updNote.getMain());
            noteRepository.save(foundNote);
            return foundNote;

        }else{
            return null;
        }

    }

    public void deleteNote(Long id) {
        try {
            noteRepository.deleteById(id);

        }catch (EmptyStackException e){
            System.out.println("Note "+id+" doesn't exist");

        }

    }
}
