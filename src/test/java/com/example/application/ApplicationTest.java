package com.example.application;

import com.example.application.data.entity.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@SpringBootTest
class ApplicationTest {

    @Test
    public void getPessoaId(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<Pessoa> entity = template.getForEntity("http://localhost:8081/pessoa/17", Pessoa.class);
        System.out.println(entity.getBody());
        Assertions.assertEquals(200, entity.getStatusCodeValue());
    }

    @Test
    public void getListaPessoa(){
        RestTemplate template = new RestTemplate();

        ResponseEntity<Pessoa[]> entity = template.getForEntity("http://localhost:8081/pessoa",Pessoa[].class);
        Assertions.assertEquals(200, entity.getStatusCodeValue());
    }

    @Test
    public void salvarPessoa(){
        RestTemplate template = new RestTemplate();

        Pessoa pessoa = new Pessoa(null, "TestePost", "TestePost",
                "Primo", LocalDate.now(), null);

        ResponseEntity<Pessoa> entity = template.postForEntity("http://localhost:8081/pessoa",pessoa,Pessoa.class);
        Assertions.assertEquals(204, entity.getStatusCodeValue());
    }

    @Test
    public void deletarPessoa(){
        RestTemplate template = new RestTemplate();

        Pessoa pessoa = new Pessoa(null, "TestePost", "TestePost",
                "Primo", LocalDate.now(), null);

        template.delete("http://localhost:8081/pessoa/90");
//        Assertions.assertEquals(204, entity.getStatusCodeValue());
    }

    @Test
    public void alterarPessoa(){
        RestTemplate template = new RestTemplate();

        Pessoa pessoa = new Pessoa(null, "TesteUpdate", "TestePost",
                "Primo", LocalDate.now(), null);
        pessoa.setId(94);

        HttpEntity<Pessoa> update = new HttpEntity<>(pessoa);

        ResponseEntity<Pessoa> entity =
                template.exchange("http://localhost:8081/pessoa/94", HttpMethod.PUT, update, Pessoa.class);

        Assertions.assertEquals(204, entity.getStatusCodeValue());
    }
}