package com.NotepadWeb.NotepadWebBackEnd.Repository;


import com.NotepadWeb.NotepadWebBackEnd.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface NoteRepository extends JpaRepository<Note,Long > {


}
