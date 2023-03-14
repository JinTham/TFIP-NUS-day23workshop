package tfip.paf.day23workshop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tfip.paf.day23workshop.Models.Order;
import tfip.paf.day23workshop.Payload.SearchRequest;
import tfip.paf.day23workshop.Services.OrderRestTemplateService;
import tfip.paf.day23workshop.Services.OrderService;

@Controller
@RequestMapping(path="/order")
public class OrderController {
    
    @Autowired
    OrderService orderSvc;

    @Autowired
    OrderRestTemplateService orts;

    @GetMapping(path="/total/{order_id}")
    public String findOrderById(@PathVariable("order_id") Integer id, Model model) {
        List<Order> orderList = orderSvc.findOrderById(id);
        model.addAttribute("orderList", orderList);
        model.addAttribute("orderId", id);
        return "order";
    }

    @GetMapping(path="/searchOrder")
    public String searchOrder(Model model) {
        SearchRequest sr = new SearchRequest();
        model.addAttribute("searchObject", sr);
        return "searchOrder";
    }

    @PostMapping(path="/search")
    public String processSearch(@ModelAttribute("searchObject") SearchRequest searchObj, Model model, BindingResult result) {
        //List<Order> orders = orts.findOrderById(searchObj.getOrderId());
        List<Order> orders = orderSvc.findOrderById(searchObj.getOrderId());
        model.addAttribute("orderList",orders);
        model.addAttribute("orderId", searchObj.getOrderId());
        return "order";
    }

}
