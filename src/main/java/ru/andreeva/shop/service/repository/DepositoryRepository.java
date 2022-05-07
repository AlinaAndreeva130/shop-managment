package ru.andreeva.shop.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.andreeva.shop.service.dao.Depository;

public interface DepositoryRepository extends JpaRepository<Depository, Integer>, JpaSpecificationExecutor<Depository> {
}