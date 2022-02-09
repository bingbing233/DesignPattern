/**
 * 模板方法模式
 * 定义：模板方法定义了一个算法步骤，并允许子类为一个或多个步骤提供自己的实现
 * 举例：茶和咖啡都是含有咖啡因的饮料，他们的制作步骤大致相同
 *  茶：烧水 -- 冲茶 -- 添加调料 -- 倒进杯子里
 *  咖啡：烧水 -- 泡咖啡 -- 添加调料 -- 倒进杯子里
 *  我们可以将这几个流程抽象成一个咖啡因饮料抽象类，因为烧水和倒进杯子两个动作是一样的，所以抽象类可以提供具体实现，而其他步骤则由对应的饮料实现
 * 优点：提供一个模板，能够复用大量代码。
 */

abstract class CaffeineBeverage(){

    abstract fun brew()
    abstract fun addCondiment()
    fun boilWater(){
        println("boil water")
    }

    fun pourInCup(){
        println("pour in cup")
    }

    fun prepareRecipe(){
        boilWater()
        brew()
        addCondiment()
        pourInCup()
    }
}

//定义咖啡饮料
class CoffeeBeverage:CaffeineBeverage(){
    override fun brew() {
        println("brew the coffee")
    }

    override fun addCondiment() {
        println("add some condiment into coffee")
    }
}
//定义茶饮料
class TeaBeverage:CaffeineBeverage(){
    override fun brew() {
        println("brew the tea")
    }

    override fun addCondiment() {
        println("add some condiment into tea")
    }
}

fun main(){
    //让我们来冲一杯咖啡吧
    val coffee = CoffeeBeverage()
        coffee.prepareRecipe()
    //再冲一杯茶
    val tea = TeaBeverage()
        tea.prepareRecipe()
}