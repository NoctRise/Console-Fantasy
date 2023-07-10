import classes.Battle
import classes.character.Team
import classes.character.held.Krieger
import classes.character.gegner.SchwarzDrache
import classes.character.held.Schwarzmagier
import classes.character.held.Weissmagier
import classes.utils.getBalancedTeam


fun main() {


    val gegnerTeam = Team()
    gegnerTeam.teamBeitreten(SchwarzDrache())
    gegnerTeam.teamBeitreten(SchwarzDrache())
    gegnerTeam.teamBeitreten(SchwarzDrache())
    gegnerTeam.teamBeitreten(SchwarzDrache())

    val battle = Battle(getBalancedTeam(), gegnerTeam)
    battle.startBattle()

}
