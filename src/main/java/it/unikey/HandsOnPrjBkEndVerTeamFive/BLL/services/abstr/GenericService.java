package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface GenericService<D> {
    /**
     * ############
     * #  CREATE  #
     * ############
     */
    D insert(D rest);

    /**
     * ##########
     * #  READ  #
     * ##########
     */
    D getById(Integer id) throws EntityNotFoundException;
    List<D> getAll();

    /**
     * ############
     * #  UPDATE  #
     * ############
     */
    D update(D rest) throws EntityNotFoundException;

    /**
     * ############
     * #  DELETE  #
     * ############
     */
    void deleteById(Integer id) throws EntityNotFoundException;

}
