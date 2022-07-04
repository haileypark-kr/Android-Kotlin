//1. 변수 A와 B를 선언하고, 두 변수의 값이 같은 경우에는 true, 그렇지 않은 경우에는 false가 되는 변수 c를 선언한다
//        단 변수 A와 B의 자료형은 자유이지만 에러가 발생하면 안된다
var a1: String = "안"
var b1: String = "안녕"
var c1: Boolean = if (a1 == b1) true else false
println("=== 1. ===")
println(c1)

//2. 정수형 변수 A를 선언하고, 변수 B를 선언 한다 이때 변수 B는 A의 두배가 되어야 한다
var a2 = 10
var b2 = a2 * 2
println("=== 2. ===")
println(b2)

//3. 학생의 시험 점수를 넣어주면 학점을 반환하는 함수를 만드시오
//        (90점 이상 A학점, 80~89점은 B학점, 70~79점은 C학점, 그렇지 않으면 F학점)
fun getGrate(score: Int): String {
    if (score >= 90) return "A"
    else if (score >= 80) return "B"
    else if (score >= 70) return "C"
    else return "F"
}
println("=== 3. ===")
println(getGrate(100))
println(getGrate(90))
println(getGrate(81))
println(getGrate(71))
println(getGrate(60))

//4. 학생이 시험에서 맞은 문제의 갯수를 넣어주면 시험 점수(정수)를 반환하는 함수를 만드시오
//(시험 문제는 총 20문제이고 만점은 100점)
fun getScore(count: Int): Int {
    val result = count * 5;
    return result;
}
println("=== 4. ===")
println(getScore(1));
println(getScore(10));
println(getScore(15));
println(getScore(20));


//5. nullable 정수형 두개를 받는 함수를 만든다. 이 함수는 받은 인수의 합을 반환한다
//이때 인수중에 null 이 있으면 0으로 취급하여 합을 구한다
fun sumNullable(xn: Int?, yn: Int?): Int {
    var x = if (xn == null) 0 else xn;
    var y = if (yn == null) 0 else yn;

    var result: Int = x + y;
    return result;
}
println("=== 5. ===")
println(sumNullable(10, 20))
println(sumNullable(10, null))
println(sumNullable(null, 5))
println(sumNullable(null, null))
