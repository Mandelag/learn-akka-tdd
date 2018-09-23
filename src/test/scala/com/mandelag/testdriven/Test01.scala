package com.mandelag.testdriven

import akka.testkit.{TestKit, TestActorRef, ImplicitSender}
import akka.actor.{ActorSystem, Props}
import org.scalatest.WordSpecLike

class Test01 extends TestKit(ActorSystem("test-system")) 
    with WordSpecLike
    with StopSystemAfterAll {
    
    "DistanceCalculator" must {
        import DistanceCalculator._
        "Calculate distance between two coordinate correctly" in {
            
            val distanceCalculator  = TestActorRef[DistanceCalculator]
            
            distanceCalculator ! CalculateDistance(Coordinate(1, 0), Coordinate(50, 0))
            expectMsg(49)
            
            distanceCalculator ! CalculateDistance(Coordinate(1, 0), Coordinate(-10, 0))
            expectMsg(11)
            
            distanceCalculator ! CalculateDistance(Coordinate(4,0), Coordinate(0,3))
            expectMsg(5)
        }
    }
}