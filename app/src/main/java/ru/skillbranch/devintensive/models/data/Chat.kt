package ru.skillbranch.devintensive.models.data

import ru.skillbranch.devintensive.extensions.shortFormat
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class Chat (
    val id: String,
    val title: String,
    val members: List<User> = listOf(),
    var messages: MutableList<BaseMessage> = mutableListOf(),
    var isArchived: Boolean = false
) {
    fun unreadableMessageCount(): Int {
        // Кол-во непрочитанных
        return 0
    }

    private fun lastMessageDate(): Date? {
        // Последняя дата сообщений в списке messag...
        return Date()
    }

    private fun lastMessageShort(): String {
        // Краткое содержание последнего сообщения
        return "Сообщений еще нет"
    }

    private fun isSingle(): Boolean = members.size == 1

    fun toChatItem(): ChatItem =
        if (isSingle()) {
            val user = members.first()
            ChatItem(
                id,
                user.avatar,
                Utils.toInitials(user.firstName, user.lastName) ?: "??",
                "${user.firstName ?: ""} ${user.lastName ?: ""}",
                lastMessageShort(), // first
                unreadableMessageCount(),
                lastMessageDate()?.shortFormat(),
                user.isOnline
            )
        } else {
            val messageShort = lastMessageShort()
            ChatItem(
                id,
                null,
                "",
                title,
                messageShort, // first
                unreadableMessageCount(),
                lastMessageDate()?.shortFormat(),
                false
                //ChatType.GROUP,
                //messageShort // second
            )
        }
}

enum class ChatType {
    SINGLE,
    GROUP,
    ARCHIVE
}