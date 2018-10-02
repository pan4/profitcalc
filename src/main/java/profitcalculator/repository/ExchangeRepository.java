package profitcalculator.repository;

import profitcalculator.dto.Exchange;

import java.util.Date;


public interface ExchangeRepository {
    Exchange getLatest();

    Exchange getPast(Date date);
}
