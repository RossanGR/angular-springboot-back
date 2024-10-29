package com.angularSpringBoot.demo.controller;
import com.angularSpringBoot.demo.model.Course;
import com.angularSpringBoot.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor // Gera o construtor através do lombock
public class CoursesController {
    @Autowired
    public final CourseRepository courseRepository;

//    public CoursesController(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//   }

    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return courseRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    // Primeira forma de fazer o cadastro no banco de um dado e fazer o retorno para o front-end.
    // Response Entity é essecial para mostrar o status da requisição(se foi criado, ou deu erro)
    // @PostMapping
    // public ResponseEntity<Course> create (@RequestBody Course course){
    //    return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    //}
    // Segunda forma de fazer o cadastro e o retorno para o front
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course){
        return courseRepository.findById(id)
                .map(record -> {
                    record.setName(course.getName());
                    record.setCategory(course.getCategory());
//                    Course update = ;
                    return ResponseEntity.ok().body(courseRepository.save(record));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return courseRepository.findById(id)
                .map(record -> {
                    courseRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
