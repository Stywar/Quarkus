package com.aforo255.account.repository;

import javax.enterprise.context.ApplicationScoped;

import com.aforo255.account.domain.Transaction;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Integer>{

}
