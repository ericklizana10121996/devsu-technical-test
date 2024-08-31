package devsu.movements.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
public class GenericMapper {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public <T, D> D mapItem(T item, Class<D> cl) {
        return modelMapper().map(item, cl);
    }

    public <T, D> List<D> map(List<T> list, Class<D> cl) {
        return list.stream().map(item -> modelMapper().map(item, cl)).toList();
    }
}
