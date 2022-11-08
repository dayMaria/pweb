package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.SubjectDto;
import cu.edu.cujae.pweb.service.SubjectService;
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
public class ManageSubjectBean {
    private SubjectDto subjectDto;
    private SubjectDto selectedSubject;
    private List<SubjectDto> subjects;

    @Autowired
    private SubjectService subjectService;

    public ManageSubjectBean(){

    }

    @PostConstruct
    public void init(){
        subjects = subjects == null ? subjectService.getSubjects() : subjects;
    }

    public void openNew(){this.selectedSubject = new SubjectDto();}

    public void openForEdit(){ }

    public void saveSubject(){
        if (this.selectedSubject.getId_subject() == null){
            this.selectedSubject.setNewRecord(true);
            this.subjects.add(this.selectedSubject);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_subject_added");
        }else{
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_subject_edited");
        }
    }

    public void deleteSubject(){
        try {
            this.subjects.remove(this.selectedSubject);
            this.selectedSubject = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_subject_deleted");
            PrimeFaces.current().ajax().update("form:dt-subjects");
        }catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
    }

    public SubjectDto getSubjectDto(){return subjectDto;}
    public void setSubjectDto(SubjectDto subjectDto){this.subjectDto = subjectDto;}
    public SubjectDto getSelectedSubject(){return selectedSubject;}
    public void setSelectedSubject(SubjectDto selectedSubject){this.selectedSubject = selectedSubject;}
    public List<SubjectDto> getSubjects(){return subjects;}
    public void setSubjects(List<SubjectDto> subjects){this.subjects = subjects;}
}
