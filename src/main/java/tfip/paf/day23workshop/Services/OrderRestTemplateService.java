package tfip.paf.day23workshop.Services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tfip.paf.day23workshop.Models.Order;

@Service
public class OrderRestTemplateService {
    
    RestTemplate restTemplate = new RestTemplate();

    private static final String GETORDERBYID_ENDPOINT_URL = "http://localhost:8080/api/order/total/{order_id}";

    public List<Order> findOrderById(Integer id) {
        ResponseEntity<List<Order>> result = restTemplate.exchange(GETORDERBYID_ENDPOINT_URL, HttpMethod.GET,null,
        new ParameterizedTypeReference<List<Order>>() {}, id);
        return result.getBody();
    }

}
