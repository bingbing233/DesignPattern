/**
 * 观察者模式
 * 定义：在对象之间定义一对多的依赖，这样一来，当一个对象状态发生改变时，其他对象都会收到通知
 * 理解：挺好理解的，上面说完整了。就是观察者与被观察者的关系
 * 举例：送报员送报纸，当新的报纸到来时，通知多个客户来取报纸
 * 其他：jdk自带也有观察者模式，但使用的是继承而非接口，灵活性没那么高
 */

//观察者，也就是收报纸的客户们
interface Observer{
    fun update()
}

//被观察者，也就是送报员
interface Observable{
    fun addObserver(observer: Observer)
    fun notifyObserver()
    fun removeObserver(observer: Observer)
}

class Person1:Observer{
    override fun update() {
        println("person1 get the paper")
    }
}

class Person2:Observer{
    override fun update() {
        println("person2 get the paper")
    }
}

class Postman:Observable{
    private val observers = ArrayList<Observer>()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObserver() {
        //遍历observer并通知
        for (observer in observers){
            observer.update()
        }
    }
}

fun main(){
    val person1:Observer = Person1()
    val person2:Observer = Person2()

    val postman:Observable = Postman()
    postman.addObserver(person1)
    postman.addObserver(person2)
    postman.notifyObserver()

    println("remove person1")
    postman.removeObserver(person1)
    postman.notifyObserver()
}

