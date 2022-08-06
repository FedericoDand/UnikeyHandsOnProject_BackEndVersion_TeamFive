package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TopicDTO;
import org.webjars.NotFoundException;

import java.util.List;

public interface TopicService extends  GenericService<TopicDTO> {

    List<TopicDTO> getByName(String name) throws NotFoundException;
    List<TopicDTO> getListByTechnologyName (String name) throws NotFoundException;

}
