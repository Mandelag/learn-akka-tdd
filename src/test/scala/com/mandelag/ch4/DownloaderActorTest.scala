package com.mandelag.ch4

import akka.actor._
import akka.testkit._
import org.scalatest._
import com.mandelag.testdriven.StopSystemAfterAll

class DownloaderActorTest extends TestKit(ActorSystem("test-system"))
    with WordSpecLike
    with MustMatchers
    with ImplicitSender
    with StopSystemAfterAll {
    
    "DownloaderActor" must {
        import DownloaderActor._
        val testUrl = "https://www.bca.co.id/api/sitecore/Marketplace/GetReksadanaKinerjaGridJsonAll?_=1539184962533"
            
        "Able to send the URL that has been assigned." in {
            val mutualFundsDownloader = system.actorOf(props(testUrl))
            mutualFundsDownloader ! Fetch()
            expectMsg(testUrl)
        }

        "Give some URL response." in {
            val mutualFundsDownloader = system.actorOf(props(testUrl))
            mutualFundsDownloader ! GetData()
            expectMsgPF() {
                case other => println(other)
            }
        }

    }
}