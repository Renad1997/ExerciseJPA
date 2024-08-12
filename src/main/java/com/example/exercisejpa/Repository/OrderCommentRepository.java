package com.example.exercisejpa.Repository;

import com.example.exercisejpa.Model.OrderComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCommentRepository extends JpaRepository<OrderComment, Integer> {
}
