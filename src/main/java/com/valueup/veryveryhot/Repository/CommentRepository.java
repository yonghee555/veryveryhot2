package com.valueup.veryveryhot.Repository;

import java.util.List;

import com.valueup.veryveryhot.Model.Comment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
    public Comment findByCommentpeople(String commentpeople);
    public Comment findByCommentcontent(String commentcontent);
    public Comment findByCommentdate(String commentdate);
    public List<Comment> findByParentid(String parentid);
}
