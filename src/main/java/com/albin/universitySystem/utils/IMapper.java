package com.albin.universitySystem.utils;

public interface IMapper<D, E, K> {
    E dtoToEntity(D dto);

    K entityToDto(E dto);
}
