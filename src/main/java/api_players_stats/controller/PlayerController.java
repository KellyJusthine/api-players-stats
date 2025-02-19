package api_players_stats.controller;

import api_players_stats.entity.Player;
import api_players_stats.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String pos,
            @RequestParam(required = false) String nation) {

        List<Player> players;

        if (name != null || pos != null || nation != null) {
            players = playerService.getPlayers().stream()
                    .filter(player -> (name == null || player.getName().equalsIgnoreCase(name)) &&
                            (pos == null || player.getPos().equalsIgnoreCase(pos)) &&
                            (nation == null || player.getNation().equalsIgnoreCase(nation)))
                    .collect(Collectors.toList());
        } else {
            players = playerService.getPlayers();
        }
        if (players.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player updatePlayer) {
        Player resultPlayer = playerService.updatePlayer(updatePlayer);
        if (resultPlayer != null) {
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}