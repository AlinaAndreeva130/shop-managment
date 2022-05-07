package ru.andreeva.shop.service.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.andreeva.shop.service.dao.Product;

@Component
public class ProductSpecificationFactoryImpl implements SpecificationFactory<Product> {
    @Override
    public Specification<Product> create(SearchCriteria criteria) {
        return new ProductSpecification(criteria);
    }
}
