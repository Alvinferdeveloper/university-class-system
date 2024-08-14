package com.albin.universitySystem.utils;

public interface IMapper<D, E> {
    E dtoToEntity(D dto);

    D entityToDto(E dto);
}
