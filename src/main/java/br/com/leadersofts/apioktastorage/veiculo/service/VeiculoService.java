package br.com.leadersofts.apioktastorage.veiculo.service;

import br.com.leadersofts.apioktastorage.client.MotoFipeClient;
import br.com.leadersofts.apioktastorage.client.VeiculoFipeClient;
import br.com.leadersofts.apioktastorage.enums.TipoVeiculoEnum;
import br.com.leadersofts.apioktastorage.veiculo.domain.Veiculo;
import br.com.leadersofts.apioktastorage.veiculo.dto.VeiculoDTO;
import br.com.leadersofts.apioktastorage.veiculo.mapper.VeiculoMapper;
import br.com.leadersofts.apioktastorage.veiculo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MotoFipeClient motoFipeClient;

    @Autowired
    private VeiculoFipeClient veiculoFipeClient;

    @Autowired
    private VeiculoMapper veiculoMapper;

    public Veiculo save(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    public Veiculo saveOrUpdate(Veiculo veiculo) {

        if(Objects.nonNull(veiculo.getCodigoFipe())) {

            var veiculoToPBePersited = this.getVehicleByCodigoFipe(veiculo.getCodigoFipe());

            if(!veiculoToPBePersited.isPresent() && this.canSave(veiculo)) {
                return this.veiculoRepository.save(veiculo);
            }
            else {
                if (veiculoToPBePersited.isPresent()  && this.canSave(veiculo)) {
                    var veiculoUpdate = veiculoToPBePersited.get();
                    veiculoUpdate.setAnoModelo(!Objects.isNull(veiculo.getAnoModelo()) ? veiculo.getAnoModelo().toString() : "");
                    veiculoUpdate.setCor(!Objects.isNull(veiculo.getCor()) ? veiculo.getCor() : "");
                    veiculoUpdate.setCombustivel(!Objects.isNull(veiculo.getCombustivel()) ? veiculo.getCombustivel() : "");
                    veiculoUpdate.setTipoVeiculo(!Objects.isNull(veiculo.getTipoVeiculo()) ? veiculo.getTipoVeiculo() : 0L);
                    veiculoUpdate.setMarca(!Objects.isNull(veiculo.getMarca()) ? veiculo.getMarca() : "");
                    veiculoUpdate.setModelo(!Objects.isNull(veiculo.getModelo()) ? veiculo.getModelo() : "");
                    veiculoUpdate.setNome(!Objects.isNull(veiculo.getNome()) ? veiculo.getNome() : "");
                    veiculoUpdate.setCodigoAno(!Objects.isNull(veiculo.getCodigoAno()) ? veiculo.getCodigoAno() : "");
                    veiculoUpdate.setCodigoFipe(!Objects.isNull(veiculo.getCodigoFipe()) ? veiculo.getCodigoFipe() : "");
                    veiculoUpdate.setKilometragem(!Objects.isNull(veiculo.getKilometragem()) ? veiculo.getKilometragem() : 0F);
                    veiculoUpdate.setMesReferencia(!Objects.isNull(veiculo.getMesReferencia()) ? veiculo.getMesReferencia() : "");
                    veiculoUpdate.setPlaca(!Objects.isNull(veiculo.getPlaca()) ? veiculo.getPlaca() : "");
                    veiculoUpdate.setOpcionais(!Objects.isNull(veiculo.getOpcionais()) ? veiculo.getOpcionais() : "");
                    veiculoUpdate.setSiglaCombustivel(!Objects.isNull(veiculo.getSiglaCombustivel()) ? veiculo.getSiglaCombustivel() : "");
                    veiculoUpdate.setValor(!Objects.isNull(veiculo.getValor()) ? veiculo.getValor() : 0F);
                    return this.veiculoRepository.save(veiculoUpdate);
                }
            }

        }

            return veiculo;
    }

    private boolean canSave(Veiculo veiculo) {
        return Objects.nonNull(veiculo.getNome()) && Objects.nonNull(veiculo.getMarca()) && Objects.nonNull(veiculo.getModelo()) && Objects.nonNull(veiculo.getValor()) &&
                Objects.nonNull(veiculo.getCombustivel()) && Objects.nonNull(veiculo.getSiglaCombustivel()) && Objects.nonNull(veiculo.getTipoVeiculo())
                && Objects.nonNull(veiculo.getAnoModelo())
                &&
                !veiculo.getNome().isBlank() && !veiculo.getMarca().isBlank() && !veiculo.getModelo().isBlank() && veiculo.getValor() != 0L &&
                !veiculo.getCombustivel().isEmpty() && !veiculo.getSiglaCombustivel().isEmpty() && !veiculo.getAnoModelo().isEmpty();
    }

    public void delete(Long id) {

        var vehicleToBeDeleted = Optional.of(this.veiculoRepository.getOne(id));

        if(vehicleToBeDeleted.isPresent()) {
            // TODO-LEANDRO implementar regra aqui
            this.veiculoRepository.deleteById(id);
        }

    }

    public Optional<Veiculo> getVeiculoById(Long id) {
        return Optional.of(this.veiculoRepository.getOne(id));
    }

    public Optional<Veiculo> getVehicleByCodigoFipe(String codigoFipe) {
        return this.veiculoRepository.findVeiculoByCodigoFipe(codigoFipe);
    }

    
    public List<Veiculo> findAll() {
        return this.veiculoRepository.findAll();
    }

//    public VeiculoDTO findVeiculoByName(Long idMarca, String nomeVeiculo) {
//
//        var veiculosResponse = this.fipeClient.getModelosVeiculos(idMarca,nomeVeiculo);
//
//        var modelo = veiculosResponse.stream()
//                .filter(veiculo -> veiculo.getNome().equals(nomeVeiculo))
//                .findFirst().orElseThrow(NoClassDefFoundError::new);
//
//        var x = Modelo.builder().codigo(modelo.getCodigo()).nome(modelo.getNome()).build();
//
//        Modelo modeloDTO = this.modeloMapper.getModeloDTO();
//
////        return this.veiculoMapper.getVeiculoDTO(veiculoModelFromPojo);
//        return null;
//    }

    public VeiculoDTO getVeiculoFipe(Long codigoMarca, Long codigoModelo, String yearCode, String tipoVeiculo) {

        if(tipoVeiculo.equals(TipoVeiculoEnum.MOTORCYCLE.getValue()) ) {
            this.motoFipeClient.initValues();
            var moto = this.motoFipeClient.getVeiculoTabelaFipe(codigoMarca,codigoModelo,yearCode);
            var veiculoDTO = this.veiculoMapper.convertPojoToDTO(moto,yearCode);
            return veiculoDTO;
        }

        this.veiculoFipeClient.initValues();
        var response = this.veiculoFipeClient.getVeiculoTabelaFipe(codigoMarca,codigoModelo,yearCode);
        var veiculoDTO = this.veiculoMapper.convertPojoToDTO(response,yearCode);
        return veiculoDTO;
    }

    public Veiculo getVeiculoEntity(VeiculoDTO veiculoFipe) {
        return this.veiculoMapper.getVeiculo(veiculoFipe);
    }

    public VeiculoDTO getVeiculoDTO(Veiculo veiculo) {
        return this.veiculoMapper.getVeiculoDTO(veiculo);
    }

    public Veiculo getVeiculoByCodigoAnoVeiculo(String codigoAno) {
        return this.veiculoRepository.findVeiculoByCodigoAnoVeiculo(codigoAno);
    }

    public VeiculoDTO findVeiculoByName(Long idMarca, String name) {
        return null;
    }

    public VeiculoDTO findVeiculoByCodigoFipe(String codigoFipe) {
        var fetchedVehicle = this.veiculoRepository.findVeiculoByCodigoFipe(codigoFipe).orElseThrow(IllegalStateException::new);
        return this.veiculoMapper.getVeiculoDTO(fetchedVehicle);
    }

    public List<VeiculoDTO> getVeiculos(List<Veiculo> veiculos) {
        List<VeiculoDTO> veiculoDTOList = new ArrayList<>();

        veiculos.stream()
                .map( veiculo -> veiculoDTOList.add(this.veiculoMapper.getVeiculoDTO(veiculo)))
                .collect(Collectors.toList());
        return veiculoDTOList;
    }

    public Optional<Veiculo> findById(Long id) {
        return this.veiculoRepository.findById(id);
    }
}
