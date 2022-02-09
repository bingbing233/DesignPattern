/**
 * 迭代器模式
 * 理解：就是把遍历封装起来
 */

interface IIterator<T> {
    fun hasNext(): Boolean
    fun  next(): T?
    fun remove(index: Int)
}

data class Food(val name: String, val cost: Int)

class FoodMenu : IIterator<Food> {
    private val foods = ArrayList<Food>()
    private var currentIndex = 0

    fun addFood(food: Food) {
        foods.add(food)
    }

    override fun hasNext(): Boolean {
        return currentIndex < foods.size
    }

    override fun  next(): Food? {
        return if(hasNext()){
            foods[currentIndex++]
        } else{
            null
        }
    }

    override fun remove(index:Int) {
        foods.removeAt(index)
    }
}

fun main(){
    val foodMenu = FoodMenu()
        foodMenu.addFood(Food("chicken",50))
        foodMenu.addFood(Food("noddles",3))
        foodMenu.addFood(Food("pork",30))
        foodMenu.addFood(Food("rice",2))
    //让我们来遍历一下菜单
        while (foodMenu.hasNext()){
            println(foodMenu.next()?.name)
        }
}

/**
 * 其实jdk也提供了一个Iterator接口供我们使用
 * 集合类普遍都实现了collection和Iterator接口，collection提供了更多的多集合操作的方法
 */
