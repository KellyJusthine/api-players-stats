package api_players_stats.repository;

import api_players_stats.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {

    void deleteByName (String playerName);

    Optional<Player> findByName(String name);
}
