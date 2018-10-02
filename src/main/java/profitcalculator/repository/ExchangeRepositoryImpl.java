package profitcalculator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import profitcalculator.dto.Exchange;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExchangeRepositoryImpl implements ExchangeRepository {

    private static String LATEST = "latest";

    @Autowired
    RestOperations restOperations;

    @Value("${fixer.url}")
    private String url;

    public Exchange getLatest() {
        return restOperations.getForObject(url, Exchange.class, LATEST);
    }

    public Exchange getPast(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return restOperations.getForObject(url, Exchange.class, df.format(date));
    }
}
