package top.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import top.voll.api.domain.curso.DatosCurso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import top.voll.api.domain.topico.*;
import top.voll.api.domain.usuario.DatosAutor;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class topicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosmTopico datosmTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosmTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus().toString(), new DatosAutor( topico.getAutor().getNombre(), topico.getAutor().getEmail(),
                topico.getAutor().getContrasena()), new DatosCurso(topico.getCurso().getNombre(),topico.getCurso().getCategoria()));
        //return 201 created
        //url donde encontrar al topico
        //URI url = "http://localhost:8080/topicos/"+ topicos.getId();
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listamedicos(@PageableDefault(size = 2) Pageable paginacion){
        //return medicorepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizaciontopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus().toString(), new DatosAutor( topico.getAutor().getNombre(), topico.getAutor().getEmail(),
                topico.getAutor().getContrasena()), new DatosCurso(topico.getCurso().getNombre(),topico.getCurso().getCategoria())));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminartopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        //delete a nivel logico
        //topico.desactivartopico();
        //return ResponseEntity.noContent().build();

        //delete a nivel de base de datos
        topicoRepository.delete(topico);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornadatostopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datostopico = (new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus().toString(), new DatosAutor( topico.getAutor().getNombre(), topico.getAutor().getEmail(),
                topico.getAutor().getContrasena()), new DatosCurso(topico.getCurso().getNombre(),topico.getCurso().getCategoria()))
);
        return ResponseEntity.ok(datostopico);
    }
}
