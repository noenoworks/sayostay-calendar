package com.noenoworks.sayostaycalendar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}