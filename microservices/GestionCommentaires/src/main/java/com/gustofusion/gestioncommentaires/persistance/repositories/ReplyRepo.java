package com.gustofusion.gestioncommentaires.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gustofusion.gestioncommentaires.persistance.entities.Reply;

@Repository
public interface ReplyRepo extends JpaRepository<Reply, Long>{
	
	@Query("SELECT r FROM Reply r WHERE r.comment.commentId = :commentId")
	List<Reply> findByCommentId(@Param("commentId") long commentId);
	
	@Query("SELECT c FROM Comment c WHERE c.commentator.commentatorId = :commentatorId")
	List<Reply> findByCommentatorId(@Param("commentatorId") long commentatorId);


}
