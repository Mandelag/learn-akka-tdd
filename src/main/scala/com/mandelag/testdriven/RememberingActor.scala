package com.mandelag.testdriven

import akka.actor.Actor

object RememberingActor {
    case class See(obj: String)
    case class Observe(obj: String)
    case class Hear(obj: String)
    case class Listen(obj: String)
}

class RememberingActor extends Actor {
    import RememberingActor._
    
    var whatISee = ""
    var whatIObserve = ""
    var whatIHear = ""
    var whatIListen = ""
    
    def receive = {
        case See(x) => {
            whatISee = s"I see $x"
        }
        case Observe(x) => {
            whatIObserve = "I've observed a"
            val y = x.toLowerCase()
            if (y.charAt(0) == 'a' || y.charAt(0) == 'i' || y.charAt(0) == 'u' || y.charAt(0) == 'e'|| y.charAt(0) == 'o' ) whatIObserve += "n"
            whatIObserve += s" $x"
        }
        case Hear(x) => {
            whatIHear = s"I hear $x"
        }
        case Listen(x) => {
            whatIListen = s"I listen to $x"
        }
    }
}