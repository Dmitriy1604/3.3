package org.example.controller;

import com.example.demo.model.Faculty;
import com.example.demo.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("faculties")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty read(@PathVariable long id){
        return facultyService.read(id);
    }
    @PutMapping("/{id}")
    public Faculty update(@PathVariable long id,
                                @RequestBody @Valid Faculty faculty){
       return facultyService.update(id, faculty);
    }
    @DeleteMapping("/{id}")
    public Faculty delete(@PathVariable long id){
        return facultyService.delete(id);
    }
    @GetMapping
    public Collection<Faculty> findByColor(@RequestParam String color){
        return facultyService.findByColor(color);

    }

}
