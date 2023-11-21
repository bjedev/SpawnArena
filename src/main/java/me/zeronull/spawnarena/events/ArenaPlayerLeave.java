package me.zeronull.spawnarena.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.zeronull.spawnarena.ArenaState;
import me.zeronull.spawnarena.Fight;
import me.zeronull.spawnarena.FightState;
import me.zeronull.spawnarena.SpawnArena;

public class ArenaPlayerLeave implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = (Player) event.getPlayer();

        if(!(SpawnArena.arena.getFight() instanceof Fight)) {
            return;
        }

        if(!SpawnArena.arena.getFight().isFighter(player)) {
            return;
        }

        if(SpawnArena.arena.getFight().getState() == FightState.INITALIZING) {
            return;
        }

        SpawnArena.arena.getFight().announceWinner(player);
        SpawnArena.arena.getFight().endFight();
    }
    
}