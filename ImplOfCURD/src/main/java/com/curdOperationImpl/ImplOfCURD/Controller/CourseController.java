package com.curdOperationImpl.ImplOfCURD.Controller;

import com.curdOperationImpl.ImplOfCURD.Model.Course;
import com.curdOperationImpl.ImplOfCURD.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        return ResponseEntity.ok(service.create(course));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        return ResponseEntity.ok(service.update(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Course>> search(@RequestParam String title) {
        return ResponseEntity.ok(service.search(title));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Course>> filter(@RequestParam boolean published) {
        return ResponseEntity.ok(service.filterByPublished(published));
    }

    @PostMapping("/{id}/toggle")
    public ResponseEntity<Course> toggle(@PathVariable Long id) {
        return ResponseEntity.ok(service.togglePublish(id));
    }
}

