import java.util.*
import kotlin.collections.ArrayList

/**
 * 适配器模式
 * 定义：将一个类的接口，转换成客户期望的另一个接口，适配器让原来不兼容的类可以合作无间
 * 举例：将火鸡适配成鸟类
 */

//定义一个鸟的接口，鸟可以飞、会吱吱叫
interface Bird{
    fun fly()
    fun squeak()
}

//定义一个火鸡的接口，火鸡火鸡只能飞一小段距离，咯咯叫
interface Turkey{
    fun fly()
    fun goble()
}

//定义一只燕子
class Swallow:Bird{
    override fun fly() {
        println("Swallow can fly with wings")
    }

    override fun squeak() {
        println("squeak")
    }
}

//定义一只火鸡
class WildTurkey : Turkey{

    override fun fly() {
        println("turkey can only fly a short distance")
    }

    override fun goble() {
        println("goble")
    }
}

//定义一个火鸡适配器，将火鸡适配成鸟类
class TurkeyAdapter(private val turkey: Turkey) : Bird{

    override fun fly() {
        turkey.fly()
    }

    override fun squeak() {
        turkey.goble()
    }

}

fun main(){
    //现在我们需要大量的bird，但是bird不够了，只能用Turkey来凑数
    //现在轮到适配器登场
    val birds = ArrayList<Bird>()
        birds.add(Swallow())
        birds.add(Swallow())

    val turkey = WildTurkey()
    val turkeyAdapter = TurkeyAdapter(turkey)
        birds.add(turkeyAdapter)
}

/**
 *jdk中集合类都使用适配器模式
 * list、map、set等类都实现了一个为Iterator的接口
 * interface Iterator{
 *      hasNext()
 *      next()
 *      remove()
 * }
 * 每个集合类都实现了自己的遍历方法
 */

