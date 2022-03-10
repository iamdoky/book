package server.api.book.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.api.book.practice.domain.KospiStockDto;
import server.api.book.practice.service.StockService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/kospi/all")
    public List<KospiStockDto> getKosPiStockList(HttpServletRequest request) {
        return stockService.getKosPiStockList();

    }

}
