package ru.andreeva.shop.ui.view.entity;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import ru.andreeva.shop.service.dao.Category;
import ru.andreeva.shop.service.repository.CategoryRepository;
import ru.andreeva.shop.service.specification.CategorySpecificationFactoryImpl;
import ru.andreeva.shop.ui.component.CategoryEditor;
import ru.andreeva.shop.ui.view.MainLayout;

@Route(value = "category-view", layout = MainLayout.class)
@PageTitle("Категории товаров")
@Tag("category-view")
@JsModule("./view/entity/category-view.ts")
@UIScope
@Component
public class CategoryView extends BaseEntityView<Category, Integer, CategoryRepository> {

    public CategoryView(CategorySpecificationFactoryImpl specificationFactory, CategoryRepository repository,
                        CategoryEditor editor) {
        super(repository, specificationFactory, editor);
    }

    @Override
    protected void createColumns() {
        grid.addColumn(Category::getName).setHeader("Название").setKey("name");
    }
}
