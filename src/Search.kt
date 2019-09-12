private val arraySearch = arrayOf(4, 3, 9, 5, 7, 8, 1)

private fun main() {
    //Try any type of search
}

private fun tryLinearSearch(value: Int) {
    val isInArray = arraySearch.linearSearch(value)
    println("value is in array: $isInArray")
}

private fun tryBinarySearch(value: Int) {
    val isInArray = arraySearch.binarySearch(value)
    println("value is in array: $isInArray")
}

//Complexity of the linear search is O(N)
private fun Array<Int>.linearSearch(value: Int): Boolean {
    forEach {
        if (it == value) {
            return true
        }
    }
    return false
}

//Complexity of the binary search is O(Log(N))
private fun Array<Int>.binarySearch(value: Int): Boolean {
    var left = 0
    var right = size - 1
    while (left <= right) {
        val middle: Int = (left + right) / 2
        when {
            value > this[middle] -> right = middle - 1
            value < this[middle] -> left = middle + 1
            this[middle] == value -> return true
        }
    }
    return false
}