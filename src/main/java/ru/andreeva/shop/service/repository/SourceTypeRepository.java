package ru.andreeva.shop.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.andreeva.shop.service.dao.SourceType;

public interface SourceTypeRepository extends JpaRepository<SourceType, String>, JpaSpecificationExecutor<SourceType> {
}