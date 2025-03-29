package com.mygitgor.sofpos.mapper;

public interface ConfigMapper <T,E>{
    E toEntity(T t);
    T toDomain(E e);
}
