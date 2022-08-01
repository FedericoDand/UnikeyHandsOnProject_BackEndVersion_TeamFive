package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr;

import java.util.List;

public interface GenericRestMapper<D, R> {

    D getDtoFromRest(R rest);
    R getRestFromDto(D dto);
    List<R> fromDtoListToRestList(List<D> dtos);
    List<D> fromRestListToDtoList(List<R> rests);


}
