package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr;

public interface GenericRestMapper<D, R> {

    D getDtoFromRest(R rest);
    R getRestFromDto(D dto);

}
