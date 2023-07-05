import classes.Boss
import classes.Schwarzmagier

fun main() {
    var boss = Boss("Feuerdrache")
    var boss1 = Boss("Wasserdrache")
    var magier = Schwarzmagier("John")

    /*println("${magier.name} setzt Feuerball ein.")
    println("${magier.name} hat ${magier.feuerBall(boss)} gemacht.")
    println("${boss.name} hat nur noch ${boss.hp}hp")

    println("${magier.name} setzt Eissturm ein.")
    println("${magier.name} hat ${magier.eisSturm(boss)}dmg gemacht.")
    println("${boss.name} hat nur noch ${boss.hp}hp")

    println("${magier.name} setzt Stockhieb ein.")
    println("${magier.name} hat ${magier.stockHieb(boss)}dmg gemacht.")
    println("${boss.name} hat nur noch ${boss.hp}hp")

    println("${magier.name} setzt Ultima ein.")
    println("${magier.name} hat ${magier.ultima(listOf(boss, boss1))}dmg gemacht.")
    println("${boss.name} hat nur noch ${boss.hp}hp")
    println("${boss1.name} hat nur noch ${boss1.hp}hp")*/

    while (true) {
        magier.attack(listOf(boss, boss1))
    }


}