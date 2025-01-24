package pe.resource.casadecambio.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.dto.mapper.TipoCambioMapper;
import pe.resource.casadecambio.entity.TipoCambio;
import pe.resource.casadecambio.repository.MonedaRepository;
import pe.resource.casadecambio.repository.TipoCambioRepository;
import pe.resource.casadecambio.service.TipoCambioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    private TipoCambioRepository repository;

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public List<TipoCambioDTO> findAll() {
        return repository.findAll().stream()
                .map(TipoCambioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoCambioDTO> findById(Long id) {
        return repository.findById(id)
                .map(TipoCambioMapper::toDto);
    }

    @Override
    public TipoCambioDTO save(TipoCambioDTO tipoCambioDTO) {
        TipoCambio tipoCambio = TipoCambioMapper.toEntity(tipoCambioDTO);
        tipoCambio.setMonedaOrigen(monedaRepository.findById(tipoCambioDTO.getMonedaOrigen().getId()).orElse(null));
        tipoCambio.setMonedaDestino(monedaRepository.findById(tipoCambioDTO.getMonedaDestino().getId()).orElse(null));
        TipoCambio savedTipoCambio = repository.save(tipoCambio);
        return TipoCambioMapper.toDto(savedTipoCambio);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TipoCambioDTO updateTasaCambio(Long id, Double nuevaTasa) {
        Optional<TipoCambio> tipoCambioOpt = repository.findById(id);
        if (!tipoCambioOpt.isPresent()) {
            throw new IllegalArgumentException("Tipo de cambio not found for this id :: " + id);
        }
        TipoCambio tipoCambio = tipoCambioOpt.get();
        tipoCambio.setTasaCambio(nuevaTasa);
        TipoCambio updatedTipoCambio = repository.save(tipoCambio);
        return TipoCambioMapper.toDto(updatedTipoCambio);
    }
}
