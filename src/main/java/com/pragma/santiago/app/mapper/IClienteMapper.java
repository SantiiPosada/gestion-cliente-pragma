package com.pragma.santiago.app.mapper;

import com.pragma.santiago.app.model.dto.ClienteDTO;
import com.pragma.santiago.app.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface IClienteMapper {


    IClienteMapper INSTANCE = Mappers.getMapper(IClienteMapper.class);

    /*
     *de clientes a clientesDTO
     */

    ArrayList<ClienteDTO> toClientesDTO(ArrayList<Cliente> clientes);


    /*
     *de cliente a ClienteDTO
     */

    ClienteDTO toClienteDTO(Cliente cliente);

    /*
    *de clienteDTO a Cliente
     */
    Cliente toCliente(ClienteDTO clienteDTO);



}
