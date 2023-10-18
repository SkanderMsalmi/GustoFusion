package com.gustofusion.gestioncommentaires.services.interfaces;

import java.util.List;

import com.gustofusion.gestioncommentaires.persistance.entities.Comment;
import com.gustofusion.gestioncommentaires.persistance.entities.Commentator;
import com.gustofusion.gestioncommentaires.persistance.entities.Reply;

public interface AllServices {
	
	public void addCommentAndAssignToUser (Commentator user, Comment content);
	
	public Comment editComment (Comment content);
	
	public void deleteComment (long commentId);
	
	public void addReplyAndAssignToUserAndComment (Commentator user, long commentId, Reply content);
	
	public Reply editReply (Reply content);
	
	public void deleteReply (long replyId);
	
	public List<Comment> showAllComments();
	
	public List<Reply> showRepliesByComment(long commentId);
	
	public List<Comment> showCommentsByUser (long commentatorId);
	
	public List <Reply> showRepliesByUser (long commentatorId);

}
