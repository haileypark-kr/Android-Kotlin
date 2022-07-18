import kotlin.math.max

/*
1. Warrior, Knight, Monster는 체력, 공격력, 방어력이 존재하며 생존 여부를 알수 있어야 한다
2. Knight는 hardAttack 기능이 있고, 이 기능을 사용하기 위해서는 energy가 3 필요하다
3. Warrior는 monster를 특정 마리수 이상 처치하면 Knight로 레벨 업이 가능하다


프로그램 동작 예시
Monster 생성
Monster 아직 살아 있습니다. 체력: 50
Warrior가 공격합니다
Monster 아직 살아 있습니다. 체력: 41
Monster 공격합니다
Warrior는 죽었습니다
Warrior는 죽었습니다

4. Warrior가 레벨업 하는 반복문 작성

 */

open class Warrior(hp: Int, str: Int, def: Int) {
    open val job: String = "Warrior"

    val initialHp = hp // 초기 HP
    var hp: Int = hp
        set(value) {
            field = value
            if (hp > 0) {
                println("$job 아직 살아있습니다. 체력: $hp")
            } else {
                println("$job 죽었습니다.")
            }
        }
    var str: Int // 공격력
    var def: Int // 방어력
    var level: Int = 1
    var killCount: Int = 0
        set(value) {
            field = value
            if (field > 2) {
                this.levelUp()
            }
        }

    init {
        this.hp = hp
        this.str = str
        this.def = def
    }

    fun isAlive(): Boolean {
        return hp > 0
    }

    fun attack(monster: Monster) {
        if (isAlive()) {
            println("$job 공격합니다.")
            val defensed: Boolean = monster.defense(this)
            if (!defensed) {
                killCount++;
            }
        }
    }

    fun defense(monster: Monster): Boolean {
        val damage: Int = max(monster.str - def, 0)// 내가 받는 피해
        if (damage > hp) {
            hp = 0
        } else {
            hp -= damage
        }
        return this.isAlive()
    }

    fun levelUp() {
        level++
        hp = initialHp + (level - 1) * 10 // 체력 올려주기
        str++
        def++

        killCount = 0
        println("레벨이 올랐습니다. 레벨: $level")

        if (level >= 3) {
            println("Knight로 성장이 가능합니다.")
        }
    }

    open fun canGrow(): Boolean {
        return level >= 3
    }

    open fun grow(): Knight {
        return Knight(this)
    }

    override fun toString(): String {
        return "$hp $str $def $level $killCount"
    }
}

class Knight(warrior: Warrior) : Warrior(warrior.hp, warrior.str, warrior.def) {
    override val job: String = "Knight"

    init {
        this.hp = hp + 100
        this.str = str + 10
        this.def = def + 10
    }

}

class Monster(hp: Int, str: Int, def: Int) {
    var hp: Int = hp
        set(value) {
            field = value
            if (hp > 0) {
                println("Monster는 아직 살아있습니다. 체력: $hp")
            } else {
                println("Monster는 죽었습니다.")
            }
        }

    var str: Int // 공격력
    var def: Int // 방어력

    init {
        this.hp = hp
        this.str = str
        this.def = def
    }


    fun isAlive(): Boolean {
        return hp > 0
    }


    fun attack(warrior: Warrior) {
        if (isAlive()) {
            warrior.defense(this)
        }
    }

    fun defense(warrior: Warrior): Boolean {
        val damage: Int = max(warrior.str - def, 0) // 내가 받는 피해
        if (damage > hp) {
            hp = 0
        } else {
            hp -= damage
        }
        return this.isAlive()
    }
}

var war1 = Warrior(100, 10, 5)
println(war1)

val monsters = mutableListOf<Monster>(
    Monster(10, 9, 2),
    Monster(10, 9, 2),
    Monster(9, 5, 2),
    Monster(9, 5, 2),
    Monster(8, 4, 1),
    Monster(10, 9, 2),
    Monster(10, 9, 2)
)

while (!monsters.isEmpty()) {
    war1.attack(monsters.get(0))
    monsters.get(0).attack(war1)

    if (!monsters.get(0).isAlive()) {
        monsters.removeAt(0)
    }

    if (war1.canGrow()) {
        break
    }
}

val knight: Knight = war1.grow()
println(knight)

while (!monsters.isEmpty()) {
    knight.attack(monsters.get(0))
    monsters.get(0).attack(knight)

    if (!monsters.get(0).isAlive()) {
        monsters.removeAt(0)
    }

}