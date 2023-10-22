package com.gustofusion.gestioncommentaires.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustofusion.gestioncommentaires.persistance.entities.Comment;
import com.gustofusion.gestioncommentaires.persistance.entities.Commentator;
import com.gustofusion.gestioncommentaires.persistance.entities.Reply;
import com.gustofusion.gestioncommentaires.services.interfaces.AllServices;

@RestController
@RequestMapping("/comment")
public class GeneralController {
	
	@Autowired
    private AllServices allServices;

    @PostMapping("/")
    public ResponseEntity<Void> addCommentAndAssignToUser(@RequestBody Comment content) {
        allServices.addCommentAndAssignToUser(content);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Comment> editComment(@RequestBody Comment content) {
        return ResponseEntity.ok(allServices.editComment(content));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable long commentId) {
        allServices.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reply/{commentId}")
    public ResponseEntity<Void> addReplyAndAssignToUserAndComment(@PathVariable long commentId, @RequestBody Reply content) {
        allServices.addReplyAndAssignToUserAndComment(commentId, content);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reply")
    public ResponseEntity<Reply> editReply(@RequestBody Reply content) {
        return ResponseEntity.ok(allServices.editReply(content));
    }

    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable long replyId) {
        allServices.deleteReply(replyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> showAllComments() {
        return ResponseEntity.ok(allServices.showAllComments());
    }

    @GetMapping("/{commentId}/replies")
    public ResponseEntity<List<Reply>> showRepliesByComment(@PathVariable long commentId) {
        return ResponseEntity.ok(allServices.showRepliesByComment(commentId));
    }

    @GetMapping("/user/{commentatorId}")
    public ResponseEntity<List<Comment>> showCommentsByUser(@PathVariable long commentatorId) {
        return ResponseEntity.ok(allServices.showCommentsByUser(commentatorId));
    }

    @GetMapping("/user/{commentatorId}/replies")
    public ResponseEntity<List<Reply>> showRepliesByUser(@PathVariable long commentatorId) {
        return ResponseEntity.ok(allServices.showRepliesByUser(commentatorId));
    }

}
