package com.myblog.myblog1.service;

import com.myblog.myblog1.payload.CommentDto;

public interface CommentSrevice {
    CommentDto createComment(CommentDto commentDto,Long postId);

    void deleteComment(long id);

    CommentDto updateComment(Long id, CommentDto commentDto, long postId);
}
