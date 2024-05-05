package com.pokeapi.soap.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author agarciad0705
 *
 */
@Slf4j
@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tansactionRepository;

	public void save(Trx model) {
		log.info("Saving into db > " + model.toString());
		tansactionRepository.save(model);
	}
}