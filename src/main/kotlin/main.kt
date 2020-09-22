import java.util.*
import kotlin.collections.HashMap

fun main() {
    println("*** Finds maximum consecutive repeating character in a string ***")
    println("Input string:")
    val input = Scanner(System.`in`)
    val strInput: String = input.nextLine()
    //Result
    val result: HashMap<String, Any>? = maxStringByOrNull(getBigSeq(strInput))
    if (result == null) {
        println("Empty String")
    } else {
        println("Character: " + result["letter"] + " \nLength of the sequence: " + result["count"])
    }
}

fun getBigSeq(char_sequence: String): HashMap<Char, Int> {
    val resultHashMap: HashMap<Char, Int> = HashMap()
    if (char_sequence.isNotEmpty() && char_sequence.isNotBlank()) {
        var c: Char
        //Create HashMap with letters and count
        for (i in char_sequence.indices) {
            c = char_sequence[i]
            if (resultHashMap.containsKey(c)) {
                resultHashMap[c] = resultHashMap[c]!! + 1
            } else {
                resultHashMap[c] = 1
            }
        }
    }
    return resultHashMap
}

fun maxStringByOrNull(resultHashMap: HashMap<Char, Int>): HashMap<String, Any>? {
    val result: HashMap<String, Any>? = HashMap()
    var maxValue = 0
    var maxElem = ""

    resultHashMap.forEach { (c, n) ->
        if (n > maxValue) {
            maxValue = n
            maxElem = c.toString()
        } else {  //Multiples char with same count
            if (n == maxValue) {
                maxElem += ",$c"
            }
        }
    }
    result?.put("letter",maxElem)
    result?.put("count", maxValue)
    return result
}