val array = arrayOf(4, 1, 9, 5, 7, 8, 1)

fun main() {
    tryBubbleSort()
}

private fun tryBubbleSort() {
    array.printValues("Array before sort ")
    array.bubbleSort()
    array.printValues("Array after bubble sort ")
}

//O(N^2) comparisons and and swaps
private fun Array<Int>.bubbleSort(): Array<Int> {
    for (indexOut in 0 until size) {
        for (indexIn in indexOut until size) {
            val temp = array[indexOut]
            val nextItem = array[indexIn]
            if (temp > nextItem) {
                array[indexOut] = nextItem
                array[indexIn] = temp
            }
        }
    }
    return this
}



