package com.gustofusion.gestioncommentaires.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gustofusion.gestioncommentaires.persistance.entities.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
	@Query("SELECT c FROM Comment c WHERE c.commentator.commentatorId = :commentatorId")
	List<Comment> findByCommentatorId(@Param("commentatorId") long commentatorId);


}
