//package com.example.web.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Subselect;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "Order_detail")
//@Subselect("SELECT  * FROM Order_detail")
//public class OrderDetail {
//    @Id
//    @GeneratedValue
//    @Column(name = "order_detail_id")
//    private int orderDetailId;
//    @Column(name = "order_id")
//    private int orderId;
//    @Column(name = "product_id")
//    private int product_id;
//    @Column(name = "quantity")
//    private int quantity;
//    @Column(name = "date_create")
//    private Date dateCreate;
//    @Column (name ="ma_nv")
//    private String maNV;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name ="product_id")
//    private Product product;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//}
