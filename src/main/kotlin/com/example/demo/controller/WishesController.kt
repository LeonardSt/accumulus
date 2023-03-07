package com.example.demo.controller

import com.example.demo.model.Toppings
import com.example.demo.model.Wishes
import com.example.demo.service.WishesService
import org.springframework.web.bind.annotation.*

@RestController
class WishesController(val service: WishesService) {

    @PostMapping("/addWish")
    fun addWish(@RequestBody wish: Wishes): Wishes {
        return service.saveWish(wish)
    }

    @GetMapping("/toppings")
    fun getToppings(): Map<Toppings, Int> {
        return service.findAllToppings()
    }

    @GetMapping("/customers")
    fun getCustomers(@RequestParam toppings: List<String>): Set<String> {
        return service.findCustomersByToppings(toppings)
    }

    @DeleteMapping("/delete")
    fun delete() {
        service.deleteAll()
    }
}
