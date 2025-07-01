package com.example.springmvcform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("currencyForm", new CurrencyForm());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute("currencyForm") CurrencyForm currencyForm, Model model) {
        double rate = getExchangeRate(currencyForm.getCurrency());
        double result = currencyForm.getAmount() * rate;

        model.addAttribute("result", String.format("%.2f", result));
        model.addAttribute("currency", currencyForm.getCurrency());
        model.addAttribute("amount", currencyForm.getAmount());
        return "result";
    }

    private double getExchangeRate(String currency) {
        return switch (currency) {
            case "USD" -> 0.25;   // przykładowy kurs PLN->USD
            case "WON" -> 325.0;  // PLN->WON
            case "PESOS" -> 5.0;  // PLN->PESOS
            case "YEN" -> 27.0;   // PLN->YEN
            default -> 1.0;
        };
    }

}
