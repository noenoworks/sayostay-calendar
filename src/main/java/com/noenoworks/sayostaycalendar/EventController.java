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

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // 一覧ページを表示（GET＝見る）
    @GetMapping("/events")
    public String list(Model model) {
        model.addAttribute("events", eventRepository.findAllByOrderByEventDateAsc());
        model.addAttribute("newEvent", new Event());
        return "events";
    }

    // 登録処理（POST＝送る）
    @PostMapping("/events")
    public String create(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/events";
    }

    // 削除処理
    @PostMapping("/events/{id}/delete")
    public String delete(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/events";
    }

    // 編集画面を表示
    @GetMapping("/events/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElseThrow();
        model.addAttribute("event", event);
        return "edit";
    }

    // 更新処理
    @PostMapping("/events/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute Event event) {
        event.setId(id);
        eventRepository.save(event);
        return "redirect:/events";
    }
}