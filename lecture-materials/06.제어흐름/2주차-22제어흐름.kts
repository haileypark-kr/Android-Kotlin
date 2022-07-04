// if

var number1: Int = 10
if (number1 > 10) {
    println("10+")
} else if (number1 == 10) {
    println("10")
} else {
    println("10-")
}

var number2: Int = if (number1 > 10) 20 else 5;
println(number2)

when (number1) {
    10 -> {
        println("10")
    }
    20 -> println("20")
    else -> {
        println("몰라")
    }
}

number1 = 31
when (number1) {
    in 1..10 -> println("numbers is in 1..10")
    in 11..20 -> println("numbers is in 11..20")
    in 21..30 -> println("numbers is in 21..30")
    else -> println("no")
}