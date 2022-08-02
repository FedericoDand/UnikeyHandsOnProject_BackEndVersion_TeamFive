package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr;

import java.util.List;

public interface GenericRestMapper<D, R> {

    D getDtoFromRest(R rest);
    List<D> getDtoListFromRestList(List<R> rests);

    R getRestFromDto(D dto);
    List<R> getRestListFromDtoList(List<D> dtos);

}
