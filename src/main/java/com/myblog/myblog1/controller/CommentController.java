package com.myblog.myblog1.controller;

import com.myblog.myblog1.payload.CommentDto;
import com.myblog.myblog1.service.CommentSrevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentSrevice commentSrevice;

    public CommentController(CommentSrevice commentSrevice) {
        this.commentSrevice = commentSrevice;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @RequestParam Long postId){
        CommentDto dto = commentSrevice.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        commentSrevice.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted!!", HttpStatus.OK);
    }
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto,@PathVariable long postId){
        CommentDto dto = commentSrevice.updateComment(id, commentDto, postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
