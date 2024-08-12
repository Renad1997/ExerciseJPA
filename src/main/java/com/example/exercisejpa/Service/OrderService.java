package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Order;
import com.example.exercisejpa.Repository.OrderRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;


    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public boolean updateOrder(Integer id , Order order) {
        Order o = orderRepository.getById(id);
        if(o==null) {
            return false;
        }
        o.setProductId(order.getProductId());
        o.setMerchantId(order.getMerchantId());
        o.setUserId(order.getUserId());
        o.setDiscount(order.getDiscount());
        o.setPrice(order.getPrice());
        orderRepository.save(o);
        return true;
    }
    public boolean deleteOrder(Integer id) {
        Order o = orderRepository.getById(id);
        if(o==null) {
            return false;
        }
        orderRepository.delete(o);
        return true;
    }

//    public boolean isOrderExist(int id) {
//        for (int i = 0; i < orders.size(); i++) {
//            if (orders.get(i).getOrderId() == id) {
//
//                return true;
//            }
//        }
//
//        return false;
//    }

}
