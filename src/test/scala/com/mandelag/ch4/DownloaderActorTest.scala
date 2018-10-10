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
        "Able to send the URL that has been assigned." in {
            val testUrl = "https://www.bca.co.id/api/sitecore/Marketplace/GetReksadanaKinerjaGridJsonAll?_=1539184962533"
            val mutualFundsDownloader = system.actorOf(DownloaderActor.props(testUrl))
            mutualFundsDownloader ! DownloaderActor.Fetch()
            expectMsg(testUrl)
        }
    }
}