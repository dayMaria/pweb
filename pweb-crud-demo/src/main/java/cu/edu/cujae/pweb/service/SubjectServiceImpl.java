package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.SubjectDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Override
    public List<SubjectDto> getSubjects() {
        List<SubjectDto> subjects = new ArrayList<>();

        subjects.add(new SubjectDto(1,"Diseño Software"));
        subjects.add(new SubjectDto(2,"Programación web"));
        subjects.add(new SubjectDto(3,"Ingeniería de Requisitos Avanzada"));
        subjects.add(new SubjectDto(3,"Seguridad Informática"));

        return subjects;
    }

    @Override
    public void createSubject(SubjectDto subject) {

    }

    @Override
    public void updateSubject(SubjectDto subject) {

    }

    @Override
    public void deleteSubject(SubjectDto subject) {

    }
}
