/**
 * 装饰着模式
 * 定义：动态地将责任附加到对象上。想要扩展功能，装饰着提供有别于继承的另一种选择。
 * 理解：如果你想扩展A类的功能，就用与A类相同父类的B类去包装A类吧
 * 举例：制造饮料，饮料加上不同的调料可以变成新的饮料品种，如牛奶+茶可以变成奶茶，如果直接把所有种类的饮料都定义成类，将会出现大量的类，难以管理
 *      我们可以将他们分为饮料和调料，通过层层的包装，来创建新的饮料。
 * 优点：通过包装，可以动态的给类增加功能，具有良好的扩展性
 */

//定义饮料抽象类，所有的饮料都必须继承本类
abstract class Beverage(){
    var mDescription = "unknow beverage"
    //描述
    open fun getDescription():String{
        return mDescription
    }

    //计算饮料价格,必须在子类实现
    abstract fun cost():Int
}

//定义饮料调料类，继承自饮料类，其子类用于包装饮料
abstract class CondimentDecorator:Beverage(){

    abstract override fun getDescription():String
}

//定义牛奶调料
class Milk(private val beverage: Beverage):CondimentDecorator(){


    override fun getDescription(): String {
        return "milk+${beverage.getDescription()}"
    }

    override fun cost(): Int {
        //牛奶的价格+饮料的价格
        return 2+beverage.cost()
    }

}

//定义爆爆珠调料
class Bubble(private val beverage: Beverage):CondimentDecorator(){
    override fun getDescription(): String {
        return "Bubble+${beverage.getDescription()}"
    }

    override fun cost(): Int {
        return 1+beverage.cost()
    }
}

//定义咖啡饮料
class Coffee : Beverage(){
    override fun getDescription(): String {
        return "coffee"
    }

    override fun cost(): Int {
        return 10
    }
}
//定义茶饮料
class Tea:Beverage(){
    override fun getDescription(): String {
        return "tea"
    }

    override fun cost(): Int {
        return 8
    }
}

fun main(){
    //现在我们来制造一杯拿铁（也就是牛奶+咖啡）
    val coffee:Beverage = Coffee()
    val latte = Milk(coffee)
    println("latte: des = ${latte.getDescription()} cost = ${latte.cost()}")

    //再制造一杯爆爆珠奶茶（也就是牛奶+茶+爆爆珠）
    val tea:Beverage = Tea()
    val milk:CondimentDecorator = Milk(tea)
    val bubbleMilkTea:CondimentDecorator = Bubble(milk)
    println("bubbleMilkTea: des = ${bubbleMilkTea.getDescription()} cost = ${bubbleMilkTea.cost()}")
}