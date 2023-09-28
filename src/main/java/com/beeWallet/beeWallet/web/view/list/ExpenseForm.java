package com.beeWallet.beeWallet.web.view.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ExpenseForm extends FormLayout {
    private DatePicker date = new DatePicker("Date");
    private TextField name = new TextField("Name");
    private TextField price = new TextField("Price");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button cancel = new Button("Cancel");


    public ExpenseForm() {
        addClassName("expense-form");

        date.setLabel("Date");
        name.setLabel("Name");
        price.setLabel("Price");

        date.setLabel("Enter date");
        name.setPlaceholder("Enter name");
        price.setPlaceholder("Enter price");

        date.setRequiredIndicatorVisible(true);
        name.setRequired(true);
        price.setRequired(true);

        add(date,
                name,
                price,
                createButtonLayout()
        );
    }

    private Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);
        return new HorizontalLayout(save, delete, cancel);
    }

    public DatePicker getDateField() {
        return date;
    }

    public TextField getNameField() {
        return name;
    }

    public TextField getPriceField() {
        return price;
    }
}