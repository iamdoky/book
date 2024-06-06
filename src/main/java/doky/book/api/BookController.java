package doky.book.api;

import doky.book.application.BookService;
import doky.book.payload.request.NaverSearchRequest;
import doky.book.payload.response.NaverBookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Tag(name = "Naver Book")
@RequestMapping("/api/naver")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @Operation(summary = "네이버 책 검색", description = "네이버 책 검색을 합니다.")
    @GetMapping(value = "")
    public ResponseEntity<Mono<NaverBookResponse>> search(NaverSearchRequest request) {

//            @Parameter(name = "keyword", description = "키워드 ex) 제목, ISBN, 저자명 ,,, ")
//            @RequestParam(value = "keyword", defaultValue = "클린코드") String keyword,
//            @Parameter(name = "display", description = "한 번에 표시할 검색 결과 개수(기본값: 10, 최댓값: 100)")
//            @RequestParam(value = "display", defaultValue = "10") int display,
//            @Parameter(name = "start", description = "검색 시작 위치(기본값: 1, 최댓값: 1000)")
//            @RequestParam(value = "start", defaultValue = "1") int start) {



        return ResponseEntity.ok(bookService.search(request));
    }
}
