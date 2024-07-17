package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import med.voll.api.domain.repository.TopicoRepository;
import med.voll.api.domain.topico.DataAtualizarTopico;
import med.voll.api.domain.topico.DataCadastroTopico;
import med.voll.api.domain.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public void cadastrarTopico(@RequestBody DataCadastroTopico data) {
        Topico novoTopico = new Topico(null, data.titulo(), data.mensagem(), data.dtCriacao(), data.estadoTopico(), data.autor(), data.curso());
        topicoRepository.save(novoTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarTopico(@PathVariable Integer id, @RequestBody DataAtualizarTopico data) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.atualizarData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarTopico(@PathVariable Integer id) {
        topicoRepository.deleteById(id);
    }
}
