package com.dtRelation.entity;

import com.dtRelation.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="payments")
public class Payment {

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    //@OneToOne (cascade = CascadeType.ALL)//This annotation creates relation between Payment and PaymentDetail and accept id as foreign key
    //and creates foreign id as payment_detail_id
    // @JoinColumn(name="myForeignKey") //This annotation provides to custom name of the foreign key
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private PaymentDetail paymentDetail;



}
