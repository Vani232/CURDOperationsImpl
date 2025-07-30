package com.curdOperationImpl.ImplOfCURD.Service;

import com.curdOperationImpl.ImplOfCURD.Model.Course;
import com.curdOperationImpl.ImplOfCURD.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course create(Course course) {
        return repo.save(course);
    }

    public List<Course> getAll() {
        return repo.findAll();
    }

    public Course update(Long id, Course updatedCourse) {
        return repo.findById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            course.setPublished(updatedCourse.isPublished());
            return repo.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Course> search(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    public List<Course> filterByPublished(boolean status) {
        return repo.findByPublished(status);
    }

    public Course togglePublish(Long id) {
        return repo.findById(id).map(course -> {
            course.setPublished(!course.isPublished());
            return repo.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found"));
    }
}

