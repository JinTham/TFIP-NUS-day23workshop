package tfip.paf.day23workshop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.paf.day23workshop.Models.Order;
import tfip.paf.day23workshop.Repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepo;

    public List<Order> findOrderById(Integer id) {
        return orderRepo.findOrderById(id);
    }

}
