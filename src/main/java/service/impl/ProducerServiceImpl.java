package service.impl;

import dao.impl.DaoProducerImpl;
import dao.interfaces.DaoProducer;
import dto.ProducerDto;
import mapper.impl.ProducerMapperImpl;
import mapper.interfaces.ProducerMapper;
import service.interfaces.ProducerService;

import java.util.List;
import java.util.stream.Collectors;

public class ProducerServiceImpl implements ProducerService {
    private static DaoProducerImpl dao = new DaoProducerImpl();
    private ProducerMapper mapper = new ProducerMapperImpl();

    @Override
    public ProducerDto findById(Integer id) {
        dao.getEm().clear();
        return mapper.entityToDto(dao.findById(id));
    }

    @Override
    public ProducerDto save(ProducerDto producerDto) {
        dao.save(mapper.dtoToEntity(producerDto));
        return producerDto;
    }

    @Override
    public void update(ProducerDto producerDto) {
        dao.update(mapper.dtoToEntity(producerDto));
    }

    @Override
    public void delete(ProducerDto producerDto) {
        dao.delete(mapper.dtoToEntity(producerDto));
    }

    @Override
    public List<ProducerDto> findAll(ProducerDto producerDto) {
        dao.getEm().clear();
        return dao.findAll(mapper.dtoToEntity(producerDto))
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

}
