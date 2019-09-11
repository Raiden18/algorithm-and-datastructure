fun Array<Int>.printValues(message: String){
    print(message)
    forEach {
        print("$it, ")
    }
    println()
}