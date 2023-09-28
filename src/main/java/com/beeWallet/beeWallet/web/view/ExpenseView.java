package com.beeWallet.beeWallet.web.view;

import com.beeWallet.beeWallet.service.ExpenseService;
import com.beeWallet.beeWallet.web.model.ExpenseModel;
import com.beeWallet.beeWallet.web.view.list.ExpenseForm;
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
    private ExpenseForm expenseForm;

    public ExpenseView(ExpenseService service) {
        this.expenseService = service;
        addClassName("list-view");
        setSizeFull();

        configureGrid();
        configureForm();
        add(
                getToolbar(),
                getContent()
        );
        updateList();
    }

    private void updateList() {
        expenseModelGrid.setItems(expenseService.list(filterText.getValue()));
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(expenseModelGrid, expenseForm);
        content.setFlexGrow(2, expenseModelGrid);
        content.setFlexGrow(1, expenseForm);
        content.addClassName("content");
        content.setSizeFull();
        return content;
    }

    private void configureForm() {
        expenseForm = new ExpenseForm();
        expenseForm.setWidth("25em");
    }

    private void configureGrid() {
        expenseModelGrid.addClassName("expense-grit");
        expenseModelGrid.setSizeFull();
        expenseModelGrid.setColumns("date", "name", "price");
        expenseModelGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private Component getToolbar() {
        filterText.setPlaceholder("Find expense... ");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addExpenseButton = new Button("Add expense");
        addExpenseButton.addClickListener(e -> expenseService.create(null));

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addExpenseButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

}
