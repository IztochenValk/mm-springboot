package com.adrar.cdafad.service;

import com.adrar.cdafad.entity.Game;
import com.adrar.cdafad.entity.Manufacturer;
import com.adrar.cdafad.exception.game.GameIsNotExistsException;
import com.adrar.cdafad.exception.game.GameIsPresentException;
import com.adrar.cdafad.exception.game.GameListIsEmptyException;
import com.adrar.cdafad.exception.game.DeleteGameImpossibleException;
import com.adrar.cdafad.exception.manufacturer.DeleteManufacturerImpossibleException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerIsNotExistsException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerIsPresentException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerListIsEmptyException;
import com.adrar.cdafad.repository.CategoryRepository;
import com.adrar.cdafad.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepository gameRepository;
    //Méthodes du service
    //Méthode qui ajoute un jeu
    public Game createGame(Game game)  {
        if (gameRepository.existsByTitle(game.getTitle())) {
            throw new GameIsPresentException(game.getTitle());
        }
        return gameRepository.save(game);

    }
    public Game getGameById(Integer id){
        //Récupération de la manufacturer (findById du repository)
        Optional<Game> game = gameRepository.findById(id);
        //Test si elle n'existe pas
        if (!game.isPresent()) {
            throw new GameIsNotExistsException(id);
        }
        return game.get();
    }
    //méthode qui retourne la liste de tous les jeux
    public Iterable<Game> getAllGames()  {
        //Test si la list est vide
        if (gameRepository.count() == 0) {
            throw new GameListIsEmptyException();
        }
        return gameRepository.findAll();
    }
    public void deleteGameById(Integer id)
    {
        try {
            this.gameRepository.deleteById(id);
        } catch (Exception e)
        {
            throw new DeleteGameImpossibleException();
        }
    }
}
