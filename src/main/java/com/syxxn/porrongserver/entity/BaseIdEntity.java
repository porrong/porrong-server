package com.syxxn.porrongserver.entity;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class BaseIdEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
