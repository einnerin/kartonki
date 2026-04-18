package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "word_set_membership",
    primaryKeys = ["wordId", "setId"],
    indices = [Index("setId")],
)
data class WordSetMembershipEntity(
    val wordId: Long,
    val setId: Long,
)
