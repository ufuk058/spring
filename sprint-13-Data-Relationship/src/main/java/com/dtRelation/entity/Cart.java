package com.dtRelation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(name = "cart_item_rel", //renaming the table
            joinColumns = @JoinColumn(name="c_id"), //renaming the id from Item
            inverseJoinColumns =@JoinColumn(name="i_id") ) //renaming the id from cart
    private List<Item> itemList;
}
