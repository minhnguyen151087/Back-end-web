//package com.example.web.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Subselect;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "Order")
//@Subselect("SELECT  * FROM Order")
//public class Order {
//    @Id
//    @GeneratedValue
//    @Column(name = "order_id")
//    private int orderId;
//    @Column(name="total_price")
//    private double totalPrice;
//    @Column(name="status")
//    private String status;
//    @Column(name = "user_id")
//    private String userId;
////    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
////    private List<OrderDetail> orderDetails;
//}
