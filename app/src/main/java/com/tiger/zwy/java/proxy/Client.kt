package com.tiger.zwy.java.proxy

/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:客户
 */
class Client {
    fun registerCompany() {
        val agent: IBusiness = Agent()
        agent.registerCompany()
    }

//    companion object {
//        @JvmStatic
//        fun main(args: Array<String>) {
//            Client().registerCompany()
//        }
//    }

    //    companion object {
//        @JvmStatic
//        fun main(args: Array<String>) {
//            var handler = ProxyHandler(GovDynamicPartment())
//            var business=Proxy.newProxyInstance(ISettle::class.java.classLoader
//                    , arrayOf(ISettle::class.java)
//                    , handler) as ISettle
//            business.settle()
//
//        }
//    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val component: Componet = ConcreteDecorator(ConcreteComponent())
            component.operation()
        }
    }
}