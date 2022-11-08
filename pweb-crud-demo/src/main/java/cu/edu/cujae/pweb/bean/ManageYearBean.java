package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.YearDto;
import cu.edu.cujae.pweb.service.YearService;
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
public class ManageYearBean {
    private YearDto yearDto;
    private YearDto selectedYear;
    private List<YearDto> years;

    @Autowired
    private YearService yearService;

    public ManageYearBean(){}

    @PostConstruct
    public void init(){
        years = years == null ? yearService.getYears() : years;
    }

    //Se ejecuta al dar clic en el button Nuevo
    public void openNew(){this.selectedYear = new YearDto();}

    //Se ejecuta al dar clic en el button con el lapicito
    public void openForEdit(){ }

    //Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al curso
    public void saveYear(){
        if (this.selectedYear.getId_year() == null){
            this.selectedYear.setNewRecord(true);
            this.years.add(this.selectedYear);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_year_added");
        }else{
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_year_edited");
        }
    }

    //Permite eliminar un year
    public void deleteYear(){
        try {
            this.years.remove(this.selectedYear);
            this.selectedYear = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_year_deleted");
            PrimeFaces.current().ajax().update("form:dt-years");
        }catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
    }

    public YearDto getYearDto(){return yearDto;}
    public  void setYearDto(YearDto yearDto){this.yearDto = yearDto;}
    public YearDto getSelectedYear(){return selectedYear;}
    public void setSelectedYear(YearDto selectedYear){this.selectedYear = selectedYear;}
    public List<YearDto> getYears(){return years;}
    public void setYears(List<YearDto> years){this.years = years;}
}
