package ru.andreeva.shop.service.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.andreeva.shop.service.dao.Category;
import ru.andreeva.shop.service.dao.Product;

@Component
public class CategorySpecificationFactoryImpl implements SpecificationFactory<Category> {
    @Override
    public Specification<Category> create(SearchCriteria criteria) {
        return new CategorySpecification(criteria);
    }
}
