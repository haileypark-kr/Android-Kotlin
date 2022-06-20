val number: Int? = null // 자료형 뒤에 ?가 붙으면 nullable
//val number2: Int = null // 자료형 뒤에 ?가 없으면 붙으면 non-null

// 1. Non-null 타입끼리의 변수 연산
val num2: Int = 3 + 5
val num3: Int = 10
val num4: Int = num2 + num3;
println(num4) // 잘 됨.


// 2. Nullable 타입끼리의 변수 연산
val number2: Int? = 3 + 5
val number3: Int? = 10

//val number4: Int? = number2 + number3; // 동작 안함.
// error: operator call corresponds to a dot-qualified call 'number2.plus(number3)' which is not allowed on a nullable receiver 'number2'.

//println(number2 + number3) // 이것도 위와 동일한 오류.

// 이유 ==> nullable 타입은 실제 런타임에 들어오는 값에 따라 null일 수도 있고, 값이 있을 수도 있음. 런타임에 nullable 변수의 값이 null이 되어버리면 NPE가 뜨는 것.
// ==> 코틀린에서는 nullable 타입끼리의 연산을 막아버리는 것.

// 근데 Nullable 변수의 연산을 아예 막아버리는건 너무 불편 ==> 연산 시에 개발자가 얘 절대 null 아니라고 보장하는 방법도 있음. (쓰지마라)
val number5: Int? = number2!! + number3!!
println(number5) // 잘 됨. 단, 실제로 null 인 경우에는 NPE가 발생.


// 3. null의 비교연산은 가능하다.
if (null == 5) {
    println("same")
} else {
    println("not same")
}

if (null == null) {
    println("same")
} else {
    println("not same")
}