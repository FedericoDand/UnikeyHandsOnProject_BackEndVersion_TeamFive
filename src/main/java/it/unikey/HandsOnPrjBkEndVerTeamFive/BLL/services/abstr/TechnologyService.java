package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import org.webjars.NotFoundException;

import java.util.List;

public interface TechnologyService extends GenericService<TechnologyDTO> {

    List<TechnologyDTO> getByName(String name) throws NotFoundException;
    List<TechnologyDTO> getListByModuleName(String name) throws NotFoundException;

}
