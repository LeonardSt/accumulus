package com.example.demo.repository

import com.example.demo.model.Wishes
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WishesRepo : CrudRepository<Wishes, String> {
}