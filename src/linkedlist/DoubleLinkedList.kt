package linkedlist

fun main() {
    val doubleEnded: DoubleLinkedList = DoubleLinkedListImpl()
    doubleEnded.insertFirst(2)
    doubleEnded.insertFirst(3)
    doubleEnded.insertFirst(4)
    doubleEnded.insertLast(5)
    doubleEnded.insertLast(5)

    var currentItem: NodeDoubleEnded? = doubleEnded.getFirst()
    while (currentItem != null) {
        println(currentItem.value)
        currentItem = currentItem.next
    }
    println("-------------------------")
    var currentLast: NodeDoubleEnded? = doubleEnded.getLast()
    while (currentLast != null) {
        println(currentLast.value)
        currentLast = currentLast.previous
    }
}

interface DoubleLinkedList {
    fun insertFirst(value: Int)
    fun insertLast(value: Int)
    fun getFirst(): NodeDoubleEnded
    fun getLast(): NodeDoubleEnded
}

class DoubleLinkedListImpl : DoubleLinkedList {
    private var firstNode: NodeDoubleEnded? = null
    private var lastNode: NodeDoubleEnded? = null

    override fun insertFirst(value: Int) {
        val newNode = NodeDoubleEnded(value)
        if (isEmpty()) {
            lastNode = newNode
            lastNode!!.previous = newNode
            newNode.next = firstNode
            firstNode = newNode
        } else {
            newNode.next = firstNode
            firstNode!!.previous = newNode
            firstNode = newNode
        }
    }

    override fun insertLast(value: Int) {
        val newNode = NodeDoubleEnded(value)
        if (isEmpty()) {
            lastNode = newNode
            firstNode = newNode
            firstNode!!.next = newNode
        } else {
            lastNode!!.next = newNode
        }
        val tempPrevious = lastNode
        lastNode = newNode
        lastNode!!.previous = tempPrevious
    }

    override fun getFirst(): NodeDoubleEnded {
        return firstNode!!
    }

    override fun getLast(): NodeDoubleEnded {
        return lastNode!!
    }

    private fun isEmpty(): Boolean {
        return firstNode == null
    }
}