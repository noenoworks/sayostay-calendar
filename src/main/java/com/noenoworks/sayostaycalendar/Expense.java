package com.noenoworks.sayostaycalendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {

    // ---------------------------------------------------------
    // 変数
    // ---------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Event event;
    // 支出内容
    private String itemName;
    // 金額
    private Integer amount;

    // ---------------------------------------------------------
    // getter / setter
    // ---------------------------------------------------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    // 支出内容
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    // 金額
    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
}