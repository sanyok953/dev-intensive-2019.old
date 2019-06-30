package ru.skillbranch.devintensive.utils

object Utils {

    fun charTranslit(value: String): String? {
        var charsMap = mutableMapOf<String, String>()
        var resp: String? = null
        charsMap.put("а", "a")
        charsMap.put("б", "b")
        charsMap.put("в", "v")
        charsMap.put("г", "g")
        charsMap.put("д", "d")
        charsMap.put("е", "e")
        charsMap.put("ё", "e")
        charsMap.put("ж", "zh")
        charsMap.put("з", "z")
        charsMap.put("и", "i")
        charsMap.put("й", "i")
        charsMap.put("к", "k")
        charsMap.put("л", "l")
        charsMap.put("м", "m")
        charsMap.put("н", "n")
        charsMap.put("о", "o")
        charsMap.put("п", "p")
        charsMap.put("р", "r")
        charsMap.put("с", "s")
        charsMap.put("т", "t")
        charsMap.put("у", "u")
        charsMap.put("ф", "f")
        charsMap.put("х", "h")
        charsMap.put("ц", "c")
        charsMap.put("ч", "ch")
        charsMap.put("ш", "sh")
        charsMap.put("щ", "sh'")
        charsMap.put("ъ", "")
        charsMap.put("ы", "i")
        charsMap.put("ь", "")
        charsMap.put("э", "e")
        charsMap.put("ю", "yu")
        charsMap.put("я", "ya")

        if (charsMap.containsKey(value)) {
            resp = charsMap.getValue(value)
        }
        return resp
    }
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        if (fullName == null || fullName == "" || fullName == " ") {
            return null to null
        }

        var parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO("not implemented")
    }

    fun skl(digit: Long, type: Int): String {
        val array1 : Array<String> = arrayOf("минуту", "минуты", "минут")
        val array2 : Array<String> = arrayOf("час", "часа", "часов")
        val array3 : Array<String> = arrayOf("день", "дня", "дней")
        val array: Array<String> = if (type == 1) array1 else if (type == 2) array2 else array3
        return when(digit % 10) {
            1L -> array[0]
            2L, 3L, 4L -> array[1]
            else -> array[2]
        }

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initF: String? = null
        var initL: String? = null

        if (firstName != null) {
            for (c in firstName) {
                if (charTranslit(c.toString()) != null) {
                    initF = charTranslit(c.toString())?.toUpperCase()
                } else {
                    initF = c.toString().toUpperCase()
                }
                break
            }

        }

        if (lastName != null) {
            for (ch in lastName) {
                if (charTranslit(ch.toString()) != null) {
                    initL = charTranslit(ch.toString())?.toUpperCase()
                } else {
                    initL = ch.toString().toUpperCase()
                }
                break
            }

        }

        return "$initF$initL"
    }

}