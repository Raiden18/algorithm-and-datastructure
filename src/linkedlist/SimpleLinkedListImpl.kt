package linkedlist


private fun main() {
    val linkedList = SimpleLinkedListImpl(1)
    linkedList.insert(2)
    linkedList.insert(3)
    linkedList.insert(4)
    linkedList.insert(5)

    var currentItem: Node? = linkedList.getFirst()
    while(currentItem != null){
        println(currentItem.value.toString())
        currentItem = currentItem.next
    }
}

class SimpleLinkedListImpl(firstItem: Int) : SimpleLinkedList {
    private var firstINode: Node

    init {
        firstINode = Node(firstItem)
    }

    override fun insert(value: Int) {
        val newNode = Node(value)
        newNode.next = firstINode
        firstINode = newNode
    }

    override fun getFirst(): Node = firstINode
}