package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name = "wishes")
data class Wishes(@Id val mail: String) {

    @ElementCollection()
    @CollectionTable(name = "toppings", joinColumns = [JoinColumn(name = "user_mail")])
    @Enumerated(EnumType.STRING)
    var toppings: Set<Toppings> = hashSetOf()

}
