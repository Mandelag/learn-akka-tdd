package com.mandelag.testdriven

import akka.actor.Actor

object DistanceCalculator {
    case class Coordinate(x: Double, y: Double) {
        override def equals(other: Any) = {
            val EPSILON: Double = 0.001
            other match {
                case Coordinate(x, y) => {
                    (this.x - x) <  EPSILON && (this.y - y) < EPSILON
                }
                case _ => false
            }
        }
    }
    case class CalculateDistance(c1: Coordinate, c2: Coordinate)
    case class CenterPoint(c1: Coordinate, c2: Coordinate)
}


class DistanceCalculator extends Actor {
    import DistanceCalculator._
    
    def receive = {
        case CalculateDistance(c1,c2) => {
           sender() ! calculateDistance(c1,c2)
        }
    }
    
    private def calculateDistance(c1: Coordinate, c2: Coordinate): Double = {
        100.0
    }
}