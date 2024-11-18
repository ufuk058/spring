package com.query.repository;

import com.query.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //Display all courses by Category
   // List<Course> findByCategory(String category);
    Integer countByIdIsNotNull();//Number of courses with not null id

    //Display all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //Display if a course with the supplied name exist. Return true if exists, false otherwise
    boolean existsByName(String name);

    ///Return the count of courses for the given Category
    Integer countByCategory(String category);

    /// Find all the courses that starts With the Given course name string
    List<Course> findByNameStartsWith(String substring);

    /// Display all courses by category and returns a stream


    @Transactional
    Stream<Course> streamAllByCategory(String category);
}
