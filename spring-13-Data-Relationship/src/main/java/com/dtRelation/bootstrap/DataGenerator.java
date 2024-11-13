package com.dtRelation.bootstrap;

import com.dtRelation.entity.*;
import com.dtRelation.enums.Status;
import com.dtRelation.repository.CartRepository;
import com.dtRelation.repository.ItemRepository;
import com.dtRelation.repository.MerchantRepository;
import com.dtRelation.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;


    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, ItemRepository itemRepository, CartRepository cartRepository) {
        this.paymentRepository = paymentRepository;

        this.merchantRepository = merchantRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Payment> paymentList = new ArrayList<>();


        Payment p1= new Payment(LocalDate.of(2022,4,19),new BigDecimal(150000), Status.SUCCESS);
        PaymentDetail pd1= new PaymentDetail(new BigDecimal(140000),new BigDecimal(10000),LocalDate.of(2002,4,24));
        p1.setPaymentDetail(pd1);


        Payment p2= new Payment(LocalDate.of(2022,4,25),new BigDecimal(100000),Status.FAILURE);
        PaymentDetail pd2= new PaymentDetail(new BigDecimal(90000),new BigDecimal(5000),LocalDate.of(2022,4,29));
        p2.setPaymentDetail(pd2);

        paymentList.addAll(Arrays.asList(p1,p2));

        Merchant m1= new Merchant("Amazon","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);

        p1.setMerchant(m1);
        p2.setMerchant(m1);
        Item item1= new Item("Milk","M01");
        Item item2= new Item("Sugar","S01");
        Item item3= new Item("Bread","B01");

        Cart cart1= new Cart();
        Cart cart2= new Cart();

        cart1.setItemList(Arrays.asList(item1,item2,item3));
        cart2.setItemList(Arrays.asList(item1,item2));
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //Save merchant to merchant repo
        merchantRepository.save(m1);
        paymentRepository.saveAll(paymentList);

        System.out.println( paymentRepository.findById(2L).get().getAmount());
        System.out.println(paymentRepository.findById(2L).get().getPaymentDetail().getCommissionAmount());

        //Based on the following statement in Payment class --> @OneToOne (cascade = CascadeType.ALL)
        //We can do any Cascade action which also includes Remove like below
        //paymentRepository.delete(p1);
        //If I use @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) it deletes the record from
        // Payments table only not PaymentDetails

        // paymentRepository.delete(p1); --> This statement calling is Hard Delete and None of the company use it,
        // so none of the records deletes permanently. Use soft delete only

    }
}
