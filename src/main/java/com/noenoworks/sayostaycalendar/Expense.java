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
    // カテゴリ
    private String category;
    // 金額
    private Integer amount;
    // メモ
    private String description;

    // ---------------------------------------------------------
    // getter / setter
    // ---------------------------------------------------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    // カテゴリ
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // 金額
    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    // メモ
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}