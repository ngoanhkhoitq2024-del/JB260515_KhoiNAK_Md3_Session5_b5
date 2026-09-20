package re.edu.md3ss5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import re.edu.md3ss5.entity.Course;
import re.edu.md3ss5.entity.CourseStatus;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("""
    SELECT c FROM Course c
    WHERE (:status IS NULL OR c.status = :status)
    AND (:keyword IS NULL OR :keyword = ''
         OR LOWER(c.title) LIKE LOWER(CONCAT('%', :keyword, '%')))
""")
    Page<Course> searchCourses(
            @Param("status") CourseStatus status,
            @Param("keyword") String keyword,
            Pageable pageable
    );
}
