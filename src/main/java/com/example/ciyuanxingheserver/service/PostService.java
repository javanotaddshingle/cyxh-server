package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.Post;
import com.example.ciyuanxingheserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        post.setCreatedAt(new Date());
        post.setUpdatedAt(new Date());
        post.setLikes(0);
        post.setComments(0);
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public Post updatePost(Post post) {
        post.setUpdatedAt(new Date());
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post likePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setLikes(post.getLikes() + 1);
            postRepository.save(post);
        }
        return post;
    }

    public Post addComment(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setComments(post.getComments() + 1);
            postRepository.save(post);
        }
        return post;
    }
}