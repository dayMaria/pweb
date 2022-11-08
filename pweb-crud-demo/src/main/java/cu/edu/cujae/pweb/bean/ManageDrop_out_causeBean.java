package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.Drop_out_causeDto;
import cu.edu.cujae.pweb.service.Drop_out_causeService;
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
public class ManageDrop_out_causeBean {
    private Drop_out_causeDto drop_out_causeDto;
    private Drop_out_causeDto selectedDrop_out_cause;
    private List<Drop_out_causeDto> drop_out_causes;

    @Autowired
    private Drop_out_causeService drop_out_causeService;

    public ManageDrop_out_causeBean(){}

    @PostConstruct
    public void init(){
        drop_out_causes = drop_out_causes == null ? drop_out_causeService.getDrop_out_cause() : drop_out_causes;
    }

    public void openNew(){this.selectedDrop_out_cause = new Drop_out_causeDto();}

    public void openForEdit(){

    }

    public void saveDrop_out_cause(){
        if (this.selectedDrop_out_cause.getId_droup_out_cause() == null){
            this.selectedDrop_out_cause.setNewRecord(true);
            this.drop_out_causes.add(this.selectedDrop_out_cause);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_drop_out_cause_added");
        }else{
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_drop_out_cause_edited");
        }
    }

    public void deleteDrop_out_cause(){
        try {
            this.drop_out_causes.remove(this.selectedDrop_out_cause);
            this.selectedDrop_out_cause = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_drop_out_cause_deleted");
            PrimeFaces.current().ajax().update("form:dt-drop_out_cause");
        }catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
    }

    public Drop_out_causeDto getDrop_out_causeDto() {
        return drop_out_causeDto;
    }

    public void setDrop_out_causeDto(Drop_out_causeDto drop_out_causeDto) {
        this.drop_out_causeDto = drop_out_causeDto;
    }

    public Drop_out_causeDto getSelectedDrop_out_cause() {
        return selectedDrop_out_cause;
    }

    public void setSelectedDrop_out_cause(Drop_out_causeDto selectedDrop_out_cause) {
        this.selectedDrop_out_cause = selectedDrop_out_cause;
    }

    public List<Drop_out_causeDto> getDrop_out_causes() {
        return drop_out_causes;
    }

    public void setDrop_out_causes(List<Drop_out_causeDto> drop_out_causes) {
        this.drop_out_causes = drop_out_causes;
    }
}
