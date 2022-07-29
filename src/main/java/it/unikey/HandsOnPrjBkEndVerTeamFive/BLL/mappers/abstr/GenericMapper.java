package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr;

public interface GenericMapper<E, D> {

    E getEntityFromDto(D dto);
    D getDtoFromEntity(E entity);

}
