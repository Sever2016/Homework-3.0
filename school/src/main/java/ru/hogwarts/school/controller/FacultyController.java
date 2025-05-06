package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("faculties")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("/filteredByColor/{color}")
    public List<Faculty> filteredByColor(@PathVariable String color) {
        return facultyService.getFacultiesByColor(color);
    }

    @GetMapping("/filteredByColorOrName")
    public List<Faculty> filteredByColorOrName(@RequestParam(required = false) String name, @RequestParam(required = false) String color) {
        return facultyService.getFacultyByColorOrName(name, color);
    }

    @GetMapping("/studentsFromFaculty/{facultyId}")
    public List<Student> getStudentsFromFaculty(@PathVariable Long facultyId) {
        return facultyService.getStudentsFromFaculty(facultyId);
    }
}
