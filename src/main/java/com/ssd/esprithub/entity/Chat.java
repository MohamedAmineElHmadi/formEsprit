package com.ssd.esprithub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Chat {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChat")
    private Long idChat;
	private String content;
	
	@ManyToOne
	private User sender;
	@ManyToOne
	private User receiver;
}
