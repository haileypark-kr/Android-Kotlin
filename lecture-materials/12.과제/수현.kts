//1. 주어진 문자를 N번 반복해서 출력하는 함수를 만들어 보자
println("------------")
fun repeatText(word: String, N: Int) {
    for (number in 1..N) {
        println(word)
    }
}

repeatText("하이", 5)


//2. 1부터 주어진 숫자까지의 합을 구하는 함수를 만들어 보자
println("------------")
fun getSum(num: Int) {
    var res: Int = 0;
    for (i in 1..num) {
        res += i
    }
    println(res)

}
getSum(5)

//3. 1부터 100까지의 수중에서 7의 배수의 합을 구하는 함수를 만드시오
println("------------")
fun get7Sum() {
    var res = 0
    for (i in 1..100) {
        if (i % 7 == 0) {
            res += i
        }
    }
    println(res)
}
get7Sum()

//4. 100 보다 작은 숫자를 넣어주면, 1씩 증가를 시키고 100 이 되면 종료되는 함수를 만드시오
println("------------")
fun get100(num: Int) {
    var num2 = num;
    while (num2 < 100) {
        num2++;
        println(num2)
    }
}
get100(90)

//5. 시험 성적 리스트 [70,71,72,77,78,79,80,82,90,99]
// 와 동일한 크기의 배열을 만들고, 합격이면 true, 불합격이면 false를 담는 함수를 만드시오
// (80점 이상 부터 합격, 정답 예시 (False,False,...))
println("------------")
fun isPass(scores: IntArray) {
    var result = BooleanArray(scores.size);
    for ((index, score) in scores.withIndex()) {
        if (score >= 80) {
            result[index] = true;
        }
    }
    for (r in result) {
        println(r)
    }
}
isPass(intArrayOf(70, 71, 72, 77, 78, 79, 80, 82, 90, 99))


//6. 두개의 주사위를 던졌을때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 함수를 만드시오
//-> [[3,3],[1,5],...]
println("------------")
fun getDicesSum() {
    for (i in 1..6) {
        for (j in 1..6) {
            if (i + j == 6) {
                println("[" + i + "," + j + "]")
            }
        }
    }
}
getDicesSum()

//7. 배부르기 위해서 먹어야하는 총 밥먹기 횟수, 현재 밥먹은 횟수, 두개를 받는 함수를 만드시오
//        함수는 "밥을 먹었다" 한번 출력을 할때 마다 밥을 1회 먹은 것으로 간주를 하고,
//배가 부를 때까지 밥을 먹여야 한다
//        배가 부를 경우에는 "배가 부르다" 를 출력한다
//배가 아무리 불러도 최소 한번은 무조건먹는다
//fun eat(3,2):{}
//->"밥을 먹었다"
//->"배가 부르다"
println("------------")
fun isFull(totalCount: Int, initCount: Int) {
    var currCount = initCount;
    do {
        println("밥을 먹었다.")
        currCount++;
    } while (currCount < totalCount)
    println("배가 부르다.")
}
isFull(3, 2)
isFull(3, 3)

//8. 병사 그룹 2개와 n번째 값을 넣어주면, 각각의 병사 그룹에서 n번째 병사를 제거하고, 두개의 병사
//        그룹을 합쳐주는 함수를 만드시오
//fun abc( ["A", "B", "C", ,"D", "E"] ,  ["A", "B", "C"], 2)
//-> [["A", "B", "D", "E"], ["A", "B"]]
//
//(합수 실행이 어려운 조건을 만나면 null을 리턴해야한다)
//fun abc( ["A", "B", "C", ,"D", "E"] ,  ["A", "B", "C"], 100)
//-> null
println("------------")
fun mergeSoldiers(sol1: List<String>, sol2: List<String>, n: Int): List<List<String>>? {
    if (sol1.size < n || sol2.size < n) {
        return null
    }

    var tempSol1 = mutableListOf<String>()
    for ((i, s) in sol1.withIndex()) {
        if (i != n) {
            tempSol1.add(s)
        }
    }

    var tempSol2 = mutableListOf<String>()
    for ((i, s) in sol2.withIndex()) {
        if (i != n) {
            tempSol2.add(s)
        }
    }

    return listOf<List<String>>(tempSol1, tempSol2)

}

println(mergeSoldiers(listOf<String>("A", "B", "C", "D", "E"), listOf<String>("A", "B", "C"), 2))
println(mergeSoldiers(listOf<String>("A", "B", "C", "D", "E"), listOf<String>("A", "B", "C"), 100))


//9. 단수를 입력 받아 해당 단수의 값을 리스트로 출력하는 함수를 만드시오
//fun abc(3)
//->[3,6,9,12,15,18,21,24,27]
println("------------")
fun getGugu(num: Int): List<Int> {
    var res = mutableListOf<Int>();

    for (i in 1..9) {
        res.add(i * num)
    }

    return res
}
println(getGugu(3))
println(getGugu(9))


//10. 숫자 리스트 두개를 넣어주면 짝수 홀수로 분리된 Map을 만드는 함수를 만드시오
//(Map의 키는 짝수의 경우 "짝수", 홀수의 경우 "홀수" 한다)
println("------------")
fun splitNumbers(list1: List<Int>, list2: List<Int>): Map<String, List<Int>> {
    var map = mutableMapOf<String, List<Int>>();

    var oddList = mutableListOf<Int>() // 홀수
    var evenList = mutableListOf<Int>() // 짝수

    for (n in list1) {
        if (n % 2 != 0) {
            oddList.add(n)
        } else {
            evenList.add(n)
        }
    }

    for (n in list2) {
        if (n % 2 != 0) {
            oddList.add(n)
        } else {
            evenList.add(n)
        }
    }

    map.put("짝수", evenList)
    map.put("홀수", oddList)

    return map;
}

println(splitNumbers(listOf<Int>(1, 2, 3, 4), listOf<Int>(11, 12, 13, 14)))