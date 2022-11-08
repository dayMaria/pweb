package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.TownDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TownServiceImpl implements TownService{
    @Override
    public List<TownDto> getTowns() {

        List<TownDto> towns = new ArrayList<>();

        towns.add(new TownDto(1,"Centro Habana"));
        towns.add(new TownDto(2,"Habana Vieja"));
        towns.add(new TownDto(3,"Cerro"));
        towns.add(new TownDto(4,"Marianao"));
        towns.add(new TownDto(5,"Playa"));
        towns.add(new TownDto(6,"La Lisa"));

        return towns;
    }

    @Override
    public void createTown(TownDto town) {

    }

    @Override
    public void updateTown(TownDto town) {

    }

    @Override
    public void deleteTown(TownDto town) {

    }
}
