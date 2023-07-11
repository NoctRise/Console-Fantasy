import classes.misc.Battle
import classes.misc.Inventar
import classes.misc.Potion
import classes.character.Team
import classes.character.gegner.Bahamut
import classes.character.held.DunkelRitter
import classes.character.held.HeldenTeam
import classes.character.held.SchwarzMagier
import classes.character.held.WeissMagier


fun main() {


    try {
        val gegnerTeam = Team(
            mutableListOf(
                Bahamut()
            )
        )

        val heldenTeam = HeldenTeam(
            mutableListOf(
                DunkelRitter(),
                WeissMagier(),
                SchwarzMagier()
            ),
            Inventar(
                mutableListOf(
                    Potion("Heiltrank", 3),
                    Potion("Stärkungstrank", 1),
                    Potion("Intelligenztrank", 2),
                    Potion("Allheilmittel", 2)

                )
            )
        )

        val battle = Battle(heldenTeam, gegnerTeam)
        battle.startBattle()
    } catch (e: Exception) {
        println(e.message)
    }


}
