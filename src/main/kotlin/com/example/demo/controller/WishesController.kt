package com.example.demo.controller

import com.example.demo.model.Wishes
import com.example.demo.service.WishesService
import org.springframework.web.bind.annotation.*

@RestController
class WishesController(val service: WishesService) {

    @PostMapping("/addWish")
    fun addWish(@RequestBody wish: Wishes) {
        service.saveWish(wish)
    }

    @GetMapping("/toppings")
    fun getToppings(): HashMap<String, Int> {
        return service.findAllToppings()
    }

    @GetMapping("/customers")  //  customers?toppings=a,b,c
    fun getCustomers(@RequestParam toppings: List<String>): HashSet<String> {
        return service.findCustomersByToppings(toppings)
    }
}

// curl -X POST localhost:8080/addWish -H 'Content-type:application/json' -d '{"mail":"aa@com","toppings":["a","b"]}'
// curl -X POST localhost:8080/addWish -H 'Content-type:application/json' -d '{"mail":"bb@by","toppings":["a","c"]}'
// curl -X POST localhost:8080/addWish -H 'Content-type:application/json' -d '{"mail":"cc@ru","toppings":["d","f"]}'
// curl -X POST localhost:8080/addWish -H 'Content-type:application/json' -d '{"mail":"dd@gg","toppings":["i","b"]}'
