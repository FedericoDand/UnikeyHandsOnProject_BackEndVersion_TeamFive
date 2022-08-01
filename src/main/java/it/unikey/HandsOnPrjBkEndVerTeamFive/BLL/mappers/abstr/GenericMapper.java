package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr;

import java.util.List;

public interface GenericMapper<E, D> {

    E getEntityFromDto(D dto);
    List<E> getEntityListFromDtoList(List<D> dtos);
    D getDtoFromEntity(E entity);
<<<<<<< HEAD
    List<D> fromEntityListToDtoList(List<E> entities);
    List<E> fromDtoListToEntityList(List<D> dtos);
=======
    List<D> getDtoListFromEntityList(List<E> entities);
>>>>>>> topic-technology-module

}
