package com.zcsmart.kclvr

import com.bumptech.glide.Glide.init
import org.junit.Test

import org.junit.Assert.*
import java.util.function.Consumer

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun someOperator(){
        var str:String? = null
        // '?:'使用,当str为空的时候，会取 ?:后的值
        var s = str?.length ?: "b"
        println("the s : $s")
    }

    @Test
    fun testKotlinStrTemplate(){
        //字符串模板，使用 ‘$’ 符号
        var s = 21
        println("the s of content is : $s")
    }

    @Test
    fun loop(){
        var list = listOf("1","2","3")
        for (item in list){
            println(item)
        }

        for (index in list.indices){
            println("index : $index")
        }

        list.filter { it != null }
            .forEach(Consumer<String> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            })
    }

    @Test fun constructor(){
        var person = Person(age = 1)
        println(person)

        var son = Son1("lxq",10)
        println(son)

        var son2 = Son2("son2")
        println("son2 sex : ${son2.sex}")

        var realc = RealC()
        realc.ab()

        CompanionD.createInstance()
    }


    //嵌套类，不持有外部类的引用
    class Person(var name: String = "", var age: Int){

        override fun toString(): String {
            return "name = $name , age = $age"
        }

        class C{

            fun c(){

            }
        }
    }

    //内部类 ，inner定义，持有外部类的引用
    class A{

        private var name = "st"

        //需要持有外部类引用的话，需要定义为inner
        inner class B{

            fun bMethod(){
                var bName = name
            }
        }
    }

    //基类
    open class Father(val name: String){

        //如果基类的属性想要可以被子类覆盖，需要用open修饰
        open val sex = 0

        var fa = 111

        init {
            println("father init.")
        }

        override fun toString(): String {
            return "name = $name"
        }

        //如果想要子类可以覆盖方法，需要使用open修饰
        open fun tvs(){

        }
    }

    //继承Father，并且有主构造函数，如果有主构造函数，那么必须就地初始化父类，调用父类构造函数
    class Son1(name: String) : Father(name){

        private var age: Int = 0

        init {
            println("the son init.")
        }

        //并且，次构造函数必须以this调用主构造函数
        constructor(name: String,age: Int):this(name){
            println("the son second constructor, name : $name , age : $age")
            this.age = age
        }

        override fun toString(): String {
            return "name = $name,age = $age"
        }
    }

    //如果没有主构造函数，那么不需要就地初始化父类
    class Son2 : Father{

        override val sex: Int
            get() = 4

        private val tsf:Int
            get() = 1

        //需要在次构造函数中去使用super调用父类构造
        constructor(name: String):super(name){
            println("fa : $fa")
        }

        //其他次构造函数可以使用this，去调用已经调用过父类的构造函数，或者直接使用super去调用父类构造函数
        constructor(name: String,age: Int):this(name)

        //如果想要子类无法继续覆盖方法，加上final修饰
        final override fun tvs() {
            super.tvs()
        }
    }

    open class BaseAbstract{
         open fun ab(){
             println("the base abstract class of ab method")
         }
    }

    abstract class AAbstract: BaseAbstract() {
        //抽象子类覆盖非抽象基类方法
        abstract override fun ab()
    }

    class RealC : AAbstract(){
        override fun ab() {
            println("RealC ab method")
        }

    }

    class CompanionD{
        companion object{
            fun createInstance(){

            }
        }
    }
}
