package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.TownDto;
import cu.edu.cujae.pweb.service.TownService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ManageTownBean {
    private TownDto townDto;
    private TownDto selectedTown;
    private List<TownDto> towns;

    @Autowired
    private TownService townService;

    public ManageTownBean(){}

    @PostConstruct
    public  void init(){
        towns = towns == null ? townService.getTowns() : towns;
    }

    public void openNew(){this.selectedTown = new TownDto();}

    public void openForEdit(){}

    public void saveTown(){
        if(this.selectedTown.getId_town() == null){
            this.selectedTown.setNewRecord(true);
            this.towns.add(this.selectedTown);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_town_added");
        }else{
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_town_edited");
        }
    }

    public void deleteTown(){
        try {
            this.towns.remove(this.selectedTown);
            this.selectedTown = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_town_deleted");
            PrimeFaces.current().ajax().update("form:dt-towns");
        }catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
    }

    public TownDto getTownDto(){return townDto;}
    public void setTownDto(TownDto townDto){this.townDto = townDto;}
    public TownDto getSelectedTown(){return selectedTown;}
    public void setSelectedTown(TownDto selectedTown){this.selectedTown = selectedTown;}
    public List<TownDto> getTowns(){return towns;}
    public void setTowns(List<TownDto> towns){this.towns = towns;}
}
