package service.interfaces;

import dto.ProducerDto;

import java.util.List;

public interface ProducerService {
    ProducerDto findById(Integer id);
    ProducerDto save(ProducerDto producerDto);

    void update(ProducerDto producerDto);

    void delete(ProducerDto producerDto);

    List<ProducerDto> findAll(ProducerDto producerDto);
}
