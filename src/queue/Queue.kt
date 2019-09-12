package queue

interface Queue {
    fun insert(item: Int)

    fun remove(): Int

    fun isFull(): Boolean

    fun isEmpty(): Boolean
}