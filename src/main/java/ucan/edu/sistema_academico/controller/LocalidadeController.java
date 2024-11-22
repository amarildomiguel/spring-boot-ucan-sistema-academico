package ucan.edu.sistema_academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucan.edu.sistema_academico.entities.Localidade;
import ucan.edu.sistema_academico.services.LocalidadeService;
import ucan.edu.sistema_academico.utils.ResponseBody;

import java.util.Optional;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController extends BaseController {

    @Autowired
    private LocalidadeService service;

    @GetMapping
    public ResponseEntity<ResponseBody> get() {
        return this.ok("Lista", this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> find(@PathVariable Integer id) {
        Optional<Localidade> entidade = this.service.findById(id);
        if (entidade.isPresent())
            return this.ok("Encontrado com sucesso.", entidade.get());
        return this.naoEncontrado("Não encontrada.", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> create(@RequestBody Localidade entidade) {
        return this.created("Adicionado com sucesso.", this.service.create(entidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> delete(@PathVariable("id") Integer id) {
        return this.ok("Eliminado com sucesso.", this.service.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> edit(@PathVariable("id") Integer id, @RequestBody Localidade entidade) {
        return this.ok("Editado com sucesso.", (Localidade) service.update(id, entidade));
    }
}