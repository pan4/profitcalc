package profitcalculator.service;

import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import profitcalculator.dto.Exchange;
import profitcalculator.dto.Rates;
import profitcalculator.repository.ExchangeRepository;

import javax.swing.JFormattedTextField;
import java.util.Date;

@Service
public class RecalculationServiceImpl implements RecalculationService {

    @Autowired
    JDateChooser dateChooser;

    @Autowired
    JFormattedTextField amountField;

    @Value("${spread}")
    private double spread;

    @Autowired
    private ExchangeRepository exchangeRepository;

    public double recalculate() {
        Date date = dateChooser.getDate();
        int amount = (Integer) amountField.getValue();

        Exchange latest = exchangeRepository.getLatest();
        Exchange past = exchangeRepository.getPast(date);

        Rates latestRates = latest.getRates();
        double latestRUB = latestRates.getRub();
        double latestUSD = latestRates.getUsd();
        double selling = latestRUB / latestUSD * amount;

        Rates pastRates = past.getRates();
        double pastRUB = pastRates.getRub();
        double pastUSD = pastRates.getUsd();
        double ratio = 1 + spread / 100;
        double purchase = pastRUB / pastUSD * amount * ratio;

        return selling - purchase;
    }
}
