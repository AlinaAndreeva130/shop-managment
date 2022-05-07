package ru.andreeva.shop.ui.view.entity;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import ru.andreeva.shop.service.dao.Product;
import ru.andreeva.shop.service.repository.ProductRepository;
import ru.andreeva.shop.service.specification.ProductSpecificationFactoryImpl;
import ru.andreeva.shop.ui.component.ProductEditor;
import ru.andreeva.shop.ui.view.MainLayout;

@Route(value = "product", layout = MainLayout.class)
@PageTitle("Товары")
@Tag("product-view")
@JsModule("./view/entity/product-view.ts")
@UIScope
@Component
public class ProductView extends BaseEntityView<Product, Integer, ProductRepository> {

    public ProductView(ProductSpecificationFactoryImpl specificationFactory, ProductRepository productRepository,
                       ProductEditor editor) {
        super(productRepository, specificationFactory, editor);
    }

    @Override
    protected void createColumns() {
        grid.addColumn(Product::getName).setHeader("Название").setKey("name");
        grid.addColumn(product -> product.getCategory().getName()).setHeader("Категория").setKey("category");
        grid.addColumn(Product::getDescription).setHeader("Описание").setKey("description");
        grid.addColumn(Product::getPrice).setHeader("Цена").setKey("price");
    }
}
