package classes.utils

import classes.character.Character

fun calculateDmg(attacker: Character, defender: Character) {
    // TODO
}

fun getUserInput(min: Int = 1, max: Int): Int {
    var eingabe = 0

    do {
        try {
            eingabe = readln().toInt()

            if (eingabe !in min..max)
                throw Exception("Falsche Eingabe")

        } catch (e: Exception) {
            println("Nur Eingaben von $min-$max sind erlaubt.")
        }
    } while (eingabe !in (min..max))
    return eingabe
}