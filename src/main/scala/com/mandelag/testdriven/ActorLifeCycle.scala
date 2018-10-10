package com.mandelag.testdriven

import akka.actor._

class Sel extends Actor {
    def receive = {
        case _ => println("hehe") 
    }
}