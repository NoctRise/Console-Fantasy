import classes.Battle
import classes.character.Team
import classes.character.held.Krieger
import classes.character.gegner.SchwarzDrache
import classes.character.held.HeldenTeam
import classes.character.held.Schwarzmagier
import classes.character.held.Weissmagier


fun main() {


    try {
        val gegnerTeam = Team(
            mutableListOf(
                SchwarzDrache()
            )
        )

        val battle = Battle(HeldenTeam(mutableListOf(Weissmagier(), Schwarzmagier(), Krieger())), gegnerTeam)
        battle.startBattle()
    } catch (e: Exception) {
        println(e.message)
    }


    //val battle = Battle(getBalancedTeam(), gegnerTeam)


}
