fun main(){
    val arr = intArrayOf(0)

    val result = qs(arr, 0, arr.size - 1)

    println(result.asList())
}

fun qs(arr: IntArray, lo: Int, hi: Int): IntArray{
    if (lo >= hi) return arr

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

class LeetCode912 {
    fun sortArray(nums: IntArray): IntArray {
        qs(0, nums.size - 1, nums)
        return nums
    }

    fun qs(lo: Int, hi: Int, arr: IntArray) {
        if (lo >= hi) return

        val pivotIdx = partition(lo, hi, arr)

        qs(lo, pivotIdx - 1, arr)
        qs(pivotIdx, hi, arr)
    }

    fun partition(lo: Int, hi: Int, arr: IntArray):Int {

        val pivot = arr[(lo + hi) / 2]

        var left = lo
        var right = hi

        while (left <= right){
            while (arr[left] < pivot) left++
            while (arr[right] > pivot) right--
            if (left <= right){
                val tmp = arr[left]
                arr[left] = arr[right]
                arr[right] = tmp
                left++
                right--
            }
        }

        return left
    }
}