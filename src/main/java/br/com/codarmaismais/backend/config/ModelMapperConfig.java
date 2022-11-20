package br.com.codarmaismais.backend.config;

import br.com.codarmaismais.backend.dto.ClienteForm;
import br.com.codarmaismais.backend.model.Cliente;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // https://stackoverflow.com/questions/39454492/modelmapper-to-convert-from-string-to-localdate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Converter<String, LocalDate> stringToLocalDate = contexto -> LocalDate.parse(contexto.getSource(),formatter);
        modelMapper.createTypeMap(ClienteForm.class, Cliente.class)
                .addMappings(mapper -> mapper.using(stringToLocalDate)
                        .map(ClienteForm::getDataNascimento, Cliente::setDataNascimento));

        return modelMapper;
    }
}
