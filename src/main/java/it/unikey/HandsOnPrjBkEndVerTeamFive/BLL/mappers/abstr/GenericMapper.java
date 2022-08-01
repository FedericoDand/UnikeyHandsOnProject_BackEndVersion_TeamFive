package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr;

import java.util.List;

public interface GenericMapper<E, D> {

    E getEntityFromDto(D dto);
    D getDtoFromEntity(E entity);
    List<D> fromEntityListToDtoList(List<E> entities);
    List<E> fromDtoListToEntityList(List<D> dtos);

}
