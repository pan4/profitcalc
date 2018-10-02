package profitcalculator.configuration;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JDateChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import profitcalculator.ui.button.ActionListenerButton;
import profitcalculator.ui.button.RecalculateButtonActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Date;

/**
 * Created by Александр on 01.10.2018.
 */
@Configuration
public class ProfitCalculatorConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, mappingJacksonHttpMessageConverter());
        return restTemplate;
    }

    @Bean
    public JDateChooser dateChooser(){
        JDateChooser chooser = new JDateChooser();
        chooser.setMaxSelectableDate(new Date());
        chooser.setDateFormatString("dd-MM-yyyy");
        chooser.setDate(new Date());
        return chooser;
    }

    @Bean JFormattedTextField amountField(){
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField field = new JFormattedTextField(formatter);
        field.setValue(0);
        return field;
    }

    @Bean
    public JButton recalculateButton(){
        ActionListenerButton button = new ActionListenerButton();
        button.setActionListener(recalculateButtonActionListener());
        button.setText("Recalculate");
        return button;
    }

    @Bean
    public ActionListener recalculateButtonActionListener(){
        return new RecalculateButtonActionListener();
    }

    @Bean
    public JTextField resultField(){
        JTextField field = new JTextField();
        field.setEditable(false);
        return field;
    }
}
