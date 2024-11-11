package com.dtRelation.bootstrap;

import com.dtRelation.entity.Payment;
import com.dtRelation.entity.PaymentDetail;
import com.dtRelation.enums.Status;
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


    public DataGenerator(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;

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


        paymentRepository.saveAll(paymentList);


    }
}
