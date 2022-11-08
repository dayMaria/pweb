package cu.edu.cujae.pweb.service;


import cu.edu.cujae.pweb.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();
    void createCourse(CourseDto course);
    void updateCourse(CourseDto course);
    void deleteCourse(CourseDto course);
}
