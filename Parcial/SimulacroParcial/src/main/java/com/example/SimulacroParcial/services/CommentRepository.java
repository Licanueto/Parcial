package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
