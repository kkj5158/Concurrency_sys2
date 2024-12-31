package org.example.stock.service;

import lombok.Synchronized;
import org.example.stock.domain.Stock;
import org.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

  private final StockRepository stockRepository;

  public StockService(StockRepository stockRepository){
    this.stockRepository = stockRepository;
  }

  @Synchronized
  public void decrease(Long id, Long quantity){

    //Stock 조회
    Stock stock = stockRepository.findById(id).orElseThrow();

    // 재고를 감소시킨다.

    stock.decrease(quantity);

    // 갱신된 값을 저장하도록 한다.

    stockRepository.saveAndFlush(stock);
  }




}
