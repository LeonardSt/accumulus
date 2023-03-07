package com.example.demo.repository

import com.example.demo.model.Wishes
import org.springframework.stereotype.Repository

@Repository
class WishesRepo {
    val wishes: HashMap<String, HashSet<String>> = hashMapOf()

    fun saveWish(wish: Wishes) {
        wishes[wish.mail] = wish.toppings
    }

    fun findAllToppings(): HashMap<String, Int> {
        val toppings: HashMap<String, Int> = hashMapOf()
        for (entry in wishes.entries.iterator()) {
            for (t in entry.value) {
                toppings.put(t, toppings.getOrDefault(t, 0) + 1)
            }
        }
        return toppings
    }

    fun findCustomersByToppings(toppings: HashSet<String>): HashSet<String> {
        val customers: HashSet<String> = hashSetOf()
        for (entry in wishes.entries.iterator()) {
            if (entry.value.any { it in toppings }) {
                customers.add(entry.key)
            }
        }
        return customers
    }
}