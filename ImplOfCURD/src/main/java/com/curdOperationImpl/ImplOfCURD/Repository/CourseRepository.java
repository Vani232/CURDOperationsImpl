package com.curdOperationImpl.ImplOfCURD.Repository;

import com.curdOperationImpl.ImplOfCURD.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByPublished(boolean published);
    List<Course> findByTitleContainingIgnoreCase(String title);
}
