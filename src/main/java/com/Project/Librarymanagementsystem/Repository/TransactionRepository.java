package com.Project.Librarymanagementsystem.Repository;

import com.Project.Librarymanagementsystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
