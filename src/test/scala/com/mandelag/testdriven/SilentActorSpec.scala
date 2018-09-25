package com.mandelag.testdriven;

import akka.testkit.{TestActorRef, TestKit, ImplicitSender}
import akka.actor.{ActorSystem, Props}
import org.scalatest.WordSpecLike

class SilentActorSpec extends TestKit(ActorSystem("test-silent-actor"))
    with WordSpecLike 
    with StopSystemAfterAll {
    
    "SilentActor" must {
        "Melihat state " in {
            fail("Not implemented yet!")
        }
        
        "Mendengar state " in {
            fail("Not implemented yet.")
        }
    }
}