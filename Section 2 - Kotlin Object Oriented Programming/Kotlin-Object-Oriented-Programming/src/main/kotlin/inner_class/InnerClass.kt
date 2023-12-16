package inner_class
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.jvm.isAccessible

fun main() {
//    val boss = Boss("Madun")
//    val employee = Boss.Employee("Rafi")
//
//    employee.ask()
//    boss.answer()


    val bossInner = Boss("Madun")
    val employeeInner = bossInner.Employee("Rafi")

    employeeInner.ask()
    // mencari function yang bersifat private dengan nama `answer` lalu mengaksesnya
    Boss::class.declaredMemberFunctions.find {
        it.name == "answer"
    }?.let {
        it.isAccessible = true
        it.call(bossInner)
    }
}