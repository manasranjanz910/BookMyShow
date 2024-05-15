package dev.manas.BookMyShow.model;

import dev.manas.BookMyShow.model.constant.PaymentMode;
import dev.manas.BookMyShow.model.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String refNumber;
    private double totalAmount;
    private LocalDateTime paymentTime;
    @ManyToOne
    private Ticket ticket;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    public Payment(){}
    public Payment(String refNumber, double totalAmount, LocalDateTime paymentTime, Ticket ticket, PaymentMode paymentMode, PaymentStatus paymentStatus) {
        this.refNumber = refNumber;
        this.totalAmount = totalAmount;
        this.paymentTime = paymentTime;
        this.ticket = ticket;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
    }
}
