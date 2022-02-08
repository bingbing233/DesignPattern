/**
 * 单例模式
 * 定义：确保一个类只有一个实例，并提供全局访问点
 * 下面主要列举不同的创建单例的方式
 */

/**
 * 预先创建
 * 优点：简单，容易实现
 * 缺点：程序一开始就初始化，当单例对象比较大时，占用内存
 */
class Singleton1 {
    companion object {
        private val singleton1 = Singleton1()
        fun getInstance(): Singleton1 {
            return singleton1
        }
    }
}

/**
 * 需要时创建
 * 优点：需要时创建，不会在一开始占用内存
 * 缺点：线程不安全，第一创建时，如果两个线程同时进入到  if (singleton2 == null) {  代码块中时，有可能创建两个不同的对象
 */
class Singleton2 {
    companion object {
        private var singleton2: Singleton2? = null
        fun getInstance(): Singleton2 {
            if (singleton2 == null) {
                singleton2 = Singleton2()
            }
            return singleton2 as Singleton2
        }
    }
}

/**
 * 需要时创建（加了同步）
 * 优点：需要时创建，线程安全，每次只允许一个线程访问
 * 缺点：同步锁消耗性能，而且只有在首次创建单例对象时才需要保证线程安全
 */
class Singleton3 {
    companion object {
        private var singleton3: Singleton3? = null
        fun getInstance(): Singleton3 {
            synchronized(this) {
                if (singleton3 == null) {
                    singleton3 = Singleton3()
                }
                return singleton3 as Singleton3
            }
        }
    }
}

/**
 * 双检锁
 * 优点：需要时创建，线程安全，只有在首次创建时才会进入同步锁的代码块，避免性能浪费
 * 缺点：代码比较多
 *
 * volatile:避免jvm的指令重排序
 */
class Singleton4 {
    companion object {
        @Volatile
        private var singleton4: Singleton4? = null

        fun getInstance(): Singleton4 {
            if (singleton4 == null) {
                synchronized(this) {
                    if (singleton4 == null) {
                        singleton4 = Singleton4()
                    }
                }
            }
            return singleton4 as Singleton4
        }
    }
}

/**
 * kotlin的单例
 */
object Singleton5