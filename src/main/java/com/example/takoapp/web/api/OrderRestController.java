package com.example.takoapp.web.api;

import com.example.takoapp.data.OrderRepository;
import com.example.takoapp.domain.TacoOrder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path =  "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class OrderRestController {
    private OrderRepository repo;

    public OrderRestController(OrderRepository orderRepo) {
        this.repo = orderRepo;
    }

    @GetMapping(produces = "application/json")
    public Iterable<TacoOrder> allOrders(){
        return repo.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(@RequestBody TacoOrder tacoOrder){
        return repo.save(tacoOrder);

    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(
            @PathVariable("orderId") Long orderId,
                              @RequestBody TacoOrder tacoOrder){

        tacoOrder.setId(orderId);
        return repo.save(tacoOrder);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder pathOrder(@PathVariable("orderId") Long orderId,
                               @RequestBody TacoOrder patch){

        TacoOrder order = repo.findById(orderId).get();

        if (patch.getDeliveryName()!=null){
            order.setDeliveryName(patch.getDeliveryName());
        }

        if (patch.getDeliveryStreet()!=null){
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }

        if (patch.getDeliveryCity()!=null){
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState()!=null){
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip()!=null){
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber()!=null){
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration()!=null){
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV()!=null){
            order.setCcCVV(patch.getCcCVV());
        }

        return repo.save(order);

    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(
            @PathVariable("orderId") Long orderId
    ){
        try {
            repo.deleteById(orderId);
        }catch (EmptyResultDataAccessException e){

        }
    }

}
