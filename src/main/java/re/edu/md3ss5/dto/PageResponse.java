package re.edu.md3ss5.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageResponse<T> {
    private List<T> items;  // Ds dữ liệu trang hiện tại
    private int page;       // Số trang hiện tại
    private int size;       // Số phtu tối đa trong 1 trang
    private long totalItems; // tổng số bản ghi
    private int totalPages; //tổng số trang
    private boolean isLast;
}