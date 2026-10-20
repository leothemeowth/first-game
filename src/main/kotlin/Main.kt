enum class Emotion { Euphoric, Sad, Angry, Serene }
enum class Role { Fighter, Wizard, Bard, Techmancer }
enum class Element { Light, Dark, Water, Fire, Wind, Earth, Lightning, Discord, Harmony, Thunder, Rust, Barrier, Combustion, Blood, Runic, Code }
enum class Item { Chalice, Blade }

const val ruby = "ruby"

fun main() {
    val playerName = readPlayerName()
    val role = readPlayerRole()
    greetPlayerByRole(role)

    val emotion = readPlayerEmotion()

    val element: Element = when (role) {
        Role.Bard -> when (emotion) {
            Emotion.Euphoric -> Element.Light
            Emotion.Sad -> Element.Water
            Emotion.Angry -> Element.Discord
            Emotion.Serene -> Element.Harmony
        }

        Role.Fighter -> when (emotion) {
            Emotion.Euphoric -> Element.Wind
            Emotion.Sad -> Element.Earth
            Emotion.Angry -> Element.Fire
            Emotion.Serene -> Element.Barrier
        }

        Role.Wizard -> when (emotion) {
            Emotion.Angry -> Element.Dark
            Emotion.Euphoric -> Element.Combustion
            Emotion.Sad -> Element.Blood
            Emotion.Serene -> Element.Runic
        }

        Role.Techmancer -> when (emotion) {
            Emotion.Euphoric -> Element.Thunder
            Emotion.Angry -> Element.Lightning
            Emotion.Sad -> Element.Rust
            Emotion.Serene -> Element.Code
        }
    }

    println("your element is $element")

    val inventory = mutableListOf<Item>()
    if (element == Element.Light) {
        inventory.add(Item.Chalice)
    }
    if (element == Element.Dark) {
        inventory.add(Item.Blade)
    }
}

fun readPlayerName(): String {
    println("$ruby: whats your name?")
    val playername = readln()
    println("$ruby: hello $playername")
    return playername
}

fun readPlayerRole(): Role {
    var role: Role? = null
    while (role == null) {
        println("$ruby :whats your role?")
        println("1. fighter")
        println("2. bard")
        println("3. wizard")
        println("4. techmancer")
        val roleInput = readln()

        when (roleInput) {
            "1" -> {
                role = Role.Fighter
            }

            "2" -> {
                role = Role.Bard
            }

            "3" -> {
                role = Role.Wizard
            }

            "4" -> {
                role = Role.Techmancer
            }

            else -> {
                println("$ruby oh well if you wont cooperate you get nothing XD")
                println("jk please press enter and state a actual role....")
                readln()
            }
        }
    }
    return role
}

fun readPlayerEmotion(): Emotion {
    var emotion: Emotion? = null
    while (emotion == null) {
        println("$ruby: may i ask can i see your emotion?")
        println("choose what emotion to show")
        println("1. Euphoric")
        println("2. sad")
        println("3. angry")
        println("4. Serene")
        val emotionInput = readln()

        when (emotionInput) {
            "1" -> {
                emotion = Emotion.Euphoric
                println("$ruby woah you seem excited")
            }

            "2" -> {
                emotion = Emotion.Sad
                println("$ruby dont try being too blue xD")
            }

            "3" -> {
                emotion = Emotion.Angry
                println("$ruby i respect your passion but dont let anger blind you")
            }

            "4" -> {
                emotion = Emotion.Serene
                println("$ruby you seem cool :D")
            }

            else -> {
                println("$ruby oh well if you wont cooperate you get nothing XD")
                println("jk please press enter and state a actual role....")
                readln()
            }
        }
    }
    return emotion
}

fun greetPlayerByRole(role: Role) {
    if (role == Role.Bard) {
        println("$ruby : sing sing as much as you can!")
    }
    if (role == Role.Techmancer) {
        println("$ruby : may you find useful information :)")
    }
    if (role == Role.Fighter) {
        println("$ruby : Dont forget your sword")
    }
    if (role == Role.Wizard) {
        println("$ruby :Try to be Nice ok?")
    }
}
