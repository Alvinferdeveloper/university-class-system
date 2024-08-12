package com.albin.dbrelations.utils;

public interface IMapper<D, E> {
    E dtoToEntity(D dto);

    D entityToDto(E dto);
}
