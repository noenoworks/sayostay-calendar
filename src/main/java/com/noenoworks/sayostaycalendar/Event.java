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
    // 備考
    private String note;

    // getter / setter
    // id
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // イベント名
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    // 日付
    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    // 開場時間
    public LocalTime getOpenTime() { return openTime; }
    public void setOpenTime(LocalTime openTime) { this.openTime = openTime; }

    // 開演時間
    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    // 会場
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    // チケット購入フラグ
    public boolean isTicketPurchased() { return ticketPurchased; }
    public void setTicketPurchased(boolean ticketPurchased) { this.ticketPurchased = ticketPurchased; }

    // 備考
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}