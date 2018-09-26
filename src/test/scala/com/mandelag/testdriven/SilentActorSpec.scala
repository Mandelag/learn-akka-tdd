package com.mandelag.testdriven;

import akka.testkit.{TestActorRef, TestKit, ImplicitSender}
import akka.actor.{ActorSystem, Props}
import org.scalatest.WordSpecLike

class SilentActorSpec extends TestKit(ActorSystem("test-silent-actor"))
    with WordSpecLike 
    with StopSystemAfterAll {
    
    "RememberingActor" must {
        import RememberingActor._
        
        val rememberingActor = TestActorRef[RememberingActor]
    
        "Melihat state " in {
            rememberingActor ! See("Burung")
            assert(rememberingActor.underlyingActor.whatISee.equals("I see Burung"))
            rememberingActor ! See("I see")
            assert(rememberingActor.underlyingActor.whatISee.equals("I see I see"))
        }
        
        "Mendengar state " in {
            val testString = "bzzztststststs"
            rememberingActor ! Hear(testString)
            assert(rememberingActor.underlyingActor.whatIHear.equals("I hear $testString"))
        }
        
        "Mengamati state " in {
            val testString = "kuda laut loncat"
            rememberingActor ! Observe(testString)
            assert(rememberingActor.underlyingActor.whatIObserve.equals("I observed a $testString"))
        }
        
        "Menyimak state in " {
            val testString = "Jeff Lyne"
            rememberingActor ! Listen(testString)
            assert(rememberingActor.underlyingActor.whatIListen.equals("I listen to $testString"))
            
        }
        
    }
}