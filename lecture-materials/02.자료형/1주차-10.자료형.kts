// 변수를 자료형과 함께 선언하는 방법
// --> val / var 변수명: 타입 = 값

// 정수형
val byteInt: Byte = 10
val shortInt: Short = 10
val intInt: Int = 10
val longInt: Long = 10

// 잘못된 범위 넣기
//val wrongByteInt: Byte = 10000 // error: the integer literal does not conform to the expected type Byte
// 잘못된 값 넣기
//val wrongInt: Byte = "안녕" // error: type mismatch: inferred type is String but Byte was expected


// 실수형
// Float 저장 시, 값 뒤에 바로 f 넣어야 한다.
val floatNumber: Float =
    10.0f // error: the floating-point literal does not conform to the expected type Float
// Double 저장 시, 10.0은 되지만 10은 안된다.
val doubleNumber: Double = 10.0
//val doubleNumber2: Double = 10 // error: the integer literal does not conform to the expected type Double


// 논리형
val yes: Boolean = true
val no: Boolean = false


// 문자형
val text1: Char = 'A'
//val text2: Char = 'AA' // error: too many characters in a character literal ''AA''
//val text3: Char = "A" // error: type mismatch: inferred type is String but Char was expected


// 문자열형
val str1: String = "안녕하세요"
val str2: String = "A"
