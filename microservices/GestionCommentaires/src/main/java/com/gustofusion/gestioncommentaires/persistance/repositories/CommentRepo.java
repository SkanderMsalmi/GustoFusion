package com.gustofusion.gestioncommentaires.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustofusion.gestioncommentaires.persistance.entities.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
