package com.felipeleres.customermanagement.dto;


import com.felipeleres.customermanagement.entities.Cliente;
import com.felipeleres.customermanagement.entities.Processo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


public class ClienteProDTO {


    private Long id;

    @NotBlank
    @Size(min = 10,message = "Campo requerido, deve informar o nome do cliente!")
    private String name;

    @NotNull(message = "Campo requirido, deve informar o cpf do cliente!")
    private String cpf;

    private List<ProcessoDTO> processosDTO = new ArrayList<>();


    public ClienteProDTO(){

    }

    public ClienteProDTO(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public ClienteProDTO(Cliente cliente){
        id = cliente.getId();
        name = cliente.getName();
        cpf = cliente.getCpf();
        for(Processo x : cliente.getProcessos()){
            processosDTO.add(new ProcessoDTO(x));
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public List<ProcessoDTO> getProcessosDTO (){
        return  processosDTO;
    }

    public void addProcessosDTO (ProcessoDTO processoDTO){
        processosDTO.add(processoDTO);
    }

}