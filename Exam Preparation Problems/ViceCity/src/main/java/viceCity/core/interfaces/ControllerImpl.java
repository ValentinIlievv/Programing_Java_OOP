package viceCity.core.interfaces;

import viceCity.common.ConstantMessages;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;


import java.util.*;

public class ControllerImpl implements Controller{
private Deque<Gun> guns;
private Player mainPlayer;
private List<Player> civilPlayers;

    public ControllerImpl() {
         this.mainPlayer = new MainPlayer();
        this.guns = new ArrayDeque<>();
        this.civilPlayers = new ArrayList<>();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        this.civilPlayers.add(civilPlayer);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        if (type.equals("Pistol")){
            gun = new Pistol(name);
        }
        else if (type.equals("Rifle")){
            gun = new Rifle(name);
        }
        else {
            return ConstantMessages.GUN_TYPE_INVALID;
        }
        this.guns.offer(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.guns.isEmpty()){
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = this.guns.poll();
        if (name.contains("Vercetti")){
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
        }
        Player civilPlayer = null;
        for (Player player : this.civilPlayers){
            if (player.getName().equals(name)){
                civilPlayer = player;
            }
        }
        if (this.civilPlayers == null){
                return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
            }
         civilPlayer.getGunRepository().add(gun);

        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,gun.getName(), name);
    }

    @Override
    public String fight() {
        int civilPlayersGansSize = this.civilPlayers.size();
        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();
        gangNeighbourhood.action(this.mainPlayer, this.civilPlayers);

        if (mainPlayer.getLifePoints() == 100 || this.civilPlayers.size() == civilPlayersGansSize){
            boolean isAllLifePointsAvailable = true;
            for (Player player : this.civilPlayers){
                if (player.getLifePoints() != 50){
                    isAllLifePointsAvailable = false;
                }
            }
            if (isAllLifePointsAvailable){
                return ConstantMessages.FIGHT_HOT_HAPPENED;
            }
        }
       StringBuilder sb = new StringBuilder();
        sb.append("\\\"").append("A fight happened:").append(System.lineSeparator());
        sb.append("Tommy live points: ").append(this.mainPlayer.getLifePoints()).append("!").append(System.lineSeparator());
        int kills = civilPlayersGansSize - this.civilPlayers.size();
        sb.append("Tommy has killed: ").append(kills).append(" players!").append(System.lineSeparator());
        sb.append("Left Civil Players: ").append(this.civilPlayers.size()).append("!");
        return sb.toString();
    }
}
