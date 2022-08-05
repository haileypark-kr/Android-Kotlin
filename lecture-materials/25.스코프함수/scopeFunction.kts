class Person(var name: String? = null, var age: Int? = null) {

}

/*
apply
- 객체 초기화할 때 사용
- 초기화 블럭을 밖으로 뺐다고 생각하면 됨.
- this 가 나옴
 */
val p1 = Person().apply {
    name = "수현"
    age = 27
}

/*
also
- 이미 만들어진 객체를 넘겨받아서 it으로 받아오는 것.
- it이 나옴
- 유효성 검사할 때 좋음
- 수신된 객체의 속성을 변경하지 않고 사용할 때. 속성을 변경해야 하면 apply 쓰기
 */
val p2 = Person("수현").also {
    checkName(it.name)
}

fun checkName(name: String?): Boolean {
    println(name)
    return true
}

/*
run (많이 안씀)
- 기본적으로 apply와 동일하지만 변수에 뭐 작업할 때 씀.
- 스코프의 마지막 줄을 리턴
- this
 */

val age10YearsAfter = Person("수현", 20).run {
    age!! + 10
}
println(age10YearsAfter)

/*
with (많이 안씀)
- run과 동일하지만 문법만 좀 다름.
- nullable 타입을 받지 못함
 */

val p4: Person = Person("수현", 20) // Person? 으로 하면 에러.
// only safe (?.) or non-null asserted (!!.) calls are allowed
val age20YearsAfter = with(p4) {
    age!! + 20
}


/*
let (객체가 null이 아닌 경우에는 let 이하를 하겠다 할 때 씀)
- also와 동일
- 마지막 줄을 리턴
- it
 */
val checkName: Boolean = Person("수현").let {
    checkName(it.name)
}
println(checkName)

val listWithNulls: List<String?> = listOf("Kotlin", null)
for (item in listWithNulls) {
    item?.let { println(it) } // prints Kotlin and ignores null
}