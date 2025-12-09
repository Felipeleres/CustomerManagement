package com.felipeleres.customermanagement.dto;


import com.felipeleres.customermanagement.entities.Cliente;


public class ClienteDTO {


    private Long id;
    private String name;
    private String cpf;


    public ClienteDTO (){

    }

    public ClienteDTO(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public ClienteDTO (Cliente cliente){
        id = cliente.getId();
        name = cliente.getName();
        cpf = cliente.getCpf();
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


}