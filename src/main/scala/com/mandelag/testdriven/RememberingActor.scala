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
            whatISee = x
        }
        case Observe(x) => {
            whatIObserve = x
        }
        case Hear(x) => {
            whatIHear = x
        }
        case Listen(x) => {
            whatIListen = x
        }
    }
}