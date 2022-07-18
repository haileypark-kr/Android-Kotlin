/*
계산기1
- 사칙연산에 대응하는 4개의 함수 구현
- 연산이 한번 이루어 질 때 마다 출력을 해야 한다
  (사칙 연산에 대응하는 4개의 함수에서 출력을 하면 안된다)? ==> Setter에서 프린트해라;
 */

class Calculator1 {
    var result: Int = 0
        set(value) {
            field = value
            println(field)
        }

    fun add(num: Int) {
        this.result += num
    }

    fun sub(num: Int) {
        this.result -= num
    }

    fun mul(num: Int) {
        this.result *= num
    }

    fun div(num: Int) {
        this.result /= num
    }
}

var calculator1 = Calculator1()
calculator1.add(10)
calculator1.add(10)
calculator1.add(10)
calculator1.sub(1)
calculator1.mul(2)
calculator1.div(3)


/*
계산기2
- 사칙연산을 할 수 있는 1개의 함수 구현
  ex) calculater.calculate('+', 10)
  ex) calculater.calculate('-', 50)
- 초기값을 할당 할 수 있어야 하며 초기 값을 할당 하지 않은 경우에는 0 을 기본값으로 사용한다
- 불가능한 연산을 요청한 경우 "잘못된 연산 입니다"를 출력 한다
 */
class Calculator2(val initValue: Int = 0) {
    var result: Int = initValue
        set(value) {
            field = value
            println(field)
        }


    fun calculate(type: String, num: Int) {
        if (type == "+") {
            result += num
        } else if (type == "-") {
            result -= num
        } else if (type == "*") {
            result *= num
        } else if (type == "/") {
            result /= num
        } else {
            println("잘못된 연산입니다")
        }
    }
}

var cal2 = Calculator2();
cal2.calculate("+", 10)
cal2.calculate("+", 11)
cal2.calculate("*", 3)
cal2.calculate("%", 3)

var cal3 = Calculator2(10);
cal3.calculate("+", 10)
cal3.calculate("+", 11)
cal3.calculate("*", 3)
cal3.calculate("%", 3)


/*
계산기3
- 사칙연산을 할 수 있는 1개의 함수 구현
- 한번에 여러가지의 연산을 입력 받을 수 있어야 한다
- ex> 더하기3 더하기5 나누기10 곱하기2지
- ex> calculater.calculate(더하기3, 더하기5, 빼기2, 나누기5)
 */

class Calculator3 {
    var result: Int = 0
        set(value) {
            field = value
            println(field)
        }

    fun calculate(requests: List<String>) {

        for (req in requests) {
            val operand: String = req.get(0).toString()
            val value: String = req.slice(1..req.length - 1)
            try {
                _calculate(operand, value.toInt())
            } catch (e: java.lang.IllegalArgumentException) {
                println(e)
            }
        }
    }

    fun _calculate(operand: String, num: Int) {
        when (operand) {
            "+" -> this.result += num
            "-" -> this.result -= num
            "*" -> this.result *= num
            "/" -> this.result /= num
            else -> throw IllegalArgumentException()
        }
    }
}

var cal4 = Calculator3();
cal4.calculate(mutableListOf("+10", "-1", "*20", "/3"))

