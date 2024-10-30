package org.example

fun main() {
    val list = intArrayOf(11, 72, 53, 8, 19, 20, 30, 23, 45)
    val result = binarySearch(list, 45)

    print(result)
}

fun binarySearch(arr: IntArray, target: Int): Int {

    var low = 0
    var high = arr.size

    arr.sort()
    println(arr.toList())

    while (low < high) {
        val mid = low + (high - low) / 2

        if (arr[mid] == target) {
            return mid
        } else if (arr[mid] > target) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return -1
}