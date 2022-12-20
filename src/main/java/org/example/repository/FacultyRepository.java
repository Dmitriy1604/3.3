package org.example.repository;

import com.example.demo.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Collection<Faculty> findAllByColor(String color);
}
