package stack

interface Stack {
    fun peek(): Int

    fun isEmpty(): Boolean

    fun push(value: Int)

    fun popup(): Int

    fun isFull(): Boolean
}