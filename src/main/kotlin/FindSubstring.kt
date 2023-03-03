fun findSubstring(s: String, words: Array<String>): List<Int> {
    // 元素, 出现的次数
    val map = HashMap<String, Int>()
    val subLen = words.first().length
    words.forEach {
        if (map.contains(it)) {
            map[it] = map[it]!! + 1
        } else map[it] = 1
    }

    val tmpMap = HashMap<String, Int>(map.size)
    val tmpArr = CharArray(subLen)
    val res = mutableListOf<Int>()
    // 串联子串的长度是固定的,从S左边开始比对的次数也是可以提前知道的,比如S长度为3, 子串长度为2, 那么最多就会查找两次
    loop@ for (i in 0..s.length - words.size * subLen) {
        // 重置map数据
        map.forEach {
            tmpMap[it.key] = it.value
        }
        var tmpIndex = i
        // 循环子串的数量
        for (j in words.indices) {
            // 从S里拿到一个子串去map里比对
            for (k in tmpArr.indices) {
                tmpArr[k] = s[tmpIndex++]
            }
            val tmpWord = String(tmpArr)
            // 没找到或者在s中重复出现但是在words数量不足的话i下标右移,
            if (!tmpMap.contains(tmpWord) || tmpMap[tmpWord]!! < 1) continue@loop

            // 找到的话,数量扣一个
            tmpMap[tmpWord] = tmpMap[tmpWord]!! - 1
        }
        // 走到这里说明words中所有的子串都被匹配了
        res.add(i)
    }

    return res
}


fun main() {
    println(findSubstring("barfoothefoobarman", arrayOf("foo", "bar")))
    println(findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word")))
}