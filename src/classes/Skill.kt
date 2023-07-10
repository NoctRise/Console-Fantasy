package classes

import enums.SkillTargeted
import enums.SkillType

class Skill {

    var name: String
    var skillValue: Int
    var skillTargeted: SkillTargeted
    var skillType: SkillType
    var isAoe: Boolean


    init {
        this.name = "No Name"
        this.skillValue = 0
        this.skillTargeted = SkillTargeted.ENEMY
        this.skillType = SkillType.NEUTRAL
        this.isAoe =  false
    }


    // Inspiriert von Gordon Lucas
    constructor(name: String) {
        when (name) {

            // Magier Skills
            "Stockhieb" -> {
                this.name = name
                this.skillValue = 100
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.PHY
            }

            "Feuerball" -> {
                this.name = name
                this.skillValue = 125
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.MAG
            }

            "Eissturm" -> {
                this.name = name
                this.skillValue = 200
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.MAG
            }

            "Ultima" -> {
                this.name = name
                this.skillValue = 350
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.MAG
                this.isAoe = true
            }

            // Weissmagier Skills
            "Basic Attack" -> {
                this.name = name
                this.skillValue = 90
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.MAG
            }

            "ATK-Buff" -> {
                this.name = name
                this.skillValue = 20
                this.skillTargeted = SkillTargeted.ALLY
            }

            "DEF-Buff" -> {
                this.name = name
                this.skillValue = 20
                this.skillTargeted = SkillTargeted.ALLY
            }

            "Heal" -> {
                this.name = name
                this.skillValue = 25
                this.skillTargeted = SkillTargeted.ALLY
            }

            // Krieger Skills
            "Flammenschwert" -> {
                this.name = name
                this.skillValue = 200
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.MAG
            }

            "Chaosklinge" -> {
                this.name = name
                this.skillValue = 150
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.PHY
            }

            "Doppelklinge" -> {
                this.name = name
                this.skillValue = 175
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.PHY
            }

            "Excalibur" -> {
                this.name = name
                this.skillValue = 250
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.PHY

            }

            // Schwarzdrache Skills
            "Drachenklaue" -> {
                this.name = name
                this.skillValue = 100
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.PHY
            }

            "Feueratem" -> {
                this.name = name
                this.skillValue = 100
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.MAG
            }

            "Schwanzhieb" -> {
                this.name = name
                this.skillValue = 100
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.PHY
            }

            "Supernova" -> {
                this.name = name
                this.skillValue = 250
                this.skillTargeted = SkillTargeted.ENEMY
                this.skillType = SkillType.MAG
                this.isAoe = true
            }


            else -> throw Exception("Unbekannter Skill.")
        }
    }
}