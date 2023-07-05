import classes.character.Krieger
import classes.character.SchwarzDrache
import classes.character.Schwarzmagier

fun main() {
    val schwarzDrache = SchwarzDrache()
    val magier = Schwarzmagier("John")
    val krieger = Krieger("Artur")

    val heldenGruppe = listOf(magier, krieger)
    val gegnerGruppe = listOf(schwarzDrache)
    val spielFeld = heldenGruppe + gegnerGruppe

    /*
        val heldenGruppe = Team(mutableListOf(magier, krieger))
        val gegnerGruppe = listOf(schwarzDrache)*/



    do {

        heldenGruppe.forEach {
            if (it.isAlive()) {
                it.turn()
                it.attack(gegnerGruppe)
            }

        }


        gegnerGruppe.forEach {
            if (it.isAlive()) {
                schwarzDrache.turn()
                schwarzDrache.attack(heldenGruppe)
            }

        }


        spielFeld.forEach {
            println("${it.name} ${it.currentHP}/${it.maxHP}")
        }
        println()

    } while (magier.isAlive() && schwarzDrache.isAlive())


}
