package api_players_stats.controller;

import api_players_stats.entity.Player;
import api_players_stats.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/players")
public class PlayerPageController {

    private final PlayerService playerService;

    public PlayerPageController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showPlayersPage() {
        return "players";
    }

    @GetMapping("/all")
    public String showAllPlayers(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }

    @GetMapping("/search")
    public String searchPlayers(@RequestParam(required = false) String query, Model model) {
        List<Player> players = playerService.getPlayers();

        if (query != null && !query.isEmpty()) {
            String lowerQuery = query.toLowerCase();
            players = players.stream()
                    .filter(player ->
                            player.getName().toLowerCase().contains(lowerQuery) ||
                                    player.getPos().toLowerCase().contains(lowerQuery) ||
                                    player.getNation().toLowerCase().contains(lowerQuery))
                    .collect(Collectors.toList());
        }

        model.addAttribute("players", players);
        return "players";
    }
}
