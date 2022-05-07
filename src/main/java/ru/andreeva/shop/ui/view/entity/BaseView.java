package ru.andreeva.shop.ui.view.entity;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.template.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.andreeva.shop.service.specification.SpecificationFactory;
import ru.andreeva.shop.ui.component.BaseEditor;
import ru.andreeva.shop.ui.filter.GridFilterService;

import javax.annotation.PostConstruct;

public abstract class BaseView<T, ID, I extends JpaSpecificationExecutor<T> & JpaRepository<T, ID>> extends LitTemplate {
    @Id("grid")
    protected Grid<T> grid;
    protected final I repository;
    protected final GridFilterService<T, ID, I> filterService;
    private final BaseEditor<T> editor;

    @Id("action-panel")
    protected HorizontalLayout actionPanel;
    @Id("add-btn")
    protected Button addBtn;
    @Id("edit-btn")
    protected Button editBtn;
    @Id("delete-btn")
    protected Button deleteBtn;

    public BaseView(I booksRepository, SpecificationFactory<T> specificationFactory, BaseEditor<T> editor) {
        this.repository = booksRepository;
        this.editor = editor;
        filterService = new GridFilterService<>(this.repository, grid, specificationFactory);
        grid.addSelectionListener(event -> {
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        });
        createActionPanel();
        createColumns();
    }

    private void createActionPanel() {
        configureActionPanel();
    }

    protected void configureActionPanel() {
        actionPanel.setPadding(true);
        addBtn.setIcon(new Icon(VaadinIcon.PLUS));
        addBtn.addClickListener(this::addEntity);

        editBtn.setIcon(new Icon(VaadinIcon.EDIT));
        editBtn.setEnabled(false);
        editBtn.addClickListener(this::editEntity);

        deleteBtn.setIcon(new Icon(VaadinIcon.TRASH));
        deleteBtn.setEnabled(false);
        deleteBtn.addClickListener(this::deleteEntity);
    }

    private void addEntity(ClickEvent<Button> event) {
        editor.open();
        grid.getDataProvider().refreshAll();
    }

    private void editEntity(ClickEvent<Button> event) {
        if (!grid.getSelectedItems().isEmpty()) {
            T selectedItem = grid.getSelectedItems().iterator().next();
            editor.edit(selectedItem, () -> grid.getDataProvider().refreshAll());
        }
    }

    private void deleteEntity(ClickEvent<Button> event) {
        if (!grid.getSelectedItems().isEmpty()) {
            T deletingItem = grid.getSelectedItems().iterator().next();
            repository.delete(deletingItem);
            grid.getDataProvider().refreshItem(deletingItem);
        }
    }

    protected abstract void createColumns();

    protected void init() {

    }

    @PostConstruct
    private void postConstruct() {
        init();
    }

}
