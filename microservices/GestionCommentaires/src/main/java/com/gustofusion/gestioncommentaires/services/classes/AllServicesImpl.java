package com.gustofusion.gestioncommentaires.services.classes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gustofusion.gestioncommentaires.persistance.entities.Comment;
import com.gustofusion.gestioncommentaires.persistance.entities.Commentator;
import com.gustofusion.gestioncommentaires.persistance.entities.Reply;
import com.gustofusion.gestioncommentaires.services.interfaces.AllServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AllServicesImpl implements AllServices{@Override
	public void addCommentAndAssignToUser(Commentator user, Comment content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment editComment(Comment content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(long commentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReplyAndAssignToUserAndComment(Commentator user, long commentId, Reply content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reply editReply(Reply content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReply(long replyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> showAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> showRepliesByComment(long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> showCommentsByUser(long commentatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> showRepliesByUser(long commentatorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
