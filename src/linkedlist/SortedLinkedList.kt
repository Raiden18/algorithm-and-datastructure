package linkedlist

fun main() {
    val sortedLinkedList: SimpleLinkedList = SortedLinkedList(5)
    sortedLinkedList.insert(7)
    sortedLinkedList.insert(8)
    sortedLinkedList.insert(6)
    sortedLinkedList.insert(1)
    sortedLinkedList.insert(5)
    sortedLinkedList.insert(5)
    sortedLinkedList.insert(5)
    sortedLinkedList.insert(5)
    sortedLinkedList.insert(8)


    var currentItem: Node? = sortedLinkedList.getFirst()
    while (currentItem != null) {
        println(currentItem.value.toString())
        currentItem = currentItem.next
    }
}

//O(1) to take first item and O(N) to insertFirst items
class SortedLinkedList(firstValue: Int) : SimpleLinkedList {
    private var firstItem: Node
    private var currentInsertedNode: Node? = null

    init {
        firstItem = Node(firstValue)
    }

    override fun insert(value: Int) {
        currentInsertedNode = firstItem
        while (currentInsertedNode != null) {
            if (value >= currentInsertedNode!!.value && currentInsertedNode!!.next == null) {
                insertLastNode(value)
                break
            } else if (value >= currentInsertedNode!!.value && currentInsertedNode!!.next != null && value <= currentInsertedNode!!.next!!.value) {
                insertMiddleNode(value)
                break
            } else if (value < firstItem.value) {
                insertFirstItem(value)
                break
            }
            currentInsertedNode = currentInsertedNode!!.next
        }
    }

    private fun insertLastNode(value: Int){
        val node = Node(value)
        currentInsertedNode!!.next = node
    }

    private fun insertMiddleNode(value: Int){
        val nextNode = currentInsertedNode!!.next
        val node = Node(value)
        node.next = nextNode
        currentInsertedNode!!.next = node
    }

    private fun insertFirstItem(value: Int){
        val savedFirst = firstItem
        firstItem = Node(value)
        firstItem.next = savedFirst
    }

    override fun getFirst(): Node {
        return firstItem
    }
}