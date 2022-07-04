import java.util.*

// 배열 선언 방법 1. arrayOf<자료형/생략> (값1, 값2, 값3, ...) = 자료형ArrayOf(값1, 값2, ...)
val array1 = arrayOf(true, "HI", 10, 2.2)
printArray(array1)

val array2 = arrayOf<Int?>(1, 2, null, 3)
printNullableArray(array2)

val array3 = intArrayOf(1, 2, 3)
//printArray(array3) // IntArray라서 타입 mismatch남ㅠ


// 배열 선언 방법 2. 자료형/생략Array(크기, {값/생략가능})
val array4 = Array(10, { 0 })
printNullableArray(array4)
println(array4[1])

//println(array4[10]) // java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10

val array5 = IntArray(10, { 0 })
//val array6 = StringArray(10, { "안" }) // error: unresolved reference: StringArray


// 배열 선언 방법 3. Array<자료형/생략가능>(크기, {값})
val array6 = Array<Int>(10, { 0 })
printArray(array6)

val array7 = Array<String>(5, { "수현" })
printArray(array7)
println(array7[0])
array7[0] = "근일"
println(array7[0])
printArray(array7)

//
val examScore1: Int = 100
val examScore2: Int = 90
val examScore3: Int = 80

val scores = arrayOf(examScore1, examScore2, examScore3)
printArray(scores)


fun printArray(arr: Array<out Any>): Unit {
    // generic에 out 키워드를 쓰는 이유: A가 B를 상속받을 때, class<A>가 class<B>를 상속 받을 수 있게 하는 공변성(Covariance)이 필요하다.
    // 그래서 arr의 제네릭 타입에 out 키워드가 붙은 것이다
    // arr의 elem의 타입이 Any를 상속받을 때, class<elem>도 class<Any>를 상속

    println(Arrays.deepToString(arr))
}

fun printNullableArray(arr: Array<out Any?>): Unit {
    // generic에 out 키워드를 쓰는 이유: A가 B를 상속받을 때, class<A>가 class<B>를 상속 받을 수 있게 하는 공변성(Covariance)이 필요하다.
    // 그래서 arr의 제네릭 타입에 out 키워드가 붙은 것이다
    // arr의 elem의 타입이 Any를 상속받을 때, class<elem>도 class<Any>를 상속

    println(Arrays.deepToString(arr))
}