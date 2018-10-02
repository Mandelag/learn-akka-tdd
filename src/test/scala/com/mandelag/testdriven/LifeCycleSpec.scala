package com.mandelag.testdriven

import akka.actor._
import akka.testkit._
import org.scalatest._

class LifeCycleSpec extends TestKit(ActorSystem("test-system"))
    with WordSpecLike
    with MustMatchers
    with StopSystemAfterAll {
    
    "ActorLifeCycle" should {
        "log when start" in {
            fail("Not implemented yet.")
        }
        "log when shutdown" in {
            fail("Not implemented yet.")
        }
        "log when restarted" in {
            fail("Not implemented yet.")
        }
    }

}