package classes.character.gegner

import classes.character.Team
import classes.misc.Skill
import classes.character.held.Held
import classes.utils.printDPSSkillLog

class Bahamut(name: String = "Bahamut") : Boss(name) {

    // Gibt an, ob der Boss Wyvern beschworen hat.
    var hasSummoned = false

    // init der Werte
    init {
        this.maxHP = 3000
        this.currentHP = maxHP
        this.critChance = 15
        this.defense = 20
        this.magicDefense = 5
        this.strength = 250
        this.intelligence = 150

        // fügt Skills hinzu
        this.skillListe = mutableListOf(
            Skill("Drachenklaue"),
            Skill("Feura"),
            Skill("Himmelszorn"),
            Skill("Supernova"),
            Skill("Poison Strike"),
            Skill("Summon")
        )
    }


    // Skill 1, greift einen einzelnen Helden mit einem physischen Skill an und printet es aus
    fun drachenKlaue(held: Held) {
        printDPSSkillLog(this, held, skillListe[0])
    }

    // Skill 2, greift einen einzelnen Helden mit einem magischen Skill an und printet es aus
    fun feura(held: Held) {
        printDPSSkillLog(this, held, skillListe[1])
    }

    // Skill 3, greift einen einzelnen Helden mit einem physischen Skill an und printet es aus
    fun himmelszorn(held: Held) {
        printDPSSkillLog(this, held, skillListe[2])
    }

    // Skill 4, greift alle Helden mit einem magischen Skill an und printet es aus
    fun superNova(heldenList: List<Held>) {

        heldenList.forEach {
            printDPSSkillLog(this, it, skillListe[3])
        }
    }

    // Skill 5, vergiftet einen Helden und lässt ihn jede Runde prozentualen Schaden erleiden
    fun poisonStrike(held: Held) {
        println("${this.name} setzt ${skillListe[4].name} auf ${held.name} ein.\n")
        held.isPoisoned = true
        Thread.sleep(1500)
    }

    // Skill 6, beschwört 2 Wyvern, die in der nächsten Runde angreifen
    fun summon(gegnerTeam: Team) {

        println("${this.name} beschwört 2 Wyvern.")
        gegnerTeam.teamBeitreten(Wyvern("Black Wyvern"))
        gegnerTeam.teamBeitreten(Wyvern("Red Wyvern"))
        Thread.sleep(1500)
    }


    // lässt Bahamut einen zufälligen Helden angreifen.
    override fun attack(heldenListe: List<Held>, gegnerTeam: Team) {

        when ((1..100).random()) {
            in 1..20 -> drachenKlaue(heldenListe.random())
            in 21..40 -> feura(heldenListe.random())
            in 41..60 -> himmelszorn(heldenListe.random())
            in 61..89 -> {

                // Wenn noch nicht beschworen, beschwöre 2 Wyvern
                if (!this.hasSummoned && !gegnerTeam.isFull()) {
                    summon(gegnerTeam)
                    this.hasSummoned = true
                } else
                // Ansonsten setz Poison Strike (Giftangriff) ein
                    poisonStrike(heldenListe.random())
            }

            in 90..100 -> superNova(heldenListe)
        }

    }
}