package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.ModuleDTO;
import org.webjars.NotFoundException;

import java.util.List;

public interface ModuleService extends GenericService<ModuleDTO> {

    List<ModuleDTO> getByName(String name) throws NotFoundException;

}
