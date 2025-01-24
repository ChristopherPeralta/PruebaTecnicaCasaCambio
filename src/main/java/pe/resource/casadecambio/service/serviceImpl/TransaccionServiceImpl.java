package pe.resource.casadecambio.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.resource.casadecambio.dto.TransaccionDTO;
import pe.resource.casadecambio.entity.Transaccion;
import pe.resource.casadecambio.dto.mapper.TransaccionMapper;
import pe.resource.casadecambio.repository.TipoCambioRepository;
import pe.resource.casadecambio.repository.TransaccionRepository;
import pe.resource.casadecambio.service.TransaccionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    @Autowired
    private TipoCambioRepository tipoCambioRepository;


    @Override
    public List<TransaccionDTO> findAll() {
        return repository.findAll().stream()
                .map(TransaccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TransaccionDTO> findById(Long id) {
        return repository.findById(id)
                .map(TransaccionMapper::toDTO);
    }

    @Override
    public TransaccionDTO save(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = TransaccionMapper.toEntity(transaccionDTO);
        transaccion.setTipoCambio(tipoCambioRepository.findById(transaccionDTO.getTipoCambioId()).orElse(null));
        if (transaccion.getTipoCambio() == null) {
            throw new IllegalArgumentException("Tipo de cambio not found for this id :: " + transaccionDTO.getTipoCambioId());
        }
        transaccion.setMontoConvertido(transaccion.getMonto() * transaccion.getTipoCambio().getTasaCambio());
        Transaccion savedTransaccion = repository.save(transaccion);
        return TransaccionMapper.toDTO(savedTransaccion);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}