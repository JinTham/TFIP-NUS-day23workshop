package tfip.paf.day23workshop.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tfip.paf.day23workshop.Models.Order;

@Repository
public class OrderRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String findOrderByIdSQL = "select od.order_id, o.order_date, o.customer_id,"
        + " (od.quantity*od.unit_price*if(od.discount>0,od.discount,1)) as total_price,"
        + " (od.quantity*p.standard_cost) as cost_price"
        + " from order_details od"
        + " inner join products p"
        + " on od.product_id = p.id"
        + " inner join orders o"
        + " on od.order_id = o.id"
        + " where o.id = ?";

    public List<Order> findOrderById(Integer id) {
        return jdbcTemplate.query(findOrderByIdSQL,BeanPropertyRowMapper.newInstance(Order.class), id);
    }

}
