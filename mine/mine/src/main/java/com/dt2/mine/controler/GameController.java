package com.dt2.mine.controler;

import com.dt2.mine.entities.Game;
import com.dt2.mine.repositories.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jogos")
public class GameController {
    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Game> get() {
        return repository.findAll();
    }

    @PostMapping
    public String criar(@RequestBody Game game) {
        try {
            repository.save(game);
            return"Game calvo sucesso" + game;
        }
        catch (Exception e){
            return"deu red!";
        }
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "Excluido com sucesso";
    }
}
