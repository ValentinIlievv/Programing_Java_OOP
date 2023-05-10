package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood{

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        List<Gun> guns = (List<Gun>) mainPlayer.getGunRepository().getModels();
        List<Player> players = (List<Player>) civilPlayers;

        while (!mainPlayer.getGunRepository().getModels().isEmpty() || civilPlayers.isEmpty()){
            Gun gun = guns.get(0);
            Player player = players.get(0);
           if (gun.canFire()){
               int lifePointsToTake = gun.fire();
               player.takeLifePoints(lifePointsToTake);
               if (!player.isAlive()){
                   civilPlayers.remove(player);
                   players.remove(0);
               }
           }
           else {
               guns.remove(0);
               mainPlayer.getGunRepository().remove(gun);
           }

        }
        boolean civilGunsAreEmpty = false;
        if (mainPlayer.getGunRepository().getModels().isEmpty() || !civilPlayers.isEmpty()) {
            while (mainPlayer.isAlive() || civilGunsAreEmpty) {
                Player civilPlayer = players.get(0);
                List<Gun> civilPlayerGuns = (List<Gun>) civilPlayer.getGunRepository().getModels();
                if (civilPlayerGuns.isEmpty()){
                    civilGunsAreEmpty = true;
                }
                Gun civilPlayerGun = civilPlayerGuns.get(0);
                if (civilPlayerGun.canFire()) {
                    int lifePointsToTake = civilPlayerGun.fire();
                    mainPlayer.takeLifePoints(lifePointsToTake);

                }
                else {
                    civilPlayerGuns.remove(0);
                    civilPlayer.getGunRepository().getModels().remove(civilPlayerGun);
                }
            }
        }


    }
}
