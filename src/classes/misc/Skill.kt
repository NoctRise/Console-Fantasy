package classes.misc

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
        this.isAoe = false
    }


    // Skills mit ihren Stats

    // Inspiriert von Gordon Lucas
    constructor(name: String) {
        when (name) {

            // Magier Skills
            "Stockhieb" -> {
                this.name = name
                this.skillValue = 100
                this.skillType = SkillType.PHY
            }

            "Feuerball" -> {
                this.name = name
                this.skillValue = 125
                this.skillType = SkillType.MAG
            }

            "Eissturm" -> {
                this.name = name
                this.skillValue = 200
                this.skillType = SkillType.MAG
            }

            "Ultima" -> {
                this.name = name
                this.skillValue = 350
                this.skillType = SkillType.MAG
                this.isAoe = true
            }

            // Weissmagier Skills
            "Basic Attack" -> {
                this.name = name
                this.skillValue = 90
                this.skillType = SkillType.MAG
            }

            "ATK-Buff" -> {
                this.name = name
                this.skillValue = 20
                this.skillTargeted = SkillTargeted.ALLY
            }

            "DEF-Buff" -> {
                this.name = name
                this.skillValue = 15
                this.skillTargeted = SkillTargeted.ALLY
            }

            "Heal" -> {
                this.name = name
                this.skillValue = 25
                this.skillTargeted = SkillTargeted.ALLY
            }

            // Dunkelritter Skills
            "Shield" -> {
                this.name = name
                this.skillTargeted = SkillTargeted.ALLY
            }

            "Chaosklinge" -> {
                this.name = name
                this.skillValue = 150
                this.skillType = SkillType.PHY
            }

            "Doppelklinge" -> {
                this.name = name
                this.skillValue = 175
                this.skillType = SkillType.PHY
            }

            "Excalibur" -> {
                this.name = name
                this.skillValue = 250
                this.skillType = SkillType.PHY

            }

            // Bahamut Skills
            "Drachenklaue" -> {
                this.name = name
                this.skillValue = 75
                this.skillType = SkillType.PHY
            }

            "Feueratem" -> {
                this.name = name
                this.skillValue = 90
                this.skillType = SkillType.MAG
            }

            "Schwanzhieb" -> {
                this.name = name
                this.skillValue = 100
                this.skillType = SkillType.PHY
            }

            "Poison Strike" -> {
                this.name = name
                this.skillValue = 10
                this.skillType = SkillType.MAG
            }

            "Summon" -> {
                this.name = name
                this.skillTargeted = SkillTargeted.ALLY
            }

            "Supernova" -> {
                this.name = name
                this.skillValue = 250
                this.skillType = SkillType.MAG
                this.isAoe = true
            }

            // Wyvern Skills
            "Biss" -> {
                this.name = name
                this.skillValue = 95
                this.skillType = SkillType.PHY
            }

            "Blizzard" -> {
                this.name = name
                this.skillValue = 120
                this.skillType = SkillType.MAG
            }

            "Eis Atem" -> {
                this.name = name
                this.skillValue = 100
                this.skillType = SkillType.MAG
            }

            "Blaue Flamme" -> {
                this.name = name
                this.skillValue = 150
                this.skillType = SkillType.MAG
            }

            else -> throw Exception("Unbekannter Skill.")
        }
    }
}