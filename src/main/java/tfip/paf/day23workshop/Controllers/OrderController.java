package tfip.paf.day23workshop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tfip.paf.day23workshop.Models.Order;
import tfip.paf.day23workshop.Services.OrderService;

@Controller
@RequestMapping(path="/order/total")
public class OrderController {
    
    @Autowired
    OrderService orderSvc;

    @GetMapping(path="/{order_id}")
    public String findOrderById(@PathVariable("order_id") Integer id, Model model) {
        List<Order> orderList = orderSvc.findOrderById(id);
        model.addAttribute("orderList", orderList);
        return "order";
    }

}
