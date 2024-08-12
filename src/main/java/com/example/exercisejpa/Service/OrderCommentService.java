package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.OrderComment;
import com.example.exercisejpa.Repository.OrderCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderCommentService {

    private final OrderCommentRepository orderCommentRepository;

    public List<OrderComment> getOrderComment() {
        return orderCommentRepository.findAll();
    }

    public void addOrderComment(OrderComment orderComment) {
        orderCommentRepository.save(orderComment);
    }

    public boolean updateOrderComment(Integer id , OrderComment orderComment) {
        OrderComment o = orderCommentRepository.getById(id);
        if(o==null) {
            return false;
        }
        o.setComment(orderComment.getComment());
       orderCommentRepository.save(o);
        return true;
    }
    public boolean deleteOrderComment(Integer id) {
        OrderComment o = orderCommentRepository.getById(id);
        if(o==null) {
            return false;
        }
        orderCommentRepository.delete(o);
        return true;
    }
}
