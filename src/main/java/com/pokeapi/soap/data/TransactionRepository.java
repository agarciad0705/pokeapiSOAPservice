package com.pokeapi.soap.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author agarciad0705
 *
 */
@Repository
public interface TransactionRepository extends CrudRepository<Trx, Integer> {
}
