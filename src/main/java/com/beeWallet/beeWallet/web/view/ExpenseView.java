package com.beeWallet.beeWallet.web.view;

import com.beeWallet.beeWallet.service.ExpenseService;
import com.beeWallet.beeWallet.web.model.ExpenseModel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route(value = "/expense")
@PageTitle("Expense")
@PermitAll
public class ExpenseView extends VerticalLayout {

    private ExpenseService expenseService;
    TextField filterText = new TextField();
    private Grid<ExpenseModel> expenseModelGrid = new Grid<>(ExpenseModel.class);
    private ExpenseModel expenseModel;

    public ExpenseView(ExpenseService service) {
        this.expenseService = service;
        addClassName("list-view");
        setSizeFull();

        configureGrid();
        configureForm();

        add(
                getToolbar(),
                getContact()
        );

//        updateList();
//        closeEditor();
    }

    private void configureGrid() {
        expenseModelGrid.addClassName("expense-grit");
        expenseModelGrid.setSizeFull();
        expenseModelGrid.setColumns("date", "name", "price");
        expenseModelGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void configureForm() {
        expenseModel = new ExpenseModel();
//        expenseModel.setWidth("25em");

//        expenseModel.addSaveListener(this::saveContact);
//        expenseModel.addDeleteListener(this::deleteContact);
//        expenseModel.addCloseListener(e->closeEditor());
    }

    private Component getToolbar() {
        filterText.setPlaceholder("Find expense... ");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact");
        addContactButton.addClickListener(e -> expenseService.create(null));

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private Component getContact() {
        HorizontalLayout content = new HorizontalLayout(expenseModelGrid);
        content.setFlexGrow(2, expenseModelGrid);
        content.setFlexGrow(1);
        content.addClassName("content");
        content.setSizeFull();

        return content;
    }

}
