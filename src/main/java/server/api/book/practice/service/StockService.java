package server.api.book.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.book.practice.component.JsoupComponent;
import server.api.book.practice.domain.KospiStockDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final JsoupComponent jsoupComponent;

    public List<KospiStockDto> getKosPiStockList() {
        return jsoupComponent.getKosPiStockList();
    }

}
