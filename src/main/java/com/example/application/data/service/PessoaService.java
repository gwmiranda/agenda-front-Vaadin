package com.example.application.data.service;

import com.example.application.data.entity.Pessoa;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PessoaService{

    private RestTemplate template;
    private String URL = "http://localhost:8081/pessoa/";

    public boolean salvar(Pessoa pessoa) {
        try {
            template = new RestTemplate();
            template.postForEntity(URL, pessoa, Pessoa.class);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean deletar(Pessoa pessoa){
        try {
            template = new RestTemplate();
            template.delete(URL + pessoa.getId());
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<Pessoa> listarPessoas() {
        template = new RestTemplate();
        ResponseEntity<Pessoa[]> entity = template.getForEntity(URL ,Pessoa[].class);
        List<Pessoa> pessoas = Arrays.asList(entity.getBody());
        return pessoas;
    }

    public Pessoa getPessoaID(Integer id){
        template = new RestTemplate();
        ResponseEntity<Pessoa> entity = template.getForEntity(URL + id, Pessoa.class);
        Pessoa pessoa = entity.getBody();
        return pessoa;
    }

    public boolean alterar(Pessoa pessoa){
        try {
            template = new RestTemplate();
            HttpEntity<Pessoa> update = new HttpEntity<>(pessoa);
            template.exchange(URL + pessoa.getId(), HttpMethod.PUT, update, Pessoa.class);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}