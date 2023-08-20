package com.Java5.Java5.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productId")
    private Product product;
    
     @Column(nullable = false)
    private Long orderId;
//   @ManyToOne(cascade=CascadeType.PERSIST)
//    @JoinColumn(name = "orderId")
//    private Order order;
    

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "orderId")
//    private Order order;
    
//    @ManyToOne 
//    @JoinColumn(name = "orderId") // thông qua khóa ngoại address_id
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Order order;
//    
    
// @ManyToOne(fetch = FetchType.EAGER, optional = false)
//  @JoinColumn(name = "orderId", nullable = false)
//  @OnDelete(action = OnDeleteAction.CASCADE)
//  private Order order;
    
//     @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "productId", referencedColumnName = "id")
//    private Product product;
}
