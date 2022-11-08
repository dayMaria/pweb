package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.CourseDto;
import cu.edu.cujae.pweb.service.CourseService;
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
public class ManageCourseBean {
    private CourseDto courseDto;
    private CourseDto selectedCourse;
    private List<CourseDto> courses;

    @Autowired
    private CourseService courseService;

    public ManageCourseBean(){

    }

    @PostConstruct
    public void init(){
        courses = courses == null ? courseService.getCourses() : courses;
    }

    //Se ejecuta al dar clic en el button Nuevo
    public void openNew(){
        this.selectedCourse = new CourseDto();
    }

    //Se ejecuta al dar clic en el button con el lapicito
    public void openForEdit(){

    }

    //Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al curso
    public void saveCourse(){
        if(this.selectedCourse.getId_course() == null){
          // this.selectedCourse.setId_course();/////////////////////REVISAR
            this.selectedCourse.setNewRecord(true);
           this.courses.add(this.selectedCourse);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_course_added");
        }else{
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_course_edited");
        }
    }

    //Permite eliminar un curso
    public void deleteCourse(){
        try {
            this.courses.remove(this.selectedCourse);
            this.selectedCourse = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_course_deleted");
            PrimeFaces.current().ajax().update("form:dt-courses");
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }
    }

    public CourseDto getCourseDto(){return courseDto;}
    public void setCourseDto(CourseDto courseDto){this.courseDto = courseDto;}
    public CourseDto getSelectedCourse(){return selectedCourse; }
    public void setSelectedCourse(CourseDto selectedCourse){this.selectedCourse = selectedCourse; }
    public List<CourseDto> getCourses(){return courses;}
    public void setCourses(List<CourseDto> courses){this.courses = courses;}
}
