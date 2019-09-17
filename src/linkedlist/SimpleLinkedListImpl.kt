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

//It gets O(1) time to get first item and O(N) to get random item just like in arrays.
// But it's faster than arrays because it isn't needed any shifts
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