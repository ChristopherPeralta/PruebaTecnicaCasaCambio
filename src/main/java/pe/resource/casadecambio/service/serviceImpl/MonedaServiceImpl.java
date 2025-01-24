package pe.resource.casadecambio.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.resource.casadecambio.dto.MonedaDTO;
import pe.resource.casadecambio.dto.mapper.MonedaMapper;
import pe.resource.casadecambio.entity.Moneda;
import pe.resource.casadecambio.repository.MonedaRepository;
import pe.resource.casadecambio.service.MonedaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository repository;

    @Override
    public List<MonedaDTO> findAll() {
        return repository.findAll().stream()
                .map(MonedaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MonedaDTO> findById(Long id) {
        return repository.findById(id)
                .map(MonedaMapper::toDto);
    }

    @Override
    public MonedaDTO save(MonedaDTO monedaDTO) {
        Moneda moneda = MonedaMapper.toEntity(monedaDTO);
        return MonedaMapper.toDto(repository.save(moneda));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
