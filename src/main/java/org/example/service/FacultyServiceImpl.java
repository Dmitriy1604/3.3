package org.example.service;

import com.example.demo.model.Faculty;
import exception.FacultyNotFoundException;
import org.springframework.stereotype.Service;
import repository.FacultyRepository;

import java.util.Collection;


@Service
public  class FacultyService {

        private final FacultyRepository facultyRepository;


        public FacultyService (FacultyRepository facultyRepository){
            this.facultyRepository = facultyRepository;

        }
        public  Faculty create(Faculty faculty){
            faculty.setId(null);
            return facultyRepository.save(faculty);
        }
        public Faculty read(long id){
            return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException (id));
}
        public Faculty update(long id,
                      Faculty faculty) {
        Faculty oldFaculty = read (id);
        oldFaculty.setName(faculty.getName());
        oldFaculty.setName(faculty.getColor());
        return facultyRepository.save(oldFaculty);
}
        public Faculty delete(long id){
            Faculty faculty = read(id);
            facultyRepository.delete(faculty);
            return faculty;
}
        public Collection<Faculty> findByColor(String color){
            return facultyRepository.findAllByColor(color);

}
    }
