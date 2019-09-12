package queue

fun main() {
    val queue: Queue = QueueImpl(5)

    for (i in 0 until 5) {
        queue.insert(i)
    }

    if (queue.isFull()) {
        println("Queue is full")
    }

    for (i in 0 until 5) {
        val item = queue.remove()
        println("$item")
    }

    if (queue.isEmpty()) {
        println("Queue is empty")
    }
}

//Items are inserted and removed from the queue in the constant O(1) time
class QueueImpl(private val size: Int) : Queue {
    private val array = arrayOfNulls<Int>(size)
    private var countOfItems = -1

    override fun insert(item: Int) {
        countOfItems++
        array[countOfItems] = item
    }

    override fun remove(): Int {
        val item = array[0]
        array[0] = null
        shiftItemsToLeft()
        countOfItems--
        return item!!
    }

    override fun isFull(): Boolean {
        return countOfItems == size - 1
    }

    override fun isEmpty() = countOfItems == -1

    private fun shiftItemsToLeft() {
        for (i in 1..countOfItems) {
            shiftItemToLeft(i)
        }
    }

    private fun shiftItemToLeft(index: Int) {
        array[index - 1] = array[index]
    }
}