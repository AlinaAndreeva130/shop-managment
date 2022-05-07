package ru.andreeva.shop.ui.component;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

// @Component
public class UserEditor /*extends BaseEditor<User>*/ {
    @Bind("firstName")
    private TextField name;

    /*public UserEditor(BooksRepository repository) {
        super(repository, User.class);
    }*/

    // @Override
    protected void createContentPanel(VerticalLayout contentPanel) {
        name = new TextField();
        contentPanel.add(name);
    }
}
