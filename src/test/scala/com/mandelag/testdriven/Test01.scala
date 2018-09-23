package com.mandelag.testdriven

import akka.testkit.{TestKit, TestActorRef, ImplicitSender}
import akka.actor.{ActorSystem, Props}
import org.scalatest.WordSpecLike

class Test01 extends TestKit(ActorSystem("test-system")) 
    with WordSpecLike
    with StopSystemAfterAll
    with ImplicitSender {
    
    "DistanceCalculator" must {
        "Calculate distance between two coordinate correctly" in {
            import DistanceCalculator._
            val distanceCalculator  = TestActorRef[DistanceCalculator]
            
            distanceCalculator ! CoordinatePair(Coordinate(1, 0), Coordinate(50, 0))
            expectMsg(49)
        }
    }
}