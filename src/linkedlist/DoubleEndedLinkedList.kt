package linkedlist

fun main() {
    val doubleEndedLinkedList = DoubleEndedLinkedListImpl()
    doubleEndedLinkedList.insertFirst(228)
    doubleEndedLinkedList.insertFirst(227)
    doubleEndedLinkedList.insertLast(229)
    doubleEndedLinkedList.insertLast(229)
    doubleEndedLinkedList.insertLast(230)
    doubleEndedLinkedList.insertFirst(226)
    var currentItem: Node? = doubleEndedLinkedList.getFirst()
    while (currentItem != null) {
        println(currentItem.value)
        currentItem = currentItem.next
    }
}

interface DoubleEndedLinkedList {
    fun insertFirst(value: Int)

    fun insertLast(value: Int)

    fun getFirst(): Node

    fun getLast(): Node
}

//Insert Item - at the beginning and at the end is 0(1)
//Search is O(N)
class DoubleEndedLinkedListImpl() : DoubleEndedLinkedList {
    private var firstItem: Node? = null
    private var lastItem: Node? = null

    override fun insertFirst(value: Int) {
        val newFirstItem = Node(value)
        if (isEmpty()) {
            lastItem = newFirstItem
        }
        newFirstItem.next = firstItem
        firstItem = newFirstItem
    }

    override fun insertLast(value: Int) {
        val newLastItem = Node(value)
        if (isEmpty()) {
            firstItem = newLastItem
        } else {
            lastItem!!.next = newLastItem
        }
        lastItem = newLastItem
    }

    override fun getFirst(): Node {
        return firstItem!!
    }

    override fun getLast(): Node {
        return lastItem!!
    }

    private fun isEmpty() = firstItem == null
}
