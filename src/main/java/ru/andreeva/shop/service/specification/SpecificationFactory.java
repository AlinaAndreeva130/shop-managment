package ru.andreeva.shop.service.specification;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationFactory<M> {
    Specification<M> create(SearchCriteria criteria);
}
