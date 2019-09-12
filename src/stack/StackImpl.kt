package stack

private fun main() {
    val stack: Stack = StackImpl(5)
    for (i in 0 until 5) {
        stack.push(i)
    }

    if (stack.isFull()) {
        println("Stack is full")
    }

    for (i in 0 until 5) {
        val value = stack.popup()
        println("$value")
    }

    if (stack.isEmpty()) {
        println("Stack is empty")
    }
}

/**
 * Items can be both pushed and popped from the stack in constant O(1) time. No comparisons and moves are necessary
 */
private class StackImpl(private val maxSize: Int) : Stack {
    private val array = arrayOfNulls<Int>(maxSize)
    private var countOfItems = -1

    override fun peek(): Int {
        return array[countOfItems]!!
    }

    override fun isEmpty() = countOfItems == -1

    override fun push(value: Int) {
        countOfItems++
        array[countOfItems] = value
    }

    override fun popup(): Int {
        val item = array[countOfItems]
        array[countOfItems] = null
        countOfItems--
        return item!!
    }

    override fun isFull(): Boolean {
        return countOfItems == maxSize - 1
    }
}