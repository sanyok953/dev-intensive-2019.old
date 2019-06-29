package ru.skillbranch.devintensive.utils

object Utils {
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
        TODO("not implemented")
    }
}