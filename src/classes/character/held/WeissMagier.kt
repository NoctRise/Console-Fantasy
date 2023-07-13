package classes.character.held

import classes.misc.Skill
import classes.character.gegner.Gegner
import classes.utils.getRandomName
import classes.utils.printDPSSkillLog
import enums.Stat

class WeissMagier(name: String = getRandomName()) : Held(name) {

    // init der Werte
    init {
        this.maxHP = 600
        this.currentHP = maxHP
        this.critChance = 5
        this.defense = 15
        this.magicDefense = 15
        this.strength = 40
        this.intelligence = 75
        this.klasse = "Weissmagier"

        // fügt Skills hinzu
        this.skillListe = mutableListOf(
            Skill("Basic Attack"),
            Skill("ATK-Buff"),
            Skill("DEF-Buff"),
            Skill("Heal")
        )
    }


    // führt anhand der Parameter einen Angriffsskill auf einen Gegner aus
    override fun useATKSkill(skill: Skill, gegner: Gegner) {
        when (skill.name) {
            "Basic Attack" -> basicAttack(gegner)
            else -> println("Besitzt diesen Skill nicht")
        }
    }

    // führt anhand der Parameter einen Hilfsskill auf einen Helden aus
    override fun useAllySkill(skill: Skill, held: Held) {
        when (skill.name) {
            "ATK-Buff" -> atkBuff(held)
            "DEF-Buff" -> defBuff(held)
            "Heal" -> healAllies(held)
            else -> println("Besitzt diesen Skill nicht")
        }
    }

    // Skill 1, greift einen einzelnen Helden mit einem physischen Skill an und printet es aus
    fun basicAttack(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[0])
    }

    // Skill 2, erhöht die Werte Strength und Intelligence um den Skillvalue von 'ATK-Buff'
    fun atkBuff(held: Held) {
        if (held == this) {
            println("Setzt ATK-Buff auf sich selbst ein!")
        } else
            println("${this.name} setzt ATK-Buff auf ${held.name} ein!")

        val buffValue = Skill("ATK-Buff").skillValue

        // erhöhe die Stats um Buffvalue
        held.buff(Stat.STRENGTH, buffValue)
        held.buff(Stat.INTELLIGENCE, buffValue)


        println("${held.name}'s Strength und Intelligence ist um $buffValue gestiegen!")
        Thread.sleep(1000)
    }

    // Skill 3, erhöht die Werte Defense und Magic Defense um den Skillvalue von 'DEF-Buff'
    fun defBuff(held: Held) {
        if (held == this) {
            println("Setzt Def-Buff auf sich selbst ein!")
        } else
            println("${this.name} setzt Def-Buff auf ${held.name} ein!")

        val buffValue = Skill("DEF-Buff").skillValue

        // erhöhe die Stats um Buffvalue
        held.buff(Stat.DEFENSE, buffValue)
        held.buff(Stat.MAGICDEFENSE, buffValue)

        println("${held.name}'s Defense und Magic Defense ist um ${buffValue}% gestiegen!")
        Thread.sleep(1000)
    }


    // Skill 4, heilt einen Helden um den Skillvalue von Heal
    fun healAllies(held: Held) {
        if (held == this) {
            println("Setzt Heal auf sich selbst ein!")
        } else
            println("${this.name} setzt Heal auf ${held.name} ein!")

        val skill = Skill("Heal")
        // Berechne die % von der MaxHP des Helden
        val healAmount = (held.maxHP * (skill.skillValue / 100.0)).toInt()

        println("${held.name} wird um ${healAmount}HP geheilt")

        // heilt den Helden um Healamount
        held.heal(healAmount)
        println(held)

        Thread.sleep(1000)
    }
}