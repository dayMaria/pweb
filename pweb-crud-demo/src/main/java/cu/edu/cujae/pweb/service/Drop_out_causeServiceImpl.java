package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.Drop_out_causeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Drop_out_causeServiceImpl implements Drop_out_causeService{
    @Override
    public List<Drop_out_causeDto> getDrop_out_cause() {

        List<Drop_out_causeDto> drop_out_causes = new ArrayList<>();

        drop_out_causes.add(new Drop_out_causeDto(1,"Suspenso"));
        drop_out_causes.add(new Drop_out_causeDto(2,"Repitencia"));
        drop_out_causes.add(new Drop_out_causeDto(3,"Licencia"));

        return drop_out_causes;
    }

    @Override
    public void createDrop_out_cause(Drop_out_causeDto drop_out_cause) {

    }

    @Override
    public void updateDrop_out_cause(Drop_out_causeDto drop_out_cause) {

    }

    @Override
    public void deleteDrop_out_cause(Drop_out_causeDto drop_out_cause) {

    }
}
