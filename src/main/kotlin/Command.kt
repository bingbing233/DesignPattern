/**
 * 命令模式
 * 定义：将请求封装成对象，这可以让你使用不同的请求、队列，或者日志请求来参数化其他对象。命令模式也可以支持撤销操作
 * 举例：遥控器控制不同的开关
 * 优点：遥控器不需要知道自己执行了命令是干什么的，只知道自己执行了第几个命令，实现遥控器了命令的解耦，之后想更换命令，只需要调用setCommand()方法即可。
 */

//定义一个command接口，所有的命令都实现本接口
interface ICommand{
    fun execute()
}

//定义一个开灯的命令
class LightCommand : ICommand{
    private fun turnOnTheLight(){
        println("turn on the light")
    }

    override fun execute() {
        turnOnTheLight()
    }

}

//定义一个开门的命令
class GateCommand : ICommand{
    private fun openTheGate(){
        println("open the gate")
    }

    override fun execute() {
        openTheGate()
    }
}

//定义一个清洁的命令
class CleanCommand:ICommand{
    private fun cleanTheRoom(){
        println("clean the room")
    }

    override fun execute() {
        cleanTheRoom()
    }
}

//定义一个啥也不做的空命令
class NoCommand:ICommand{
    override fun execute() {
        println("do nothing")
    }
}

//遥控器
class RemoteController{
    //假设遥控器只有十个按钮，它只能承载十条命令
    private val commands = Array<ICommand>(10){ NoCommand() }

    fun setCommand(slot:Int,command:ICommand){
        commands[slot] = command
    }

    fun onButtonPress(slot: Int){
        commands[slot].execute()
    }
}

//假如不使用命令模式该怎么写呢？
//这样写违反开闭原则，如果想重新给1号按钮设置命令，只能修改onButtonPress方法中的1->{}
/*
class RemoteController{
    fun onButtonPress(slot: Int){
        when(slot){
            1->{
                //do something
            }
            2->{
                //do something
            }
            3->{
                //do something
            }
            //...
        }
    }
}*/
