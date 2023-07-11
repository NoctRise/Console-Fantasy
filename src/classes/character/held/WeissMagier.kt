package classes.character.held

import classes.misc.Skill
import classes.character.gegner.Gegner
import classes.utils.getRandomName
import classes.utils.printDPSSkillLog
import enums.Stat

class WeissMagier(name: String = getRandomName()) : Held(name) {


    init {
        this.maxHP = 600
        this.currentHP = maxHP
        this.critChance = 5
        this.defense = 15
        this.magicDefense = 15
        this.strength = 40
        this.intelligence = 75
        this.klasse = "Weissmagier"
        this.skillListe = mutableListOf(
            Skill("Basic Attack"),
            Skill("ATK-Buff"),
            Skill("DEF-Buff"),
            Skill("Heal")
        )
    }

    override fun useATKSkill(skill: Skill, gegner: Gegner) {
        when (skill.name) {
            "Basic Attack" -> basicAttack(gegner)
            else -> println("Besitzt diesen Skill nicht")
        }
    }


    override fun useAllySkill(skill: Skill, held: Held) {
        when (skill.name) {
            "ATK-Buff" -> atkBuff(held)
            "DEF-Buff" -> defBuff(held)
            "Heal" -> healAllies(held)
            else -> println("Besitzt diesen Skill nicht")
        }
    }

    fun basicAttack(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[0])
    }

    fun atkBuff(held: Held) {
        println("${this.name} setzt ATK Buff auf ${held.name} ein!")
        val buffValue = 25

        Thread.sleep(1000)
        held.buff(Stat.STRENGTH, buffValue)
        held.buff(Stat.INTELLIGENCE, buffValue)
        println("${held.name}'s Strength und Intelligence ist um $buffValue gestiegen!")

    }

    fun defBuff(held: Held) {
        println("${this.name} setzt ATK Buff auf ${held.name} ein!")
        val buffValue = 15

        Thread.sleep(1000)
        held.buff(Stat.DEFENSE, buffValue)
        held.buff(Stat.MAGICDEFENSE, buffValue)
        println("${held.name}'s Defense und Magic Defense ist um $buffValue gestiegen!")
    }


    fun healAllies(held: Held) {
        println("${this.name} setzt Heal auf ${held.name} ein!")

        val skill = skillListe[3]
        val healAmount = (held.maxHP * (skill.skillValue / 100.0)).toInt()

        println("${held.name} wird um $healAmount geheilt")
        held.heal(healAmount)
        print(held)
    }
}