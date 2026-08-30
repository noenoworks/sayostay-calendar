package com.noenoworks.sayostaycalendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity // このJavaクラスをDBのテーブルとして扱う宣言
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // イベント名
    private String eventName;
    // 日付
    private LocalDate eventDate;
    // 開場時間
    private LocalTime openTime;
    // 開演時間
    private LocalTime startTime;
    // 会場
    private String venue;
    // チケット購入フラグ
    private boolean ticketPurchased;

    // getter / setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public LocalTime getOpenTime() { return openTime; }
    public void setOpenTime(LocalTime openTime) { this.openTime = openTime; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public boolean isTicketPurchased() { return ticketPurchased; }
    public void setTicketPurchased(boolean ticketPurchased) { this.ticketPurchased = ticketPurchased; }
}