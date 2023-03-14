package tfip.paf.day23workshop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfip.paf.day23workshop.Models.Order;
import tfip.paf.day23workshop.Services.OrderService;

@RestController
@RequestMapping(path="/api/order/total")
public class OrderRestController {
    
    @Autowired
    OrderService orderSvc;

    @GetMapping(path="/{order_id}")
    public ResponseEntity<List<Order>> findOrderById(@PathVariable("order_id") Integer id) {
        List<Order> orderList = orderSvc.findOrderById(id);
        if (orderList.size()>0) {
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }
}
