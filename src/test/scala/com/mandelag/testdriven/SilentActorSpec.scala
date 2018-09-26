package com.mandelag.testdriven;

import akka.testkit._
import akka.actor._
import org.scalatest.{WordSpecLike, MustMatchers}

class SilentActorSpec extends TestKit(ActorSystem("test-silent-actor"))
    with WordSpecLike
    with MustMatchers
    with StopSystemAfterAll {
    
    "RememberingActor" must {
        import RememberingActor._
        
        val rememberingActor = TestActorRef[RememberingActor]
    
        "Melihat state " in {
            rememberingActor ! See("Burung")
            rememberingActor.underlyingActor.whatISee must be("I see Burung")
            rememberingActor ! See("I see")
            rememberingActor.underlyingActor.whatISee must be("I see I see")
        }
        
        "Mendengar state " in {
            val testString = "bzzztststststs"
            rememberingActor ! Hear(testString)
            rememberingActor.underlyingActor.whatIHear must be("I hear bzzztststststs")
        }
        
        
        "Mengamati state " in {
            val testString = "kuda laut loncat"
            rememberingActor ! Observe(testString)
            rememberingActor.underlyingActor.whatIObserve must be("I've observed a kuda laut loncat")
            
        }
        
        "Menyimak state in " in {
            val testString = "Jeff Lyne"
            rememberingActor ! Listen(testString)
            rememberingActor.underlyingActor.whatIListen must be("I listen to Jeff Lyne")
        }
        
    }
}