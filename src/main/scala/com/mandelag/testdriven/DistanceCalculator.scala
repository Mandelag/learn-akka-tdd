package com.mandelag.testdriven

import akka.actor.{Actor, Props}

object DistanceCalculator {
    case class Coordinate(x: Double, y: Double)
    case class CoordinatePair(c1: Coordinate, c2: Coordinate)
}

class DistanceCalculator extends Actor {
    import DistanceCalculator._
    
    def receive = {
        case CoordinatePair(c1,c2) => {
           sender() ! calculateDistance(c1,c2)
        }
    }
    
    private def calculateDistance(c1: Coordinate, c2: Coordinate): Double = {
        100.0
    }
}