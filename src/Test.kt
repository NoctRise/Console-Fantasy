import classes.Battle
import classes.character.gegner.GegnerTeam
import classes.character.held.Krieger
import classes.character.gegner.SchwarzDrache
import classes.character.held.HeldenTeam
import classes.character.held.Schwarzmagier
import classes.utils.createTeam


fun main() {

    val heldenTeam = createTeam()
    val gegnerTeam = GegnerTeam(mutableListOf(SchwarzDrache()))

    val battle = Battle(heldenTeam, gegnerTeam)
    battle.startBattle()

}
