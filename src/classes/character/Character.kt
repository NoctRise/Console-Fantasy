package classes.character

import classes.misc.Skill
import enums.Stat


open class Character(var name: String) {

    var maxHP = 500
        protected set
    var currentHP = maxHP
        protected set
    var critChance = 5
        protected set
    var defense = 10
        protected set
    var magicDefense = 10
        protected set
    var strength = 1
        protected set
    var intelligence = 1
        protected set
    var skillListe = mutableListOf<Skill>()
    var hasShield = false
    var isPoisoned = false

    fun isAlive() = currentHP > 0


    // printet welche Skills der Character besitzt
    fun printSkills() {
        skillListe.indices.forEach {
            println("[${it + 1}] ${skillListe[it].name}")
        }
    }

    // Reduziert die derzeitige HP
    fun takeDmg(dmg: Int) {
        currentHP -= dmg
        if (currentHP <= 0)
            currentHP = 0
    }

    // Erhöht/heilt die derzeitige HP
    fun heal(hp: Int) {
        currentHP += hp
        if (currentHP > maxHP)
            currentHP = maxHP
    }

    // printet die Stats des Characters aus
    fun printInfo() =
        println("${this.name} HP: ${this.maxHP} Str: ${this.strength} Int: ${this.intelligence} Crit: ${this.critChance}% Def: ${this.defense} MagDef: ${this.magicDefense}")


    //printet den Namen und die derzeitige HP/max HP mit dem Status aus ( Tod, vergiftet, 'Shield' (kann einen Angriff blockieren))
    override fun toString(): String {
        var status = ""

        // Wenn der Character tot ist, füge Icon in den Status ein
        if (!this.isAlive()) {
            status = "☠️"
        } else {
            // Wenn der Character noch am Leben ist und wurde vergiftet, füge Icon in den Status ein
            if (this.isPoisoned) {
                status = "🦠"
            }
            // Wenn der Character noch am Leben ist und es wurde 'Shield' auf ihn gewirkt, füge Icon in den Status ein
            if (this.hasShield)
                status += "🛡️"
        }


        // Gib den Namen currentHP/MaxHP und den Status aus
        return "${this.name}: ${this.currentHP}HP/${this.maxHP}HP  $status"
    }


    // Erhöht Stats um den Wert 'amount'
    fun buff(stat: Stat, amount: Int) {
        when (stat) {
            Stat.MAXHP -> maxHP += amount
            Stat.CRITCHANCE -> critChance += amount
            Stat.DEFENSE -> defense += amount
            Stat.MAGICDEFENSE -> magicDefense += amount
            Stat.STRENGTH -> strength += amount
            Stat.INTELLIGENCE -> intelligence += amount
        }
    }

}