package com.example.demo.service

import com.example.demo.model.Toppings
import com.example.demo.model.Wishes
import com.example.demo.repository.WishesRepo
import org.springframework.stereotype.Service

@Service
class WishesService(val wishesRepo: WishesRepo) {

    fun saveWish(newWish: Wishes): Wishes {
        return wishesRepo.findById(newWish.mail).map {
            it.toppings = newWish.toppings
            wishesRepo.save(it)
        }.orElseGet {
            wishesRepo.save(newWish)
        }
    }

    fun findAllToppings(): Map<Toppings, Int> {
        val toppings: HashMap<Toppings, Int> = hashMapOf()
        wishesRepo.findAll()
            .forEach { wishes ->
                wishes.toppings
                    .forEach { t ->
                        toppings[t] = toppings.getOrDefault(t, 0) + 1
                    }
            }
        return toppings
    }

    fun findCustomersByToppings(toppings: List<String>): HashSet<String> {
        val wishes = wishesRepo.findAll()
        val customers: HashSet<String> = hashSetOf()

        for (entry in wishes.iterator()) {
            if (entry.toppings.any { it.name in toppings }) {
                customers.add(entry.mail)
            }
        }
        return customers
    }

    fun deleteAll() {
        wishesRepo.deleteAll()
    }
}