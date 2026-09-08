package com.noenoworks.sayostaycalendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ブラウザからのリクエストを捌く宣言
public class EventController {

    private final EventRepository eventRepository;
    private final ExpenseRepository expenseRepository;

    public EventController(EventRepository eventRepository, ExpenseRepository expenseRepository) {
        this.eventRepository = eventRepository;
        this.expenseRepository = expenseRepository;
    }

    // ---------------------------------------------------------
    // GET＝見る（GetMapping）
    // ---------------------------------------------------------
    // リストページを表示
    @GetMapping("/events")
    public String list(Model model) {
        model.addAttribute("events", eventRepository.findAllByOrderByEventDateAsc());
        return "events";
    }

    // カレンダーページを表示
    @GetMapping("/calendar")
    public String calendar() {
        return "calendar";
    }

    // イベント新規登録ページ表示
    @GetMapping("/events/new")
    public String newEvent(Model model) {
        model.addAttribute("newEvent", new Event());
        return "new";
    }

    // 編集画面を表示
    @GetMapping("/events/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElseThrow();
        model.addAttribute("event", event);
        return "edit";
    }

    // 詳細ページ表示
    @GetMapping("/events/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElseThrow();
        model.addAttribute("event", event);
        return "detail";
    }

    // ---------------------------------------------------------
    // POST＝送る（PostMapping）
    // ---------------------------------------------------------
    // 登録処理
    @PostMapping("/events")
    public String create(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/events";
    }

    // 支出を追加
    @PostMapping("/events/{id}/expenses")
    public String addExpense(@PathVariable Long id, @ModelAttribute Expense expense) {
        Event event = eventRepository.findById(id).orElseThrow();
        expense.setId(null);
        expense.setEvent(event);
        expenseRepository.save(expense);
        return "redirect:/events/" + id;
    }

    // 削除処理
    @PostMapping("/events/{id}/delete")
    public String delete(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/events";
    }

    // 更新処理
    @PostMapping("/events/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute Event event) {
        event.setId(id);
        eventRepository.save(event);
        return "redirect:/events";
    }
}