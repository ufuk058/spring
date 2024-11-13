package com.dtRelation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Item {

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    @ManyToMany(mappedBy = "itemList")
//    @JoinTable(name = "cart_item_rel", //renaming the table
//            joinColumns = @JoinColumn(name="i_id"), //renaming the id from Item
//            inverseJoinColumns =@JoinColumn(name="c_id") ) //renaming the id from cart

    private List<Cart>cartList;
}
