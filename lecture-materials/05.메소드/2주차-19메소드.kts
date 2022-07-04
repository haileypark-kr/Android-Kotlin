// 기본형. 단축키: fun2
fun sumNumbers(x: Int, y: Int): Int {
    var result: Int = x + y;
    return result;
}

println(sumNumbers(1, 2));
println(sumNumbers(11, 22));

val result: Int = sumNumbers(2, 5);
println(result);


// 기본값이 있는 함수
fun sumNumbersWithDefaultValue(x: Int = 2, y: Double = 1.1): Double {
    var result = x + y;
    return result;
}

println(sumNumbersWithDefaultValue());
println(sumNumbersWithDefaultValue(2));
println(sumNumbersWithDefaultValue(x = 10, y = 1.4));
println(sumNumbersWithDefaultValue(x = 1));
println(sumNumbersWithDefaultValue(y = 1.4));

// 간단하게 함수 호출
fun sumNumbersWithDefaultValue2(x: Int = 10, y: Double): Double = x + y;
println(sumNumbersWithDefaultValue2(y = 1.5))

fun simpleSub(x: Int, y: Int) = x - y;
println(simpleSub(10, 2))

// 반환값이 없는 함수
fun hello(str: String): Unit {
    println(str + " 님 안녕하세요");
}

hello("수현")

fun hello2(name: String, greeting: String): Unit {
    var msg: String = name + " " + greeting;
    println(msg)
}

hello2("수현아", "안녕")


// 가변인자
fun muptipleNumbers(vararg numbers: Int) {
    println(numbers)
    for (number in numbers) {
        println(number)
    }
}
muptipleNumbers(1, 2, 3, 4, 5)


// 메소드 인자를 reassgin 할 수 없다.

fun test(x: Int): Unit {
//    x = 10 // error: val cannot be reassigned
}
test(20)