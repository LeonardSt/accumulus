package com.example.demo.service

import com.example.demo.model.Wishes
import com.example.demo.repository.WishesRepo
import org.springframework.stereotype.Service

@Service
class WishesService(val db: WishesRepo) {

    fun saveWish(wish: Wishes) {
        db.saveWish(wish)
    }

    fun findAllToppings(): HashMap<String, Int> {
        return db.findAllToppings()
    }

    fun findCustomersByToppings(toppings: List<String>): HashSet<String> {
        return db.findCustomersByToppings(toppings.toHashSet())
    }
}