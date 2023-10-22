package com.gustofusion.gestioncommentaires.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustofusion.gestioncommentaires.persistance.entities.Comment;
import com.gustofusion.gestioncommentaires.persistance.entities.Commentator;
import com.gustofusion.gestioncommentaires.persistance.entities.Reply;
import com.gustofusion.gestioncommentaires.persistance.repositories.CommentRepo;
import com.gustofusion.gestioncommentaires.persistance.repositories.CommentatorRepo;
import com.gustofusion.gestioncommentaires.persistance.repositories.ReplyRepo;
import com.gustofusion.gestioncommentaires.services.interfaces.AllServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AllServicesImpl implements AllServices{
	
	@Autowired
    private CommentatorRepo commentatorRepository;

    @Autowired
    private CommentRepo comRep;
    
    @Autowired
    private ReplyRepo replyRepository;
	
	@Override
	@Transactional
	public void addCommentAndAssignToUser(Comment content) {
		// Save the commentator (user) to the database
        Commentator savedUser = commentatorRepository.save(content.getCommentator());

        // Associate the comment with the saved commentator
        content.setCommentator(savedUser);

        // Save the comment to the database
        comRep.save(content);
		
	}

	@Override
	public Comment editComment(Comment content) {
		// Check if the comment exists in the database
		if (!comRep.existsById(content.getCommentId())) {
		    throw new IllegalArgumentException("Comment with the provided ID does not exist.");
		}

        // Save the updated comment to the database and return
        return comRep.save(content);
	}

	@Override
	public void deleteComment(long commentId) {
		if (!comRep.existsById(commentId)) {
            throw new IllegalArgumentException("Comment with the provided ID does not exist.");
        }

        // Delete the comment from the database
        comRep.deleteById(commentId);
		
	}

	@Override
	@Transactional
	public void addReplyAndAssignToUserAndComment(long commentId, Reply content) {
		// Save the commentator (user) to the database
        Commentator savedUser = commentatorRepository.save(content.getCommentator());

        // Fetch the existing comment from the database
        Comment existingComment = comRep.findById(commentId)
            .orElseThrow(() -> new IllegalArgumentException("Comment with the provided ID does not exist."));

        // Associate the reply with the saved commentator and the existing comment
        content.setCommentator(savedUser);
        content.setComment(existingComment);

        // Save the reply to the database
        replyRepository.save(content);
		
	}

	@Override
	public Reply editReply(Reply content) {
		// Fetch the existing reply from the database using its ID
        Reply existingReply = replyRepository.findById(content.getReplyId())
            .orElseThrow(() -> new IllegalArgumentException("Reply with the provided ID does not exist."));

        // Update the fields of the fetched reply with the new content provided
        existingReply.setText(content.getText());
        // Add any other fields you want to update here

        // Save the updated reply back to the database
        return replyRepository.save(existingReply);
	}

	@Override
	public void deleteReply(long replyId) {
		// Check if the reply exists in the database
        if (!replyRepository.existsById(replyId)) {
            throw new IllegalArgumentException("Reply with the provided ID does not exist.");
        }

        // Delete the reply from the database
        replyRepository.deleteById(replyId);
		
	}

	@Override
	public List<Comment> showAllComments() {
		// Fetch all the comments from the database
        return comRep.findAll();
	}

	@Override
	public List<Reply> showRepliesByComment(long commentId) {
		// Fetch all the replies associated with the given commentId from the database
        return replyRepository.findByCommentId(commentId);
	}

	@Override
	public List<Comment> showCommentsByUser(long commentatorId) {
		// Fetch all the comments associated with the given commentatorId from the database
        return comRep.findByCommentatorId(commentatorId);
	}

	@Override
	public List<Reply> showRepliesByUser(long commentatorId) {
		// Fetch all the replies made by the given commentatorId from the database
        return replyRepository.findByCommentatorId(commentatorId);
	}

}
