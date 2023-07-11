package classes.character.gegner

import classes.character.Team
import classes.misc.Skill
import classes.character.held.Held
import classes.utils.printDPSSkillLog

class Bahamut(name: String = "Bahamut") : Boss(name) {

    var hasSummoned = false

    init {
        this.maxHP = 3000
        this.currentHP = maxHP
        this.critChance = 15
        this.defense = 20
        this.magicDefense = 5
        this.strength = 250
        this.intelligence = 150

        this.skillListe = mutableListOf(
            Skill("Drachenklaue"),
            Skill("Feueratem"),
            Skill("Schwanzhieb"),
            Skill("Supernova"),
            Skill("Poison Strike"),
            Skill("Summon")
        )
    }


    fun drachenKlaue(held: Held) {
        printDPSSkillLog(this, held, skillListe[0])
    }

    fun feuerAtem(held: Held) {
        printDPSSkillLog(this, held, skillListe[1])
    }

    fun schwanzHieb(held: Held) {
        printDPSSkillLog(this, held, skillListe[2])
    }

    fun superNova(heldenList: List<Held>) {

        heldenList.forEach {
            printDPSSkillLog(this, it, skillListe[3])
        }
    }

    fun poisonStrike(held: Held) {
        println("${this.name} setzt ${skillListe[4].name} auf ${held.name} ein.")
        held.isPoisoned = true
    }

    fun summon(gegnerTeam: Team) {
        println("${this.name} beschwört 2 Wyvern.")
        gegnerTeam.teamBeitreten(Wyvern())
        gegnerTeam.teamBeitreten(Wyvern())
        Thread.sleep(1000)
    }

    override fun attack(heldenListe: List<Held>, gegnerTeam: Team) {

        when ((1..100).random()) {
            in 1..30 -> drachenKlaue(heldenListe.random())
            in 31..50 -> feuerAtem(heldenListe.random())
            in 51..70 -> schwanzHieb(heldenListe.random())
            in 71..89 -> {
                if (!hasSummoned && !gegnerTeam.isFull()) {

                    summon(gegnerTeam)
                    hasSummoned = true
                } else
                    poisonStrike(heldenListe.random())
            }
            in 90..100 -> superNova(heldenListe)
        }
    }


}