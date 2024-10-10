package io.vbytsyuk.dnd.db.condition

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.vbytsyuk.dnd.db.Id

@Entity
data class ConditionEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val description: String,
)
