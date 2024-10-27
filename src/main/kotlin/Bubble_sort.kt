package org.example

fun main() {
    val result = bubbleSort(intArrayOf(2,0,2,1,1,0))
    print(result.asList())
}

fun bubbleSort(arr: IntArray): IntArray {

    for (i in 0 until arr.size){
        for (j in 0 until (arr.size - 1 - i)){

            if (arr[j] > arr[j + 1 ]){
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }

    return arr
}