package ru.andreeva.shop.ui.component;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.stereotype.Component;
import ru.andreeva.shop.service.dao.Category;
import ru.andreeva.shop.service.repository.ProductRepository;

@Component
public class CategoryEditor extends BaseEditor<Category> {
    @Bind
    private TextField name;

    public CategoryEditor(ProductRepository repository) {
        super(repository, Category.class);
    }

    @Override
    protected void createContentPanel(VerticalLayout contentPanel) {
        name = new TextField("Название категории");
        contentPanel.add(name);
    }

    @Override
    protected Category createNewEntity() {
        return new Category();
    }

    @Override
    protected void actionBeforeOpen() {

    }
}
