package ru.andreeva.shop.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.andreeva.shop.service.dao.Source;

public interface SourceRepository extends JpaRepository<Source, Integer>, JpaSpecificationExecutor<Source> {
}