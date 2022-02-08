/**
 * 策略模式
 * 定义：定义了算法族，分别封装起来，让它们之间可以相互替换。
 * 理解：不写死类的行为（方法）,使用成员对象的方法来完成自己的方法，如鸭子例子中使用flyBehavior.fly()来完成自己的fly()方法
 * 举例：有鸭子类Duck，它们会叫，会飞
 * 现在有绿头鸭和橡皮鸭两种鸭子，绿头鸭子会飞、会呱呱叫，橡皮鸭子不会飞、吱吱叫
 * 优点：灵活，有很好的扩展性
 */

abstract class Duck {
    //鸭子都会飞
    abstract fun fly()

    //鸭子都会叫
    abstract fun quack()
}

interface FlyBehavior {
    fun fly()
}

interface QuackBehavior {
    fun quack()
}

//定义用翅膀飞的行为（正常的鸭子会飞）
class FlyWithWings:FlyBehavior{
    override fun fly() {
        println("I can fly with wings...")
    }
}
//定义不会飞的行为（橡皮鸭不会飞）
class FlyWithNoWay:FlyBehavior{
    override fun fly() {
        println("I can not fly...")
    }
}

//定义呱呱叫的行为
class Quack:QuackBehavior{
    override fun quack() {
        println("quack...")
    }
}

//定义吱吱叫的行为
class Squeak:QuackBehavior{
    override fun quack() {
        println("squeak")
    }
}

//定义绿头鸭
//绿头鸭用翅膀飞、呱呱叫
class MallardDuck(): Duck() {
    lateinit var quackBehavior:QuackBehavior
    lateinit var flyBehavior:FlyBehavior
    constructor(quackBehavior: QuackBehavior,flyBehavior: FlyBehavior) : this() {
        this.quackBehavior = quackBehavior
        this.flyBehavior = flyBehavior
    }

    override fun fly() {
        flyBehavior.fly()
    }

    override fun quack() {
        quackBehavior.quack()
    }
}

//定义橡皮鸭
//橡皮鸭不会飞、吱吱叫
class RubberDuck():Duck(){
    lateinit var quackBehavior:QuackBehavior
    lateinit var flyBehavior:FlyBehavior
    constructor(quackBehavior: QuackBehavior,flyBehavior: FlyBehavior) : this() {
        this.quackBehavior = quackBehavior
        this.flyBehavior = flyBehavior
    }

    override fun fly() {
        flyBehavior.fly()
    }

    override fun quack() {
        quackBehavior.quack()
    }
}

fun main(){
    val flyWithWings = FlyWithWings()
    val flyWithNoWay = FlyWithNoWay()
    val quack = Quack()
    val squeak = Squeak()
//想要实现鸭子不同的行为，只需要在创建对象时传入不同的行为实现类即可，具有很好的扩展性
    val mallardDuck:Duck = MallardDuck(quack,flyWithWings)
    val rubberDuck:Duck = RubberDuck(squeak,flyWithNoWay)

    println("I am mallard duck")
    mallardDuck.fly()
    mallardDuck.quack()
    println("I am rubber duck")
    rubberDuck.fly()
    rubberDuck.quack()
}

//如果不使用策略模式该怎么写？
// 方法写死，不易于扩展，违反开闭原则
/*class MallardDuck: Duck() {
    override fun fly() {
        println("I can fly with wings")
    }

    override fun quack() {
        println("quack")
    }
}

class RubberDuck:Duck(){
    override fun fly() {
        println("I can not fly")
    }

    override fun quack() {
        println("squeak")
    }
}*/

