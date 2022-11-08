package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.YearDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YearServiceImpl implements YearService{

    @Override
    public List<YearDto> getYears() {

        List<YearDto> years = new ArrayList<>();

        years.add(new YearDto(1,"Primero"));
        years.add(new YearDto(2,"Segundo"));
        years.add(new YearDto(3,"Tercero"));
        years.add(new YearDto(4,"Cuarto"));
        return years;
    }

    @Override
    public void createYear(YearDto year) {

    }

    @Override
    public void updateYear(YearDto year) {

    }

    @Override
    public void deleteYear(YearDto year) {

    }
}
