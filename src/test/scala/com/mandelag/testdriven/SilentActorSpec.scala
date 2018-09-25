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
            rememberingActor.underlyingActor.whatISee equals "I see Burung"
            rememberingActor ! See("I see")
            rememberingActor.underlyingActor.whatISee equals "I see I see"
        }
        
        "Mendengar state " in {
            fail("Not implemented yet.")
        }
    }
}