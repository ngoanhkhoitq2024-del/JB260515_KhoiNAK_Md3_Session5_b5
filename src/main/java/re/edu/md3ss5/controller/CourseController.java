package re.edu.md3ss5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.md3ss5.dto.ApiResponse;
import re.edu.md3ss5.dto.CourseResponse;
import re.edu.md3ss5.dto.CourseResponseV2;
import re.edu.md3ss5.dto.PageResponse;
import re.edu.md3ss5.entity.CourseStatus;
import re.edu.md3ss5.service.CourseService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CourseResponseV2>>> getCourses(
            @RequestParam(defaultValue ="0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) Sort.Direction direction,
            @RequestParam(required = false) CourseStatus status,
            @RequestParam(required = false) String keyword) {
        PageResponse<CourseResponseV2> result =
                courseService.getPagedCourses(page,size,sortBy,direction, status, keyword);
        return ResponseEntity.ok(new ApiResponse<>(true, "OK", result));
    }
}
