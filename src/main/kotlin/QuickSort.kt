fun main(){
    val arr = intArrayOf(9, 3, 7, 4, 69, 420, 42)

    val result = qs(arr, 0, arr.size - 1)

    println(result.asList())
}

fun qs(arr: IntArray, lo: Int, hi: Int): IntArray{
    if (lo >= hi) return intArrayOf()

    val pivotIdx = partition(arr, lo, hi)

    qs(arr, lo, pivotIdx - 1)
    qs(arr, pivotIdx + 1, hi)
    return arr
}

fun partition(arr: IntArray, lo: Int, hi: Int): Int{

    val pivot = arr[hi]

    var idx = lo - 1

    for (i in lo until hi){
        if (arr[i] <= pivot){
            idx++
            val tmp = arr[i]
            arr[i] = arr[idx]
            arr[idx] = tmp
        }
    }

    idx++
    arr[hi] = arr[idx]
    arr[idx] = pivot

    return idx
}