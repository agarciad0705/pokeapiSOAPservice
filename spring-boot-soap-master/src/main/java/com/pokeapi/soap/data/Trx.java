package com.pokeapi.soap.data;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author agarciad0705
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRX")
public class Trx implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO )    
	@Column(name = "ID")
    private Integer id;
	@Column(name = "IP")
    private String ip;
	@Column(name = "ACTION")
    private String action;
	@Column(name = "DATE")
    private LocalDate date;

    // Constructor, getters y setters
}
