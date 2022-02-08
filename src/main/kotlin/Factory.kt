/**
 * 工厂模式与抽象工厂
 * 抽象工厂就是创建工厂的工厂（说人话就是创建一个类，这个类根据传入的类型来创建不同的具体工厂）
 * 定义：定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类
 * 理解：创建一个专门用于创建对象的类
 * 举例：pizza工厂购买不同种类的pizza的问题
 */

//定义一个pizza抽象类，所有pizza都继承本类
abstract class Pizza {
    abstract fun getDescription():String
}

class CheesePizza : Pizza() {
    override fun getDescription(): String {
        return "cheese pizza"
    }
}

class ClamPizza : Pizza() {
    override fun getDescription(): String {
        return "clam pizza"
    }
}

class NullPizza : Pizza() {
    override fun getDescription(): String {
        return "not a pizza"
    }
}

//定义一个pizza工厂接口，所有的工厂都实现本接口
//由于不同的地方有不同的工厂，每个地方的工厂都要实现本接口
interface PizzaFactory {
    fun createPizza(type: String): Pizza
}

//LA的pizza工厂
class LAPizzaFactory : PizzaFactory {
    override fun createPizza(type: String): Pizza {
        println("here is LA pizza factory")
        return when (type) {
            "cheese" -> CheesePizza()
            "clam" -> ClamPizza()
            else -> {
                NullPizza()
            }
        }
    }
}

//NY的pizza工厂
class NYPizzaFactory : PizzaFactory {
    override fun createPizza(type: String): Pizza {
        println("here is NY pizza factory")
        return when (type) {
            "cheese" -> CheesePizza()
            "clam" -> ClamPizza()
            else -> {
                NullPizza()
            }
        }
    }
}

fun main() {
    //我们现在去LA买一个cheesePizza吧
    val laPizzaFactory = LAPizzaFactory()
    val cheesePizza = laPizzaFactory.createPizza("cheese")
    println(cheesePizza.getDescription())

    //再去NY买一个clamPizza吧
    val nyPizzaFactory = NYPizzaFactory()
    val clamPizza = nyPizzaFactory.createPizza("clam")
    println(clamPizza.getDescription())
}

//那如果不用工厂模式该怎么买pizza呢
//这样写代码冗余，难以维护，当增加pizza种类或者地点时，需要重新修改orderPizza这个方法，不符合开闭原则
/*class PizzaStore(){
    fun orderPizza(place:String,type:String):Pizza{
        if(place == "NY"){
            return when(type){
                "cheese" -> CheesePizza()
                "clam" -> ClamPizza()
                else -> {
                    NullPizza()
                }
            }
        }

        if(place == "LA"){
            return when(type){
                "cheese" -> CheesePizza()
                "clam" -> ClamPizza()
                else -> {
                    NullPizza()
                }
            }
        }
        return NullPizza()
    }
}*/

