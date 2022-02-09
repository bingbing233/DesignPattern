/**
 * 外观模式
 * 定义：提供了一个统一的接口，用来访问子系统中的一群接口。外观定义一个高层接口，让子系统更加容易使用
 * 理解：把一堆方法封装成一个方法
 * 举例：打开家庭电影模式
 */

interface MovieModel{
    fun watchMovie()
    fun endMovie()
}

class CdPlayer{
    fun turnOn(){}
    fun turnOff(){}
}
class Lamp{
    fun turnOn(){}
    fun turnOff(){}
}
class Screen{
    fun turnOn(){}
    fun turnOff(){}
}
//...
class HomeMovieFacade(private val cdPlayer: CdPlayer, private val lamp: Lamp, private val screen: Screen):MovieModel{
    override fun watchMovie() {
        cdPlayer.turnOff()
        lamp.turnOff()
        screen.turnOn()
    }

    override fun endMovie() {
        cdPlayer.turnOn()
        lamp.turnOn()
        screen.turnOff()
    }
}

fun main(){
    //让我们现在使用外观模式来看电影
    val homeMovieFacade = HomeMovieFacade(CdPlayer(),Lamp(),Screen())
    homeMovieFacade.watchMovie()

    homeMovieFacade.endMovie()
}

//如果不用外观模式呢？
/*
class HomeMovie( val cdPlayer: CdPlayer,  val lamp: Lamp,  val screen: Screen){

}
fun main(){
    //开始电影
    val homeMovie = HomeMovie(CdPlayer(),Lamp(),Screen())
    homeMovie.lamp.turnOff()
    homeMovie.cdPlayer.turnOn()
    homeMovie.screen.turnOn()
    //结束电影
    homeMovie.lamp.turnOn()
    homeMovie.cdPlayer.turnOff()
    homeMovie.screen.turnOff()
}*/
