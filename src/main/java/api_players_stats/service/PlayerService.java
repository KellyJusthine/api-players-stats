package api_players_stats.service;

import api_players_stats.entity.Player;
import api_players_stats.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayerByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByNation(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }


    public Player updatePlayer(Player updatePlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatePlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();

            if (updatePlayer.getName() != null) {
                playerToUpdate.setName(updatePlayer.getName());
            }
            if (updatePlayer.getAge() != null) {
                playerToUpdate.setAge(updatePlayer.getAge());
            }
            if (updatePlayer.getHeight() != null) {
                playerToUpdate.setHeight(updatePlayer.getHeight());
            }
            if (updatePlayer.getPos() != null) {
                playerToUpdate.setPos(updatePlayer.getPos());
            }
            if (updatePlayer.getNation() != null) {
                playerToUpdate.setNation(updatePlayer.getNation());
            }
            if (updatePlayer.getGls() != null) {
                playerToUpdate.setGls(updatePlayer.getGls());
            }
            if (updatePlayer.getGlsConceded() != null) {
                playerToUpdate.setGlsConceded(updatePlayer.getGlsConceded());
            }
            if (updatePlayer.getAst() != null) {
                playerToUpdate.setAst(updatePlayer.getAst());
            }
            if (updatePlayer.getMp() != null) {
                playerToUpdate.setMp(updatePlayer.getMp());
            }
            if (updatePlayer.getSaves() != null) {
                playerToUpdate.setSaves(updatePlayer.getSaves());
            }
            if (updatePlayer.getRedCards() != null) {
                playerToUpdate.setRedCards(updatePlayer.getRedCards());
            }
            if (updatePlayer.getYellowCards() != null) {
                playerToUpdate.setYellowCards(updatePlayer.getYellowCards());
            }

            return playerRepository.save(playerToUpdate);
        } else {
            return null;
        }
    }

    public Player savePlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}
