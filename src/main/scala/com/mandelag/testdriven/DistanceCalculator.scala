package com.mandelag.testdriven

import akka.actor.Actor

object DistanceCalculator {
    case class Coordinate(x: Double, y: Double) {
        override def equals(other: Any) = {
            val EPSILON: Double = 0.001
            other match {
                case Coordinate(x, y) => {
                    Math.abs(this.x - x) <  EPSILON && Math.abs(this.y - y) < EPSILON
                }
                case _ => false
            }
        }
    }
    case class CalculateDistance(c1: Coordinate, c2: Coordinate)
    case class CenterPoint(c1: Coordinate, c2: Coordinate)
}

/** Learning to test Sending Actor (not yet done all of them)
 * Next I will learn about Silent Actor and then Side-effecting Actor.
 */
class DistanceCalculator extends Actor {
    import DistanceCalculator._
    
    def receive = {
        case CalculateDistance(c1,c2) => {
           sender() ! calculateDistance(c1, c2)
        }
        case CenterPoint(c1,c2) => {
            sender() ! centerPoint(c1, c2)
        }
    }
    
    private def calculateDistance(c1: Coordinate, c2: Coordinate): Double = {
        Math.sqrt( Math.pow(c1.x-c2.x, 2) + Math.pow(c1.y-c2.y, 2) )
    }
    
    private def centerPoint(c1: Coordinate, c2: Coordinate): Coordinate = {
        Coordinate(0, 0)
    }
}