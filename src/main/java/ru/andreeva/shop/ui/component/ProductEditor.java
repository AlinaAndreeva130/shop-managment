package ru.andreeva.shop.ui.component;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import org.springframework.stereotype.Component;
import ru.andreeva.shop.service.dao.Category;
import ru.andreeva.shop.service.dao.Product;
import ru.andreeva.shop.service.repository.CategoryRepository;
import ru.andreeva.shop.service.repository.ProductRepository;

@Component
public class ProductEditor extends BaseEditor<Product> {
    @Bind
    private TextField name;
    @Bind
    private ComboBox<Category> category;
    @Bind
    private TextField description;
    @Bind(converter = Bind.Converter.STRING_TO_DOUBLE)
    private TextField price;

    private final CategoryRepository categoryRepository;

    public ProductEditor(ProductRepository repository, CategoryRepository categoryRepository) {
        super(repository, Product.class);
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected void createContentPanel(VerticalLayout contentPanel) {
        name = new TextField("Название товара");
        name.setSizeFull();
        category = new ComboBox<>("Категория");
        category.setItemLabelGenerator(Category::getName);
        category.setSizeFull();
        description = new TextField("Описание");
        description.setWidth("320px");
        price = new TextField("Цена");
        price.setSizeFull();
        contentPanel.add(name, category, description, price);
    }

    @Override
    protected Product createNewEntity() {
        return new Product();
    }

    @Override
    protected void actionBeforeOpen() {
        category.clear();
        category.setDataProvider(new ListDataProvider<>(categoryRepository.findAll()));
    }
}
